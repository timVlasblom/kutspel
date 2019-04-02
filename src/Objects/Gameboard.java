package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameboard extends JFrame {

    //Size of the application frame, in pixels
    static int width = 1006;
    static int height = 1029;

    //The amount of squares in the field, colum x row
    int col = 10;
    int row = 10;

    //Size of the last known location array of the avatar
    int[] lastLocation = new int[2];

    //Creates new avatar
    Avatar avatar = new Avatar(this);

    //makes a list of all objects
    ArrayList<Square> list = new ArrayList<Square>();
    Square[][] board = new Square[10][10];

    //Creates new gameboard
    JPanel gameboard = new JPanel();

    //Sets up the game
    public void setup() {

        //Create frame with its attributes, sets exit on close of program, sets size of frame, sets location in middle, sets not resizable, sets visible
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        //Sets up the size of the play field
        //gameboard.setLayout(new BorderLayout());
        //gameboard.setPreferredSize(new Dimension(width, height));

        //Adds and draws the gameboard
        //getContentPane().add(squares);

        startLevel();
        add(gameboard);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        //Do board check to see if the level is possible
    }


    public void startLevel() {
        //Creates avatar (first because we don't want to place a wall on his head)
        gameboard.add(avatar);
        board[3][3] = new Wall();
        board[4][4] = new Wall();
        board[9][9] = new Exit();
        board[6][6] = new Barricade();
    }

    //Shows the location of the avatar in the run console and restarts the game when the game has been finished
    public void update() {
        if (9 == avatar.getCol() & 9 == avatar.getRow()) {
            JOptionPane.showMessageDialog(null, "Game finished");
            avatar.resetCol();
            avatar.resetRow();
        } else {
            System.out.println(avatar.getCol() + " " + avatar.getRow());
            lastLocation[0] = avatar.getCol();
            lastLocation[1] = avatar.getRow();
           // System.out.println(lastLocation[][]);
        }
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, width, height);
        g2d.setColor(Color.RED);
        g2d.fillRect(avatar.getCol() * 100, avatar.getRow() * 100 + 29, 100, 100);
        for (int i = 0 ;board.length > i; i++){
            for (int j = 0 ;board[i].length > j; j++) {
                g2d.setColor(Color.BLACK);
                if (board[i][j] instanceof Wall) {
                    g2d.setColor(Color.BLUE);
                }

                if (board[i][j] instanceof Barricade) {
                    g2d.setColor(Color.YELLOW);
                }

                if (board[i][j] instanceof Exit) {
                    g2d.setColor(Color.GREEN);
                }

                if (board[i][j] instanceof Key) {
                    g2d.setColor(Color.PINK);
                }

                if (board[i][j] != null) {
                    g2d.fillRect(i * 100, j * 100 + 29, 100, 100);
                }
            }
        }
    }
}
