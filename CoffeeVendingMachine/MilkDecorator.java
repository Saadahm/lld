package CoffeeVendingMachine;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);  //you can also initialise Coffee coffee and assign it here and return that
    }
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
    public double getCost() {
        return super.getCost() + 2;
    }
}
