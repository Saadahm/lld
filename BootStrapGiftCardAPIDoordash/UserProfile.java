package BootStrapGiftCardAPIDoordash;

public class UserProfile {
    String name,consumerId, address,paymentMethod;
    Integer giftCardBalance;
    public UserProfile(String name, String consumerId, String paymentMethod, String address, Integer giftCardBalance)
    {
        this.address=address;
        this.name=name;
        this.consumerId=consumerId;
        this.paymentMethod=paymentMethod;
        this.giftCardBalance=giftCardBalance;
    }

}

