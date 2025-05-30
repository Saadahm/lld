package SnakeAndFoodGameDesign;

public interface MovementStrategy {
    Pair move(Pair old, String direction);
}
