package PizzaPricingSystem;

public class BasePizza implements Pizza{
    private final int basePrice;

    public BasePizza(int basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double subTotal() {
        return basePrice;
    }
}
