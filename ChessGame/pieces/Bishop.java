package ChessGame.pieces;

import ChessGame.Board;
import ChessGame.Cell;
import ChessGame.Color;

public class Bishop extends Piece{
    public Bishop(Color color)
    {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int x1= from.getX();
        int y1=from.getY();
        int x2=to.getX();
        int y2=to.getY();

        return Math.abs(x1 - x2) == Math.abs(y1 - y2);
    }
}
