package ParkingLotSystem;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String plate) {
        return switch (vehicleType) {
            case CAR -> new Car(plate);
            case MOTORCYCLE -> new Motorcycle(plate);
            case TRUCK -> new Truck(plate);
        };
    }
}