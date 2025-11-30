package VendingMachineStateDesignPattern.states;

import VendingMachineStateDesignPattern.Coin;
import VendingMachineStateDesignPattern.VendingMachine;

public class IdleState extends State{
    public IdleState(VendingMachine vendingMachine)
    {
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please insert coins first");
    }

    @Override
    public void selectItem(String code) {
        if (!vendingMachine.getInventory().isAvailable(code)) {
            System.out.println("Item not available.");
            return;
        }
        vendingMachine.setSelectedItemCode(code);
        vendingMachine.setState(new ItemSelectedState(vendingMachine));
    }

    @Override
    public void dispense() {
        System.out.println("No item selected.");
    }

    @Override
    public void refund() {
        System.out.println("No money to refund.");
    }
}
