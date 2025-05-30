package RestaurantManagementSystem;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private final String id;
    private final Customer customer;
    private final Table table;
    private final LocalDateTime dateTime;
    private boolean active;

    public Reservation(Customer customer, Table table, LocalDateTime dateTime) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.table = table;
        this.dateTime = dateTime;
        this.active = true;
        table.reserve();
    }

    public void cancel() {
        this.active = false;
        table.release();
    }

    // Getters
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Table getTable() { return table; }
    public LocalDateTime getDateTime() { return dateTime; }
    public boolean isActive() { return active; }
}
