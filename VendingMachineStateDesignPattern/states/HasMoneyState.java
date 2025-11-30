package VendingMachineStateDesignPattern.states;

import VendingMachineStateDesignPattern.Coin;
import VendingMachineStateDesignPattern.VendingMachine;

public class HasMoneyState extends State{
    public HasMoneyState(VendingMachine vendingMachine)
    {
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already received full amount.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
        vendingMachine.setState(new DispenseState(vendingMachine));
        vendingMachine.dispenseItem();
    }

    @Override
    public void refund() {
        vendingMachine.refundBalance();
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
