package BootStrapGiftCardAPIDoordash;

public class PaymentInfo {
    private String defaultPaymentMethod;
    private Integer giftCardBalance;

    public PaymentInfo(String defaultPaymentMethod, Integer giftCardBalance)
    {
        this.defaultPaymentMethod=defaultPaymentMethod;
        this.giftCardBalance=giftCardBalance;
    }
    public Integer getGiftCardBalance() {
        return giftCardBalance;
    }

    public String getDefaultPaymentMethod() {
        return defaultPaymentMethod;
    }
}

