package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Chess board.
 * @author Philip Choi
 * @version 1.0
 */
public class Board extends JPanel implements MouseListener {
    
    /**
     * Size of the board.
     */
    public static final int BOARD_DIMENSION = 8;
    
    /**
     * Previously clicked Square.
     */
    private Square previousSquare;
    
    /**
     * Current clicked Square.
     */
    private Square clickedSquare;
    
    /**
     * Pixel size of a square.
     */
    public static final int SQUARE_SIZE = 80;
    
    /**
     * 2D square panel for the board.
     */
    protected static Square[][] tile = new Square[BOARD_DIMENSION][BOARD_DIMENSION];
    
    /**
     * Player turn.
     */
    private int playerTurn = 2;
    
    /**
     * Creates board.
     */
    public Board() {
        createSquares();
        placePieces(1, 2);
    }
    
    /**
     * Creates squares for the board.
     */
    public void createSquares() {
        setLayout(new GridLayout(BOARD_DIMENSION, BOARD_DIMENSION));
        for (int row = 0; row < BOARD_DIMENSION; row++) {
            for (int column = 0; column < BOARD_DIMENSION; column++) {
                if ((row + column + 1) % 2 == 0) {
                    tile[row][column] = new Square(Color.BLACK, SQUARE_SIZE, row, column);
                    tile[row][column].addMouseListener(this);
                } else {
                    tile[row][column] = new Square(Color.WHITE, SQUARE_SIZE, row, column);
                    tile[row][column].addMouseListener(this);
                }
                add(tile[row][column]);
            }
        }
    }
    
    /**
     * Place pawn in its initial position.
     * @param player1 piece
     * @param player2 piece
     */
    private void placePawn(int player1, int player2) {
        for (int i = 0; i < 8; i++) {
            ChessPiece piece = new Pawn(player1);
            tile[1][i].addPiece(piece);
            ChessPiece piece2 = new Pawn(player2);
            tile[6][i].addPiece(piece2);
        }
    }
    
    /**
     * Place king in its initial position.
     * @param player1 piece
     * @param player2 piece
     */
    private void placeKing(int player1, int player2) {
        ChessPiece piece = new King(player1);
        tile[0][3].addPiece(piece);
        ChessPiece piece2 = new King(player2);
        tile[7][4].addPiece(piece2);
    }
    
    /**
     * Place rook in its initial position.
     * @param player1 piece
     * @param player2 piece
     */
    private void placeRook(int player1, int player2) {
        ChessPiece piece = new Rook(player1);
        tile[0][0].addPiece(piece);
        piece = new Rook(player1);
        tile[0][7].addPiece(piece);
        ChessPiece piece2 = new Rook(player2);
        tile[7][0].addPiece(piece2);
        piece2 = new Rook(player2);
        tile[7][7].addPiece(piece2);
        
    }
    
    
    /**
     * Place bishop in its initial position.
     * @param player1 piece
     * @param player2 piece
     */
    private void placeBishop(int player1, int player2) {
        ChessPiece piece = new Bishop(player1);
        tile[0][2].addPiece(piece);
        piece = new Bishop(player1);
        tile[0][5].addPiece(piece);
        ChessPiece piece2 = new Bishop(player2);
        tile[7][2].addPiece(piece2);
        piece2 = new Bishop(player2);
        tile[7][5].addPiece(piece2);
    }
    
    /**
     * Place knight in its initial position.
     * @param player1 piece
     * @param player2 piece
     */
    private void placeKnight(int player1, int player2) {
        ChessPiece piece = new Knight(player1);
        tile[0][1].addPiece(piece);
        piece = new Knight(player1);
        tile[0][6].addPiece(piece);
        ChessPiece piece2 = new Knight(player2);
        tile[7][1].addPiece(piece2);
        piece2 = new Knight(player2);
        tile[7][6].addPiece(piece2);
    }
    
    /**
     * Place Queen in its initial position.
     * @param player1 piece
     * @param player2 piece
     */
    private void placeQueen(int player1, int player2) {
        ChessPiece piece = new Queen(player1);
        tile[0][4].addPiece(piece);
        ChessPiece piece2 = new Queen(player2);
        tile[7][3].addPiece(piece2);
    }
    
    /**
     * Place pieces to the squares.
     * @param player1
     *          player number
     * @param player2
     *          player number
     */
    private void placePieces(int player1, int player2) {
        placePawn(player1, player2);
        placeQueen(player1, player2);
        placeKing(player1, player2);
        placeKnight(player1, player2);
        placeRook(player1, player2);
        placeBishop(player1, player2);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    /**
     * Event occurs when mouse pressed.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        repaint();
        clickedSquare = (Square) e.getSource();
        if (previousSquare != null && playerTurn == previousSquare.getPiece().getPlayer()) {
            if (previousSquare.isClicked() && !clickedSquare.hasPiece()) {
                if (previousSquare.getPiece().isValidMove(clickedSquare.getXpos(),
                                                          clickedSquare.getYpos(),
                                                          previousSquare)) {
                    clickedSquare.addPiece(previousSquare.getPiece());
                    previousSquare.removePiece();
                    previousSquare.setUnclicked();
                    previousSquare.setDefaultColor();
                    clickedSquare.setUnclicked();
                    clickedSquare.setDefaultColor();
                    previousSquare = null;
                    if (playerTurn == 1) {
                        playerTurn = 2;
                    } else {
                        playerTurn = 1;
                    }
                }
            } else if (previousSquare == clickedSquare && previousSquare.isClicked()) {
                previousSquare.setUnclicked();
                previousSquare.setDefaultColor();
                clickedSquare.setUnclicked();
                clickedSquare.setDefaultColor();
                previousSquare = null;
            } else if (previousSquare.isClicked() && clickedSquare.hasPiece()
                            && clickedSquare.getPiece().getPlayer() != playerTurn) {
                if (previousSquare.getPiece().isValidMove(clickedSquare.getXpos(),
                        clickedSquare.getYpos(),
                        previousSquare)) {
                    clickedSquare.removeAll();
                    clickedSquare.addPiece(previousSquare.getPiece());
                    previousSquare.removePiece();
                    previousSquare.setUnclicked();
                    previousSquare.setDefaultColor();
                    clickedSquare.setUnclicked();
                    clickedSquare.setDefaultColor();
                    previousSquare = null;
                    repaint();
                    if (playerTurn == 1) {
                        playerTurn = 2;
                    } else {
                        playerTurn = 1;
                    }
                }
            }
        } else if (previousSquare == null && clickedSquare.hasPiece()
                        && clickedSquare.getPiece().getPlayer() == playerTurn) {
            clickedSquare.setClicked();
            clickedSquare.clickedColor();
            previousSquare = clickedSquare;
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }    
}
