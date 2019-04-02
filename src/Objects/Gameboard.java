package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameboard extends JFrame {
    //Size of the application frame
    static int width = 1003;
    static int height = 1029;

    //Size of the last known location array of the avatar
    int[] lastLocation = new int[2];

    //Creates new avatar and gameboard, makes a list of all objects, the amount of squares in the field, colum x row
    Avatar avatar = new Avatar(this);
    JPanel gameboard = new JPanel();
    Square[][] board = new Square[10][10];

    //Sets up the game; Create frame with its attributes, draws level, adds gameboard, sets exit on close of program, sets size of frame, sets not resizable, sets location in middle, sets visible
    public void setup() {
        startLevel();
        add(gameboard);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(width, height));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Creates avatar (first because we don't want to place a wall on his head), then creates all other objects
    public void startLevel() {
        gameboard.add(avatar);

        board[3][3] = new Wall();
        board[4][4] = new Wall();
        board[9][9] = new Exit();

        Key key100 = new Key();
        board[2][2] = key100;

        board[6][6] = new Barricade(key100);
    }

    //Shows the location of the avatar in the run console and restarts the game when the game has been finished
    public void update() {
        repaint();
        if (9 == avatar.getCol() & 9 == avatar.getRow()) {
            JOptionPane.showMessageDialog(null, "Game finished");
            avatar.resetColRow();
        } else {
            //avatar.used();
            System.out.println(avatar.getCol() + " " + avatar.getRow());
//            lastLocation[0] = avatar.getCol();
//            lastLocation[1] = avatar.getRow();
//            System.out.println(lastLocation[][]);
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, width, height);
        for (int i = 0; board.length > i; i++) {
            for (int j = 0; board[i].length > j; j++) {
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
                    g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                }
                g2d.setColor(Color.BLACK);
                g2d.drawRect(i * 100, j * 100 + 26, 100, 100);
            }
        }
        g2d.setColor(Color.RED);
        g2d.fillRect(avatar.getCol() * 100, avatar.getRow() * 100 + 26, 100, 100);
    }
}
