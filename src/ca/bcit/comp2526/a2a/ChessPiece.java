package ca.bcit.comp2526.a2a;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Chess piece class
 * @author Philip Choi
 * @version 1.0
 */
public abstract class ChessPiece extends JLabel {
    
    /**
     * Chess piece constructor.
     * @param image
     *          image directory.
     */
    public ChessPiece(String image) {
        setImage(image);
    }
    
    /**
     * Puts image.
     * @param image
     *          name of the image file.
     */
    private void setImage(String image) {
        this.setIcon(new ImageIcon(image));
    }
    
    /**
     * Checks for valid moves.
     * @param xpos x position of the piece
     * @param ypos y position of the piece
     * @return true if valid move, false otherwise.
     */
    public abstract boolean isValidMove(int xpos, int ypos, Square squarePiece);
    
    /**
     * Get player number.
     * @return playerNum
     *          player number
     */
    public abstract int getPlayer();
}