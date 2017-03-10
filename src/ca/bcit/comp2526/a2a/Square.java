package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Square class that will create the square for the board.
 * @author Philip Choi
 * @version 1.0
 */
public class Square extends JPanel {
    
    /**
     * Default color.
     */
    private Color defaultColor;
    
    /**
     * Square clicked toggle.
     */
    private boolean isClicked;
    
    /**
     * Chess Piece.
     */
    private ChessPiece piece;
    
    /**
     * X position from the board.
     */
    private int xpos;
    
    /**
     * Y position from the board.
     */
    private int ypos;
    
    /**
     * Constructor for square.
     */
    public Square(Color color, int length, int row, int column) {
        xpos = column;
        ypos = row;
        this.setBackground(color);
        this.defaultColor = color;
        this.setPreferredSize(new Dimension(length, length));
        isClicked = false;
    }
    
    /**
     * Get default color.
     * @return Color of the square
     */
    public Color getDefaultColor() {
        return defaultColor;
    }
    
    /**
     * Check if square holds a piece.
     * @return true if square holds a piece
     *              false otherwise.
     */
    public boolean hasPiece() {
        if (piece == null) {
            return false;
        }
        return true;
    }
    
    /**
     * Set square to be clicked.
     */
    public void setClicked() {
        isClicked = true;
    }
    
    /**
     * Set square to be unclicked.
     */
    public void setUnclicked() {
        isClicked = false;
    }
    
    /**
     * Return value of isClicked
     * @return isClicked
     *             True if square is clicked false otherwise.
     */
    public boolean isClicked() {
        return isClicked;
    }
    
    /**
     * Set to default color.
     */
    public void setDefaultColor() {
        setBackground(defaultColor);
    }
    
    /**
     * Add piece to the square.
     * @param piece
     *          chess piece.
     */
    public void addPiece(ChessPiece piece) { 
        this.piece = piece;
        add(this.piece);
    }
    
    /**
     * Get piece.
     */
    public ChessPiece getPiece() {
        return piece;
    }
    
    /**
     * Remove piece.
     */
    public void removePiece() {
        piece = null;
    }
    
    /**
     * Change color of the square when clicked.
     */
    public void clickedColor() {
        setBackground(Color.GREEN);
    }
    
    /**
     * Get color of the square.
     */
    public Color getColor() {
        return getBackground();
    }
    
    /**
     * Get x position of the square.
     */
    public int getXpos() {
        return xpos;
    }
    
    /**
     * Get y position of the square.
     */
    public int getYpos() {
        return ypos;
    }
}