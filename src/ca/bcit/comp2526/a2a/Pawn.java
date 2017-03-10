package ca.bcit.comp2526.a2a;

/**
 * Pawn piece class.
 * @author Philip Choi
 * @version 1.0
 */
public class Pawn extends ChessPiece {
    
    /**
     * Player number.
     */
    private int playerNum;
    
    /**
     * Check if the pawn is initial move.
     */
    private boolean initialMove;
    
    /**
     * Pawn constructor.
     * @param playerNum
     *          player number
     */
    public Pawn(int playerNum) {
        super("images/pawn" + playerNum + ".png");
        initialMove = true;
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
        if (initialMove == true) {
            if (this.playerNum == 1) {
                if (ypos - squarePiece.getYpos() == 2 && xpos - squarePiece.getXpos() == 0) {
                    if (Board.tile[squarePiece.getYpos() + 1][xpos].hasPiece()) {
                        return false;
                    }
                    initialMove = false;
                    return true;
                }
                if (ypos - squarePiece.getYpos() == 1 && xpos - squarePiece.getXpos() == 0) {
                    initialMove = false;
                    return true;
                }
            } else if (this.playerNum == 2) {
                if (ypos - squarePiece.getYpos() == -2 && xpos - squarePiece.getXpos() == 0) {
                    if (Board.tile[squarePiece.getYpos() - 1][xpos].hasPiece()) {
                        return false;
                    }
                    initialMove = false;
                    return true;
                }
                if (ypos - squarePiece.getYpos() == -1 && xpos - squarePiece.getXpos() == 0) {
                    initialMove = false;
                    return true;
                }
            }
        } else if (this.playerNum == 1) {
            if (ypos - squarePiece.getYpos() == 1 && xpos - squarePiece.getXpos() == 0) {
                initialMove = false;
                return true;
            }
        } else if (this.playerNum == 2) {
            if (ypos - squarePiece.getYpos() == -1 && xpos - squarePiece.getXpos() == 0) {
                initialMove = false;
                return true;
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
