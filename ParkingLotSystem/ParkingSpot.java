package ParkingLotSystem;

public class ParkingSpot {
    private final String id;

    public VehicleType getAllowed() {
        return allowed;
    }

    private final VehicleType allowed;
    private Vehicle currentVehicle;

    public ParkingSpot(String id, VehicleType allowed) {
        this.id = id;
        this.allowed = allowed;
    }
    public void assignVehicle(Vehicle vehicle){
        if(vehicle.getType() != allowed || currentVehicle != null) {
            throw new IllegalArgumentException("Vehicle type not allowed in this parking spot");
        }
        this.currentVehicle = vehicle;
    }
    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
    public void removeVehicle(){
        this.currentVehicle=null;
    }

    public String getId() {
        return id;
    }
}
