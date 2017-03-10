package ca.bcit.comp2526.a2a;

/**
 * King piece class.
 * @author Philip Choi
 * @version 1.0
 */
public class King extends ChessPiece {
    
    /**
     * Player number.
     */
    private int playerNum;
    
    /**
     * King constructor.
     * @param playerNum
     *          player number
     */
    public King(int playerNum) {
        super("images/king" + playerNum + ".png");
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
        if (ypos - squarePiece.getYpos() == 1 && xpos - squarePiece.getXpos() == 0) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == -1 && xpos - squarePiece.getXpos() == 0) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == -1 && xpos - squarePiece.getXpos() == -1) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == 1 && xpos - squarePiece.getXpos() == 1) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == 0 && xpos - squarePiece.getXpos() == 1) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == 0 && xpos - squarePiece.getXpos() == -1) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == -1 && xpos - squarePiece.getXpos() == -1) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == 1 && xpos - squarePiece.getXpos() == -1) {
            return true;
        }
        if (ypos - squarePiece.getYpos() == -1 && xpos - squarePiece.getXpos() == 1) {
            return true;
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
