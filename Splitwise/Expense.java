package Splitwise;

import java.util.List;
import java.util.UUID;

public class Expense {
    private String expenseId;
    private String description;
    private double totalAmount;
    private List<Split>splits;
    private String groupId;
    private String paidByUserId;
    public Expense(String desc, double amount, String paidBy,
                   List<Split> splits, String group) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = desc;
        this.totalAmount = amount;
        this.paidByUserId = paidBy;
        this.splits = splits;
        this.groupId = group;
    }

    public Expense(String desc, double amount, String paidBy, List<Split> splits) {
        this(desc, amount, paidBy, splits, "");
    }

    public String getExpenseId() {
        return expenseId;
    }
}
