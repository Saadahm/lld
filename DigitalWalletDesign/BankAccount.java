package DigitalWalletDesign;

public class BankAccount extends PaymentMethod{
    @Override
    public boolean process(int amt){
        System.out.println("processing payment of amount"+ amt);
    return true;
    }
}
