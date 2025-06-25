package CabBooking;

public class Ride {
    private String rideId;
    private CabBooking.Driver driver;
    private User user;
    private String startLocation;
    private String endLocation;
    private double fare;
    private RideStatus status; // e.g., "PENDING", "COMPLETED", "CANCELLED"

    public Ride(String rideId, Driver driver, User user, String startLocation, String endLocation) {
        this.rideId = rideId;
        this.driver = driver;
        this.user = user;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.status = RideStatus.PENDING;
    }

    // Getters and Setters
    public String getRideId() {
        return rideId;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public RideStatus getStatus() {
        return status;
    }
}
