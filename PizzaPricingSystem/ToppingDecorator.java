package PizzaPricingSystem;

public class ToppingDecorator extends PizzaDecorator{
    private final int costPerServing;
    private final int servings;

    public ToppingDecorator(Pizza pizza,int costPerServing, int servings)
    {
        super(pizza);
        this.costPerServing = costPerServing;
        this.servings = servings;
    }
    @Override
    public double subTotal()
    {
        return super.subTotal() + costPerServing*servings;
    }
}
