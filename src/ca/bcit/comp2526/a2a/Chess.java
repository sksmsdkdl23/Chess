package ca.bcit.comp2526.a2a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Chess game.
 * @author Philip Choi
 * @version 1.0
 */
public class Chess extends JFrame implements ActionListener, Serializable { 
    
    /**
     * Menu bar.
     */
    private JMenuBar menuBar = new JMenuBar();
    
    /**
     * Menu.
     */
    private JMenu menu = new JMenu("Menu");
    
    /**
     * Exit menu item.
     */
    private JMenuItem close = new JMenuItem("Exit");
    
    /**
     * Save menu item.
     */
    private JMenuItem save = new JMenuItem("Save");
    
    /**
     * Load menu item.
     */
    private JMenuItem load = new JMenuItem("Load");
    
    /**
     * New game menu item.
     */
    private JMenuItem newGame = new JMenuItem("New Game");
    
    /**
     * Board.
     */
    private Board board = new Board();
    
    /**
     * Chess game.
     */
    public Chess() {
        menuBar.add(menu);
        menu.add(close);
        menu.add(save);
        menu.add(load);
        menu.add(newGame);
        close.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        newGame.addActionListener(this);
        setJMenuBar(menuBar);
        setSize(700, 700);// fix window size
        add(board);
        setResizable(false);
        setVisible(true);// make window visible 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Chess game constructor (Loading).
     * @param board
     *          saved board
     */
    public Chess(Board board) {
        menuBar.add(menu);
        menu.add(close);
        menu.add(save);
        menu.add(load);
        menu.add(newGame);
        close.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        newGame.addActionListener(this);
        setJMenuBar(menuBar);
        setSize(700, 700);// fix window size
        add(board);
        setResizable(false);
        setVisible(true);// make window visible 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Serialize.
     */
    private void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream("board.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(board);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in board.ser");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Deserialize.
     */
    private void deserialize() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("board.ser"));
            board = (Board) ois.readObject();
            removeAll();
            this.setEnabled(false);
            this.setVisible(false);
            new Chess(board);
            ois.close();
        } catch (FileNotFoundException ex) {
            // TODO Auto-generated catch block
            System.out.println("File not found");
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        
    }
    
    private void newGame() {
        removeAll();
        this.setEnabled(false);
        this.setVisible(false);
        new Chess();
    }
    
    /**
     * Action listener for menus.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((JMenuItem)e.getSource() == close) {
            System.exit(0);
        }
        if ((JMenuItem)e.getSource() == save) {
            serialize();
        }
        if ((JMenuItem)e.getSource() == load) {
            deserialize();
        }
        if ((JMenuItem)e.getSource() == newGame) {
            newGame();
        }
 
    }
}
