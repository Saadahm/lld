package RestaurantManagementSystem;

import java.util.UUID;

// ===== Staff System =====
public class Staff {
    private final String id;
    private final String name;
    private final Roles role;
    private boolean available;
    private String currentTask;

    public Staff(String name, Roles role) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.role = role;
        this.available = true;
    }

    public void assignTask(String task) {
        this.currentTask = task;
        this.available = false;
        System.out.println(name + " (" + role + ") assigned: " + task);
    }

    public void completeTask() {
        this.currentTask = null;
        this.available = true;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public Roles getRole() { return role; }
    public boolean isAvailable() { return available; }
}