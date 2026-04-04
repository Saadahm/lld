package BootStrapGiftCardAPIDoordash;

import java.util.Map;

public class AddressService {
    private Map<String, Address> byUserId;
    public AddressService(Map<String,Address>byUserId)
    {
        this.byUserId=byUserId;
    }
    public Address getAddress(String userId) {
        Address a=byUserId.get(userId);
        if(a==null)
            throw new AddressNotFoundException("No address found");
        return a;
    }

}

