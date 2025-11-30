package VendingMachineStateDesignPattern.states;

import VendingMachineStateDesignPattern.Coin;
import VendingMachineStateDesignPattern.VendingMachine;

public abstract class State {
    VendingMachine vendingMachine;
    public State(VendingMachine vendingMachine)
    {
        this.vendingMachine=vendingMachine;
    }
    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
    public abstract void refund();
}
