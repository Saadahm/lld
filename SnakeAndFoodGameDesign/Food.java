package SnakeAndFoodGameDesign;

public abstract class Food {
    int row,column;
    int points;
    public Food(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() { return row; }
    public int getColumn() { return column; }
    public int getPoints() { return points; }

}
