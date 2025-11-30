package AdaptorPat;

public class Adaptor implements AppleCharger{
   private AndroidCharger androidCharger;

    public Adaptor(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeIphone()
    {
    androidCharger.chargeIphone();
    }
}
