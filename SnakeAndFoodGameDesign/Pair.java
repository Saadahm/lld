package SnakeAndFoodGameDesign;

public class Pair {
   private int row,col;
    public Pair(int row, int col)
    {
        this.row=row;
        this.col=col;
    }

    public int getValue() {
        return col;
    }

    public int getKey() {
        return row;
    }


}
