package PizzaPricingSystem;

public class Main {
    public static void main(String[] args) {
//        Pizza pizza=new BasePizza(200);
//        pizza= new ToppingDecorator(pizza,100,5);
//        System.out.println(pizza.subTotal());

        PizzaPricing pizzaPricing=new PizzaPricing(200, 10, "small");
        pizzaPricing.addTopping("onion",2);
        System.out.println(pizzaPricing.getFinalPrice());
    }
}
