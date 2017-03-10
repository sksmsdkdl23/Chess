package ca.bcit.comp2526.a2a;

/**
 * Rook piece class.
 * @author Philip Choi
 * @version 1.0
 */
public class Rook extends ChessPiece {
    
    /**
     * Player number.
     */
    private int playerNum;
    
    /**
     * Rook constructor.
     * @param playerNum
     *          player number
     */
    public Rook(int playerNum) {
        super("images/rook" + playerNum + ".png");
        this.playerNum = playerNum;
    }
    
    /**
     * Checks for valid moves.
     * @param xpos x position of the piece
     * @param ypos y position of the piece
     * @param squarePiece square with the piece
     * @return true if valid move, false otherwise.
     */
    @Override
    public boolean isValidMove(int xpos, int ypos, Square squarePiece) {
        boolean hasPiece = false;
        int offsetX = xpos - squarePiece.getXpos();
        int offsetY = ypos - squarePiece.getYpos();
        if (xpos == squarePiece.getXpos()) {
            if (offsetY > 0) {
                for (int i = squarePiece.getYpos() + 1; i <= ypos; i++) {
                    if (Board.tile[i][xpos].hasPiece()) {
                        hasPiece = true;
                    }
                }
                if (hasPiece == true) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (xpos == squarePiece.getXpos()) {
            if (offsetY < 0) {
                for (int i = ypos; i < squarePiece.getYpos(); i++) {
                    if (Board.tile[i][xpos].hasPiece()) {
                        hasPiece = true;
                    }
                }
                if (hasPiece == true) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (ypos == squarePiece.getYpos()) {
            if (offsetX > 0) {
                for (int i = squarePiece.getXpos() + 1; i <= xpos; i++) {
                    if (Board.tile[ypos][i].hasPiece()) {
                        hasPiece = true;
                    }
                }
                if (hasPiece == true) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (ypos == squarePiece.getYpos()) {
            if (offsetX < 0) {
                for (int i = xpos; i < squarePiece.getXpos(); i++) {
                    if (Board.tile[ypos][i].hasPiece()) {
                        hasPiece = true;
                    }
                }
                if (hasPiece == true) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Get player number.
     * @return playerNum
     *          player number
     */
    public int getPlayer() {
        return playerNum;
    }
}
