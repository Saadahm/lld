package SnakeAndFoodGameDesign;

public class HumanStrategy implements MovementStrategy{
    @Override
    public Pair move(Pair old, String direction){
        return switch (direction) {
            case "U" -> new Pair(old.getRow() - 1, old.getCol());
            case "D" -> new Pair(old.getRow() + 1, old.getCol());
            case "L" -> new Pair(old.getRow(), old.getCol() - 1);
            default -> new Pair(old.getRow(), old.getCol() + 1);
        };
    }
}
