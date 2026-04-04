package DriverQuestionAPIDoordash;

public class PayoutBreakdown {
    private String deliveryId;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public PayoutBreakdown(int amount, String deliveryId) {
        this.amount = amount;
        this.deliveryId = deliveryId;
    }


}
