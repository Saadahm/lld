package ConcertBookingSystem;

public class Cash implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("Paying by cash");
    }
}
