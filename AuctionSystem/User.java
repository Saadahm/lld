package AuctionSystem;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    public User(String name)
    {
        this.name=name;
        this.id= UUID.randomUUID().toString();
    }
    public void update(String msg){
        System.out.println(msg);
    }
}
