package test;

public class Main {
    public static void main(String[] args) {
        Vehicle car   = new Car("CAR-111");
        Vehicle truck = new Truck("TRK-999");

        System.out.println("Car plate:   " + car.licensePlate   + ", type: " + car.type);
        System.out.println("Truck plate: " + truck.licensePlate + ", type: " + truck.type);

        // Even if we printed car again, it's unchanged:
        System.out.println("Car still:   " + car.licensePlate   + ", type: " + car.type);
    }
}