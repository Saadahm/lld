package ConcertBookingSystem;

public class Payment {
    private PaymentStrategy paymentStrategy;
    public Payment(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public void pay(){
        paymentStrategy.pay();
    }
}
