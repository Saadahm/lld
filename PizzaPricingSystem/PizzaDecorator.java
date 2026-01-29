package PizzaPricingSystem;

public abstract class PizzaDecorator implements Pizza{
    private Pizza pizza;
    public PizzaDecorator(Pizza pizza)
    {
        this.pizza=pizza;
    }

    @Override
    public double subTotal()
    {
        return pizza.subTotal();
    }
}
