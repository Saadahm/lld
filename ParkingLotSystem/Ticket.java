package ParkingLotSystem;

public class Ticket {
    String spotId;
    String ticketId;
    long entryTime;
    long exitTime;
    String licensePlate;
    public Ticket(String ticketId, ParkingSpot spot){
        this.ticketId=ticketId;
        this.spotId=spot.getId();
        this.licensePlate=spot.getCurrentVehicle().getLicensePlate();
        this.entryTime=System.currentTimeMillis();
    }
    public long getParkingDuration() {
        return exitTime - entryTime;
    }

    public void close() {
        this.exitTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }
}
