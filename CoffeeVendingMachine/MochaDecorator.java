package CoffeeVendingMachine;

public class MochaDecorator extends CoffeeDecorator{
    Coffee coffee;
    public MochaDecorator(Coffee coffee){
       super(coffee);
    }
    public String getDescription() {
        return super.getDescription() + ", Mocha";
    }
    public double getCost() {
        return super.getCost() + 2.5;
    }
}