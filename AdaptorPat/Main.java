package AdaptorPat;

public class Main {
    public static void main(String[] args) {

        AppleCharger appleCharger= new ChargerXYZ();
        AndroidCharger androidCharger= new ChargerABC();
        Adaptor adaptor= new Adaptor(androidCharger);
//        adaptor.chargeIphone();
        Iphone iphone= new Iphone(adaptor);
        iphone.chargeIPphone();
    }
}
