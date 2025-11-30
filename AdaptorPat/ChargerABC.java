package AdaptorPat;

public class ChargerABC implements AndroidCharger{
    @Override
    public void chargeIphone()
    {
        System.out.println("charging using android charger");
    }
}
