package SnakeAndFoodGameDesign;

public class BonusFood extends Food{

    public BonusFood(int row, int column) {
        super(row, column);
        this.points=3;
    }
}
