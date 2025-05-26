package ParkingLotSystem;

public class FlatRateStrategy implements PricingStrategy {
    private final double ratePerHour;

    public FlatRateStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double calculateFee(long durationMillis) {
        double hours = Math.ceil(durationMillis / 3600000.0);
        return hours * ratePerHour;
    }
}
