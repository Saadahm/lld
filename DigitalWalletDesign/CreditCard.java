package DigitalWalletDesign;

public class CreditCard extends PaymentMethod{
    @Override
    public boolean process(int amt){
        return true;
    }
}
