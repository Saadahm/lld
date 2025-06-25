package CabBooking;

import java.util.UUID;

public class Driver {
    private final String id = UUID.randomUUID().toString();
    private final String name;
    private boolean isAvailable;
    private final CarType carType;
    private final String phoneNumber;
    private int latLong;  // simplified as int for demo

    public Driver(String name, boolean isAvailable, CarType carType, String phoneNumber, int latLong) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.carType = carType;
        this.phoneNumber = phoneNumber;
        this.latLong = latLong;
    }
    public String getId() { return id; }
    public boolean isAvailable() { return isAvailable; }
    public CarType getCarType() { return carType; }
    public int getLatLong() { return latLong; }
    public void setAvailable(boolean avail) { this.isAvailable = avail; }
}

