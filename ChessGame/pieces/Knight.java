package ChessGame.pieces;

import ChessGame.Board;
import ChessGame.Cell;
import ChessGame.Color;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowd = Math.abs(from.getX()-to.getX());
        int cold = Math.abs(from.getY()-to.getY());
        return (rowd == 2 && cold == 1) || (rowd == 1 && cold == 2);
    }
}
