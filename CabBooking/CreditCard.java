package CabBooking;


public class CreditCard implements PaymentStrategy {
    @Override
    public void processPayment(double amount){
        System.out.println("Paying using credit card" + amount);
    }
}

