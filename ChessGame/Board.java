package ChessGame;

import ChessGame.pieces.*;

public class Board {
    private final Cell[][] board;

    public Board() {
        board = new Cell[8][8];

        for (int row = 0; row < 8; row++)
            for (int col = 0; col < 8; col++)
                board[row][col] = new Cell(row, col);

        setupPieces();
    }

    private void setupPieces() {
        for (int j = 0; j < 8; j++) {
            board[1][j].setPiece(new Pawn(Color.WHITE));
            board[6][j].setPiece(new Pawn(Color.BLACK));
        }

        board[0][0].setPiece(new Rook(Color.WHITE));
        board[0][1].setPiece(new Knight(Color.WHITE));
        board[0][2].setPiece(new Bishop(Color.WHITE));
        board[0][3].setPiece(new Queen(Color.WHITE));
        board[0][4].setPiece(new King(Color.WHITE));
        board[0][5].setPiece(new Bishop(Color.WHITE));
        board[0][6].setPiece(new Knight(Color.WHITE));
        board[0][7].setPiece(new Rook(Color.WHITE));

        board[7][0].setPiece(new Rook(Color.BLACK));
        board[7][1].setPiece(new Knight(Color.BLACK));
        board[7][2].setPiece(new Bishop(Color.BLACK));
        board[7][3].setPiece(new Queen(Color.BLACK));
        board[7][4].setPiece(new King(Color.BLACK));
        board[7][5].setPiece(new Bishop(Color.BLACK));
        board[7][6].setPiece(new Knight(Color.BLACK));
        board[7][7].setPiece(new Rook(Color.BLACK));
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public synchronized boolean movePiece(Move move) {
        Cell from = move.getStart(), to = move.getEnd();
        Piece piece = from.getPiece();
        if (piece == null || !piece.canMove(this, from, to)) return false;

        to.setPiece(piece);
        from.setPiece(null);
        return true;
    }

    public Piece getPiece(int row, int col) {
        return board[row][col].getPiece();
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col].setPiece(piece);
    }

    public boolean isCheckmate(Color color) {
        if(!isCheck(color))return false;
        return !hasMove(color);
    }

    public boolean isStalemate(Color color) {
        if(isCheck(color))return false;
        return !hasMove(color);
    }

    public boolean isCheck(Color color) {
        Cell kingCell = null;
        for (int r = 0; r < 8 && kingCell == null; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = board[r][c].getPiece();
                if (p instanceof King && p.getColor() == color) {
                    kingCell = board[r][c];
                    break;
                }
            }
        }
        if (kingCell == null) {
            // no king on board → treat as “in check”
            return true;
        }

        // 2) See if any *enemy* piece can move to the king’s square
        Color enemy = (color == Color.WHITE ? Color.BLACK : Color.WHITE);
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece attacker = board[r][c].getPiece();
                if (attacker != null && attacker.getColor() == enemy) {
                    if (attacker.canMove(this, board[r][c], kingCell)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Return true if `color` has at least one legal move:
     * obeys canMove(), doesn’t capture its own piece,
     * and doesn’t leave its king in check.
     */
    public boolean hasMove(Color color) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Cell from = board[r][c];
                Piece p = from.getPiece();
                if (p == null || p.getColor() != color) continue;

                for (int r2 = 0; r2 < 8; r2++) {
                    for (int c2 = 0; c2 < 8; c2++) {
                        Cell to = board[r2][c2];
                        Piece dest = to.getPiece();

                        // Self‑capture check
                        if (dest != null && dest.getColor() == color) {
                            continue;
                        }

                        // Movement rule
                        if (!p.canMove(this, from, to)) {
                            continue;
                        }

                        // Simulate
                        from.setPiece(null);
                        to.setPiece(p);
                        boolean leavesInCheck = isCheck(color);
                        // Undo
                        to.setPiece(dest);
                        from.setPiece(p);

                        if (!leavesInCheck) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
