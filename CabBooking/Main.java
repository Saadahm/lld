package CabBooking;

public class Main {
    public static void main(String[] args) {
        Uber uber = Uber.getInstance();

        User alice = new User("Alice", "alice@example.com", 100);
        Driver bob = new Driver("Bob", true, CarType.REGULAR, "555-1234", 105);
        Driver carol = new Driver("Carol", true, CarType.PREMIUM, "555-5678", 95);

        uber.addUser(alice);
        uber.addDriver(bob);
        uber.addDriver(carol);

        // Alice books a REGULAR ride and pays by cash
        uber.bookRide(alice, "Point A", "Point B", CarType.REGULAR, new Cash());

        // Alice books a PREMIUM ride and pays by credit card
        uber.bookRide(alice, "Point A", "Point C", CarType.PREMIUM, new CreditCard());
    }
}
