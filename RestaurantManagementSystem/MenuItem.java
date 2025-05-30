package RestaurantManagementSystem;

import java.util.UUID;

public class MenuItem {
    private final String id;
    private final String name;
    private boolean available;
    private final double price;

    public MenuItem(String name, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.available = true;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}