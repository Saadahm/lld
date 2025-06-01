package SnakeAndFoodGameDesign;

public class HumanStrategy implements MovementStrategy{
    @Override
    public Pair move(Pair old, String direction){
        int row = old.getKey();
        int col = old.getValue();
        switch (direction) {
            case "U": return new Pair(row - 1, col);
            case "D": return new Pair(row + 1, col);
            case "L": return new Pair(row, col - 1);
            case "R": return new Pair(row, col + 1);
            default: return old;
        }
    }
}
