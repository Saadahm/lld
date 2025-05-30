package RestaurantManagementSystem;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();

        // Create customer
        Customer customer = new Customer("Alice", "alice@example.com");

        // Get menu items
        MenuItem pizza = new MenuItem("Pizza", 12.99);
        MenuItem burger = new MenuItem("Burger", 8.99);

        // Place order
        Order order = restaurant.placeOrder(customer, List.of(pizza, burger));

        // Simulate order preparation
        restaurant.completeOrderPreparation(order.getId());

        // Serve order
        restaurant.serveOrder(order.getId());

        // Process payment
        restaurant.processPayment(order, new Cash());

        // Make reservation
        Table table = new Table(1, 4);
        restaurant.addTable(table);
        Reservation reservation = restaurant.makeReservation(
                customer,
                4,
                LocalDateTime.now().plusDays(1)
        );

        // Cancel reservation
        restaurant.cancelReservation(reservation.getId());
    }
}