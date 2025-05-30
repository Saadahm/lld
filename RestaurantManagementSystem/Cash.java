package RestaurantManagementSystem;

public class Cash implements PaymentStrategy{
    @Override
    public void processPayment(double amount){
        System.out.println("Paying using cash" + amount);
    }
}
