package CoffeeVendingMachine;

public abstract class CoffeeDecorator implements Coffee {

    Coffee inner;

    public CoffeeDecorator(Coffee coffee) {
        this.inner = coffee;
    }

    public double getCost() {
        return inner.getCost();

    }

    public String getDescription() {
        return inner.getDescription();
    }

}
