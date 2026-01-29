package PizzaPricingSystem;

import java.util.HashMap;
import java.util.Map;

public class PizzaPricing {
    private Pizza pizza;

    private final int taxPercentage;
    private final String size;
    public PizzaPricing(int basePrice,int taxPercentage, String size)
    {
        this.taxPercentage = taxPercentage;
        this.size = size;
        this.pizza=new BasePizza(basePrice);
    }

    private static final Map<String, Integer> CATALOG = new HashMap<>();
    static {
        CATALOG.put("cheeseburst", 100);
        CATALOG.put("corn", 50);
        CATALOG.put("onion", 30);
        CATALOG.put("capsicum", 50);
        CATALOG.put("pineapple", 60);
        CATALOG.put("mushroom", 40);
    }

    public boolean addTopping(String topping, int serving)
    {
        Integer cost=CATALOG.get(topping);
        if(cost==null)
            return false;
        pizza=new ToppingDecorator(pizza, cost, serving);
        return true;
    }

    public double getFinalPrice()
    {
        double price= pizza.subTotal();
        return price*(100+taxPercentage)/100;
    }
}
