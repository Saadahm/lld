package RestaurantManagementSystem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Restaurant {
    private static volatile Restaurant instance;

    private final Map<String, MenuItem> menu = new ConcurrentHashMap<>();
    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    private final Map<String, Reservation> reservations = new ConcurrentHashMap<>();
    private final Map<String, Payment> payments = new ConcurrentHashMap<>();
    private final Map<String, Staff> staff = new ConcurrentHashMap<>();
    private final Map<Integer, Table> tables = new ConcurrentHashMap<>();

    private Restaurant() {
        // Initialize with some default data
        addMenuItem(new MenuItem("Pizza", 12.99));
        addMenuItem(new MenuItem("Burger", 8.99));
        addStaff(new Staff("John", Roles.COOK));
        addStaff(new Staff("Emma", Roles.WAITER));
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            synchronized (Restaurant.class) {
                if (instance == null) {
                    instance = new Restaurant();
                }
            }
        }
        return instance;
    }

    // ===== Menu Management =====
    public void addMenuItem(MenuItem item) {
        menu.put(item.getId(), item);
    }

    public MenuItem getMenuItem(String id) {
        return menu.get(id);
    }

    // ===== Staff Management =====
    public void addStaff(Staff staffMember) {
        staff.put(staffMember.getId(), staffMember);
    }

    public Staff getAvailableStaffByRole(Roles role) {
        return staff.values().stream()
                .filter(s -> s.getRole() == role && s.isAvailable())
                .findFirst()
                .orElse(null);
    }

    // ===== Table Management =====
    public void addTable(Table table) {
        tables.put(table.getId(), table);
    }

    public Table getAvailableTable(int capacity) {
        return tables.values().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= capacity)
                .findFirst()
                .orElse(null);
    }

    // ===== Reservation Management =====
    public Reservation makeReservation(Customer customer, int partySize, LocalDateTime dateTime) {
        Table table = getAvailableTable(partySize);
        if (table == null) throw new IllegalStateException("No available tables");

        Reservation reservation = new Reservation(customer, table, dateTime);
        reservations.put(reservation.getId(), reservation);
        return reservation;
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            reservation.cancel();
            reservations.remove(reservationId);
        }
    }

    // ===== Order Management =====
    public Order placeOrder(Customer customer, List<MenuItem> items) {
        Order order = new Order(customer, items);
        orders.put(order.getId(), order);
        assignCook(order);
        return order;
    }

    private void assignCook(Order order) {
        Staff cook = getAvailableStaffByRole(Roles.COOK);
        if (cook != null) {
            order.assignCook(cook);
        } else {
            System.out.println("No available cooks. Order queued.");
        }
    }

    public void completeOrderPreparation(String orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.updateStatus(OrderStatus.READY);
            assignWaiter(order);
        }
    }

    private void assignWaiter(Order order) {
        Staff waiter = getAvailableStaffByRole(Roles.WAITER);
        if (waiter != null) {
            order.assignWaiter(waiter);
        } else {
            System.out.println("No available waiters. Order ready but not served.");
        }
    }

    public void serveOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.updateStatus(OrderStatus.SERVED);
        }
    }

    public Payment processPayment(Order order, PaymentStrategy strategy) {
        Payment payment = new Payment(order.calculateTotal(), strategy);
        payment.process();
        payments.put(payment.getId(), payment);
        order.setPayment(payment);

        if (payment.getStatus() == PaymentStatus.COMPLETED) {
            order.updateStatus(OrderStatus.COMPLETED);
            if (order.getAssignedCook() != null) order.getAssignedCook().completeTask();
            if (order.getAssignedWaiter() != null) order.getAssignedWaiter().completeTask();
        }

        return payment;
    }
}
