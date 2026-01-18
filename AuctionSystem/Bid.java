package AuctionSystem;

import java.util.UUID;

public class Bid {
    private String id;
    private User user;
    private int amount;
    public Bid(User user, int amount)
    {
        this.id= UUID.randomUUID().toString();
        this.user=user;
        this.amount=amount;
    }
    public User getUser() {
        return user;
    }

    public int getAmount() {
        return amount;
    }
}
