package DigitalWalletDesign;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private List<Account> accountsInvolved;
    private int amount;
    private LocalDateTime timestamp;
    private String description;

    public Transaction(Account sender, Account receiver, int amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.accountsInvolved = new ArrayList<>();
        this.accountsInvolved.add(sender);
        this.accountsInvolved.add(receiver);
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.description = "Transfer from " + sender.getAccountNumber() + " to " + receiver.getAccountNumber();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public List<Account> getAccountsInvolved() {
        return accountsInvolved;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
