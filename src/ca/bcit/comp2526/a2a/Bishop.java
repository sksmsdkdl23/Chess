package ca.bcit.comp2526.a2a;

/**
 * Bishop piece class.
 * @author Philip Choi
 * @version 1.0
 */
public class Bishop extends ChessPiece {
    
    /**
     * Player number.
     */
    private int playerNum;
    
    /**
     * Bishop constructor.
     * @param playerNum
     *          player number
     */
    public Bishop(int playerNum) {
        super("images/bishop" + playerNum + ".png");
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
        if (Math.abs(offsetY) == Math.abs(offsetX)) {
            if (offsetY > 0 && offsetX > 0) {
                int xpostion = squarePiece.getXpos() + 1;
                for (int i = squarePiece.getYpos() + 1; i <= ypos; i++) {
                    if (Board.tile[i][xpostion].hasPiece()) {
                        hasPiece = true;
                    }
                    xpostion++;
                }
                if (hasPiece == true) {
                    return false;
                } else {
                    return true;
                }
            }
            if (offsetY > 0 && offsetX < 0) {
                int xpostion = squarePiece.getXpos() - 1;
                for (int i = squarePiece.getYpos() + 1; i <= ypos; i++) {
                    if (Board.tile[i][xpostion].hasPiece()) {
                        hasPiece = true;
                    }
                    xpostion--;
                }
                if (hasPiece == true) {
                    return false;
                } else {
                    return true;
                }
            }
            if (offsetY < 0 && offsetX > 0) {
                int xpostion = xpos;
                for (int i = ypos; i < squarePiece.getYpos(); i++) {
                    if (Board.tile[i][xpostion].hasPiece()) {
                        hasPiece = true;
                    }
                    xpostion--;
                }
                if (hasPiece == true) {
                    return false;
                } else {
                    return true;
                }
            }
            if (offsetY < 0 && offsetX < 0) {
                int xpostion = xpos;
                for (int i = ypos; i < squarePiece.getYpos(); i++) {
                    if (Board.tile[i][xpostion].hasPiece()) {
                        hasPiece = true;
                    }
                    xpostion++;
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
