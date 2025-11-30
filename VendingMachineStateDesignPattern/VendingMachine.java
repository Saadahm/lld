package VendingMachineStateDesignPattern;

import VendingMachineStateDesignPattern.states.IdleState;
import VendingMachineStateDesignPattern.states.State;

public class VendingMachine {
    private final static VendingMachine INSTANCE = new VendingMachine();
    private final Inventory inventory = new Inventory();
    private State currentState;
    private int balance = 0;
    private String selectedItemCode;
    public VendingMachine()
    {
        this.currentState=new IdleState(this);
    }
    public void setState(State state) {
        this.currentState = state;
    }

    public static VendingMachine getInstance() {
        return INSTANCE;
    }

    public void addBalance(int x)
    {
        balance+=x;
    }

    public int getBalance()
    {
        return balance;
    }
    public Inventory getInventory() { return inventory; }

    public void reset()
    {
        selectedItemCode = null;
        balance = 0;
    }

    public void refundBalance()
    {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public Item addItem(String code, String name, int price, int quantity) {
        Item item = new Item(code, name, price);
        inventory.addItem(code, item, quantity);
        return item;
    }

    public void selectItem(String code) {
        currentState.selectItem(code);
    }

    public void dispense() {
        currentState.dispense();
    }

    public void dispenseItem(){
        Item item= getSelectedItem();
        if(balance>=item.getPrice())
        {
            balance-=item.getPrice();
            inventory.reduceStock(selectedItemCode);
            System.out.println("Dispensed: " + item.getName());
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        reset();
        setState(new IdleState(this));
    }
    public Item getSelectedItem()
    {
        return inventory.getItem(selectedItemCode);
    }
    public void setSelectedItemCode(String code) {
        this.selectedItemCode = code;
    }

}
