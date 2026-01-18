package DigitalWalletDesign;

public class Main {
    public static void main(String[] args) {
        DigitalWallet wallet = DigitalWallet.getInstance();

        User user1 = new User("Alice", "alice@example.com");
        User user2 = new User("Bob", "bob@example.com");

        wallet.addUser(user1);
        wallet.addUser(user2);

        Account account1 = new Account(user1, 5000);
        Account account2 = new Account(user2, 3000);

        user1.addAccount(account1);
        user2.addAccount(account2);

        wallet.addAccount(account1);
        wallet.addAccount(account2);

        System.out.println("=== Initial Balances ===");
        wallet.checkBalance(account1);
        wallet.checkBalance(account2);

        System.out.println("\n=== Performing Transfer 1: Alice -> Bob (1000) ===");
        PaymentMethod creditCard = new CreditCard();
        wallet.transfer(account1, account2, 1000, creditCard);

        System.out.println("\n=== Balances After Transfer 1 ===");
        wallet.checkBalance(account1);
        wallet.checkBalance(account2);

        System.out.println("\n=== Performing Transfer 2: Bob -> Alice (500) ===");
        PaymentMethod bankAccount = new BankAccount();
        wallet.transfer(account2, account1, 500, bankAccount);

        System.out.println("\n=== Balances After Transfer 2 ===");
        wallet.checkBalance(account1);
        wallet.checkBalance(account2);

        System.out.println("\n=== Attempting Transfer with Insufficient Balance ===");
        wallet.transfer(account1, account2, 10000, creditCard);

        System.out.println("\n=== Transaction History for Alice ===");
        wallet.displayTransactionHistory(account1);

        System.out.println("\n=== Transaction History for Bob ===");
        wallet.displayTransactionHistory(account2);
    }
}
