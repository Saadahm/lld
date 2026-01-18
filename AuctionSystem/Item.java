package AuctionSystem;

import java.util.UUID;

public class Item {
    private String id;
    private String name;
    private int amount;

    public Item(String name,int amount) {
        this.amount = amount;
        this.name=name;
        this.id= UUID.randomUUID().toString();
    }
}
