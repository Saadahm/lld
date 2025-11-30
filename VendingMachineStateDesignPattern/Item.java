package VendingMachineStateDesignPattern;

public class Item {
    private int price;
    private String name;
    private String code;
    public Item(String code, String name, int price)
    {
        this.price=price;
        this.name=name;
        this.code=code;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
