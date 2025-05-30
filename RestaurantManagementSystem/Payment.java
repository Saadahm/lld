package RestaurantManagementSystem;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private final String id;
    private final double amount;
    private PaymentStatus status;
    private final LocalDateTime timestamp;
    private final PaymentStrategy paymentStrategy;
    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
        this.timestamp = LocalDateTime.now();
        this.paymentStrategy=paymentStrategy;
    }

    public void process() {
        try {
            paymentStrategy.processPayment(amount);
            status = PaymentStatus.COMPLETED;
        } catch (Exception e) {
            status = PaymentStatus.FAILED;
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    // Getters
    public String getId() { return id; }
    public double getAmount() { return amount; }
    public PaymentStatus getStatus() { return status; }
}