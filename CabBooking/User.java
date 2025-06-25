package CabBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String contactInfo;
    private final List<Ride> rides;
    private int latLong;

    public User(String name, String contactInfo , int latLong) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
        this.rides=new ArrayList<>();
        this.latLong = latLong;
    }


    // Getters
    public String getId() { return id; }
    public String getName() { return name; }

    public int getLatlong() {
        return latLong;
    }
    public void addRide(Ride r) { rides.add(r); }

    public String getContactInfo() { return contactInfo; }
}