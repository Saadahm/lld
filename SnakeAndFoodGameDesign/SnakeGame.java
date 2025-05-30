package SnakeAndFoodGameDesign;

import java.util.Deque;
import java.util.LinkedList;

public class SnakeGame {
    private GameBoard gameBoard;
    public Deque<Pair> snake;
    private int foodIndex;
    private MovementStrategy movementStrategy;
    private int [][]foodpositions;

    public SnakeGame(int width, int height, MovementStrategy movementStrategy, int [][]foodpositions) {
        this.gameBoard = GameBoard.getInstance(width, height);
        this.snake = new LinkedList<>();
        this.foodIndex = 0;
        this.movementStrategy = movementStrategy;
        this.foodpositions = foodpositions;
    }
    public int move(String direction)
    {
        Pair old=this.snake.peekFirst();
        //out of bound
        Pair newco = movementStrategy.move(old,direction);
        if(newco.getCol()>= gameBoard.getWidth() || newco.getRow()>= gameBoard.getHeight() || newco.getCol()<0 || newco.getRow()<0)
            return -1;
//        if(newco==old)
            return -1;

    }
}
