package Splitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User implements Observer {
    private String id;
    private Map<String, Double> balances;
    private String email;
    private String name;
    public User(String name, String email){
        this.id= UUID.randomUUID().toString();
        balances=new HashMap<>();
        this.email=email;
        this.name=name;
    }
    @Override
    public void update(String message) {
        System.out.println("[NOTIFICATION TO"+name+"]: "+message);
    }

    public void updateBalance(String otherUserId, double amount)
    {
        balances.put(otherUserId, balances.getOrDefault(otherUserId,0.0)+amount);
        if(Math.abs(balances.get(otherUserId))<0.0)
            balances.remove(otherUserId);
    }

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }
}
