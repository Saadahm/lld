package ParkingLotSystem;

public interface PricingStrategy {
    double calculateFee(long durationMillis);
}
