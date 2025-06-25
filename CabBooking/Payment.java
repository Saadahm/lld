package CabBooking;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private final String id;
    private final double amount;
    private final LocalDateTime timestamp;
    private final PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.paymentStrategy = paymentStrategy;
    }

    public void process() {
        try {
            paymentStrategy.processPayment(amount);
        } catch (Exception e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    public String getId() { return id; }
}