package ca.bcit.comp2526.a2a;

/**
 * Knight piece class.
 * @author Philip Choi
 * @version 1.0
 */
public class Knight extends ChessPiece {

    /**
     * Player number.
     */
    private int playerNum;
    
    /**
     * Knight constructor.
     * @param playerNum
     *          player number
     */
    public Knight(int playerNum) {
        super("images/knight" + playerNum + ".png");
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
        if (Math.abs(xpos - squarePiece.getXpos()) == 2 
                && Math.abs(ypos - squarePiece.getYpos()) == 1) {
            return true;
        }
        if (Math.abs(ypos - squarePiece.getYpos()) == 2 
                && Math.abs(xpos - squarePiece.getXpos()) == 1) {
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
