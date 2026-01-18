package DigitalWalletDesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitalWallet {
    private Map<String, Account> accounts;
    private Map<String, User> users;
    private static DigitalWallet instance;

    private DigitalWallet() {
        this.accounts = new HashMap<>();
        this.users = new HashMap<>();
    }

    public static DigitalWallet getInstance() {
        if (instance == null) {
            synchronized (DigitalWallet.class) {
                if (instance == null)
                    instance = new DigitalWallet();
            }
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addAccount(Account a) {
        accounts.put(a.getAccountNumber(), a);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public synchronized boolean transfer(Account sender, Account receiver, int amount, PaymentMethod paymentMethod) {
        if (sender == null || receiver == null) {
            System.out.println("Invalid accounts");
            return false;
        }

        if (sender.getAmount() < amount) {
            System.out.println("Insufficient balance");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }

        sender.setAmount(sender.getAmount() - amount);
        receiver.setAmount(receiver.getAmount() + amount);

        Transaction transaction = new Transaction(sender, receiver, amount);
        sender.addTransaction(transaction);
        receiver.addTransaction(transaction);

        boolean paymentProcessed = paymentMethod.process(amount);

        if (paymentProcessed) {
            System.out.println("Transfer successful: " + amount + " from " + sender.getAccountNumber() + " to " + receiver.getAccountNumber());
        } else {
            sender.setAmount(sender.getAmount() + amount);
            receiver.setAmount(receiver.getAmount() - amount);
            System.out.println("Payment processing failed. Transaction rolled back.");
        }

        return paymentProcessed;
    }

    public void checkBalance(Account account) {
        if (account != null) {
            System.out.println("Account: " + account.getAccountNumber() + " | Balance: " + account.getAmount());
        }
    }

    public void displayTransactionHistory(Account account) {
        if (account == null) {
            System.out.println("Invalid account");
            return;
        }

        System.out.println("\nTransaction History for Account: " + account.getAccountNumber());
        List<Transaction> transactions = account.getTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println("Transaction ID: " + t.getTransactionId() +
                    " | Amount: " + t.getAmount() +
                    " | Time: " + t.getTimestamp() +
                    " | Description: " + t.getDescription());
        }
    }
}
