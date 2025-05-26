package test;

public abstract class Vehicle {
    public String licensePlate;
    public String type;

    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
}