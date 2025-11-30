package VendingMachineStateDesignPattern.states;

import VendingMachineStateDesignPattern.Coin;
import VendingMachineStateDesignPattern.VendingMachine;

public class DispenseState extends State{
    public DispenseState(VendingMachine vendingMachine)
    {
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispense() {
    }

    @Override
    public void refund() {
        System.out.println("Dispensing in progress. Refund not allowed.");
    }
}
