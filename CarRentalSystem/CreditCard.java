package CarRentalSystem;

public class CreditCard implements PaymentStrategy{
    @Override
    public void pay()
    {
        System.out.println("Paying by credit card");
    }
}
