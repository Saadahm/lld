package DigitalWalletDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private User user;
    private int amount;
    private String AccountNumber;
    private List<Transaction> transactions;

    public Account() {
        this.AccountNumber = UUID.randomUUID().toString();
        this.transactions = new ArrayList<>();
        this.amount = 0;
    }

    public Account(User user, int initialAmount) {
        this.AccountNumber = UUID.randomUUID().toString();
        this.user = user;
        this.amount = initialAmount;
        this.transactions = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }
}
