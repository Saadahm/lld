package Splitwise;

import java.util.UUID;

public class Split {
    private String userId;
    private double amount;
    public Split(String userId, double amount)
    {
        this.amount=amount;
        this.userId= UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }
    public double getAmount(){
        return amount;
    }
}
