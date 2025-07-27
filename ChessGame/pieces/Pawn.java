package ChessGame.pieces;

import ChessGame.Board;
import ChessGame.Cell;
import ChessGame.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int x1 = from.getX();
        int y1 = from.getY();
        int x2 = to.getX();
        int y2 = to.getY();

        int rowd = x2 - x1;
        int cold = Math.abs(y1 - y2);
        if (isWhite()) {
            // 1) One square straight forward:
            return ((rowd == 1 && cold == 0)
                    ||
                    // 2) Two squares straight forward, but only if on its starting rank (row 1):
                    (x1 == 1 && rowd == 2 && cold == 0)
                    ||
                    // 3) One square diagonally forward, but only if capturing (destination must be occupied):
                    (rowd == 1 && cold == 1
                            && board.getPiece(to.getX(), to.getY()) != null));

        } else {
            return ((rowd == -1 && cold == 0)
                    ||
                    // 2) Two squares straight forward, but only if on its starting rank (row 1):
                    (x1 == 6 && rowd == -2 && cold == 0)
                    ||
                    // 3) One square diagonally forward, but only if capturing (destination must be occupied):
                    (rowd == -1 && cold == 1
                            && board.getPiece(to.getX(), to.getY()) != null));
        }
    }
}
