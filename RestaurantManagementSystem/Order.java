package RestaurantManagementSystem;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private final Customer customer;
    private final List<MenuItem> items;
    private OrderStatus status;
    private Payment payment;
    private Staff assignedCook;
    private Staff assignedWaiter;

    public Order(Customer customer, List<MenuItem> items) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.items = items;
        this.status = OrderStatus.NEW;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        System.out.println("Order " + id + " status updated to: " + newStatus);
    }

    public void assignCook(Staff cook) {
        this.assignedCook = cook;
        cook.assignTask("Preparing order " + id);
        updateStatus(OrderStatus.PREPARING);
    }

    public void assignWaiter(Staff waiter) {
        this.assignedWaiter = waiter;
        waiter.assignTask("Serving order " + id);
        updateStatus(OrderStatus.READY);
    }

    // In Order.java
    public void completeOrder() {
        updateStatus(OrderStatus.COMPLETED);
        if (assignedCook != null) assignedCook.completeTask();
        if (assignedWaiter != null) assignedWaiter.completeTask();
    }

    // Getters
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<MenuItem> getItems() { return Collections.unmodifiableList(items); }
    public OrderStatus getStatus() { return status; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
    // In Order.java
    public Staff getAssignedCook() {
        return assignedCook;
    }

    public Staff getAssignedWaiter() {
        return assignedWaiter;
    }
}