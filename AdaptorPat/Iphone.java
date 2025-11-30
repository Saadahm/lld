package AdaptorPat;

public class Iphone {
    AppleCharger appleCharger;
    public Iphone(AppleCharger appleCharger)
    {
        this.appleCharger=appleCharger;
    }
    public void chargeIPphone()
    {
        appleCharger.chargeIphone();
    }
}
