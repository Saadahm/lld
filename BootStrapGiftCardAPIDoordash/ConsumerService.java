package BootStrapGiftCardAPIDoordash;

import java.util.Map;

public class ConsumerService {
    private Map<String, Consumer> byUserId;
    public ConsumerService(Map<String,Consumer>byUserId)
    {
        this.byUserId=byUserId;
    }

    public Consumer getUserProfile(String userId)
    {
        if(byUserId.get(userId)!=null)
            return byUserId.get(userId);
        throw  new ConsumerNotFoundException("No user found for userId"+ userId);
    }
}