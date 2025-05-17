package CoffeeVendingMachine;

public class Espresso implements Coffee{
    @Override
    public double getCost() {
        return 10;
    }
    @Override
    public String getDescription() {
        return "Espresso";
    }
}
