package CabBooking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Uber {
    private Map<String, User> users;
    private Map<String, Driver> drivers;
    private Map<String, Ride> rides;
    private Map<String, Payment> payments;
    private static volatile Uber instance;

    public static Uber getInstance(){
        if (instance == null) {
            synchronized (Uber.class) {
                if (instance == null) instance = new Uber();
            }
        }
        return instance;
    }

    public Uber() {
        this.users = new ConcurrentHashMap<>();
        this.drivers = new ConcurrentHashMap<>();
        this.rides = new ConcurrentHashMap<>();
        this.payments = new ConcurrentHashMap<>();
    }

    public void addUser(User user)
    {
        users.put(user.getId(), user);
    }
    public void addDriver(Driver driver)
    {
        drivers.put(driver.getId(), driver);
    }

    public void bookRide(User user, String startLoc, String endLoc, CarType reqType, PaymentStrategy payMethod) {
        Driver chosen = null;
        int bestDist = Integer.MAX_VALUE;
        for (Driver d : drivers.values()) {
            if (d.isAvailable() && d.getCarType() == reqType) {
                int dist = Math.abs(user.getLatlong() - d.getLatLong());
                if (dist < bestDist) {
                    bestDist = dist;
                    chosen = d;
                }
            }
        }
        if (chosen == null) {
            System.out.println("No drivers of type " + reqType + " available right now.");
            return;
        }
        // create and register ride
        String rideId = user.getId() + "_" + chosen.getId() + "_" + System.currentTimeMillis();
        Ride ride = new Ride(rideId, chosen, user, startLoc, endLoc);
        double fare = calculateFare(startLoc, endLoc, reqType);
        ride.setFare(fare);
        rides.put(rideId, ride);

        // update states
        chosen.setAvailable(false);
        user.addRide(ride);

        // process payment
        Payment payment = new Payment(fare, payMethod);
        payment.process();
        payments.put(payment.getId(), payment);

        System.out.println("Ride " + rideId + " booked! Fare: $" + fare);

    }

    private double calculateFare(String start, String end, CarType type) {
        // stub: demo flat rates
        return type == CarType.PREMIUM ? 20.0 : 10.0;
    }
  

}
