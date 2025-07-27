package ChessGame.pieces;

import ChessGame.Board;
import ChessGame.Cell;
import ChessGame.Color;

public class King extends Piece {

    public King(Color color)
    {
        super(color);
    }
    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int x1= from.getX();
        int y1=from.getY();
        int x2=to.getX();
        int y2=to.getY();
        if(Math.abs(x1-x2)<=1 && Math.abs(y1-y2)<=1)
            return true;
        else
            return false;
    }
}
