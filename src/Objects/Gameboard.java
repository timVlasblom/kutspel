package Objects;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.WindowConstants;
import java.awt.image.BufferedImage;
import java.io.File;

public class Gameboard extends JFrame {

    //Size of the application frame, in pixels
    static int width = 1003;
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
        board[2][1] = new Key();
    }

    //Shows the location of the avatar in the run console and restarts the game when the game has been finished
    public void update() {
        repaint();
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
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, width, height);
        try {
            final BufferedImage image = ImageIO.read(new File("C:\\Users\\TimVl\\Documents\\GitHub\\kutspel\\src\\Images\\avatar.png"));
            Image BufferedImage = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
            g.drawImage(BufferedImage, avatar.getCol() * 100, avatar.getRow() * 100 + 26, null);
        } catch (IOException e) {
            System.out.println("KUTIMAGES");
        }
        for (int i = 0 ;board.length > i; i++){
            for (int j = 0 ;board[i].length > j; j++) {
                if (board[i][j] instanceof Wall) {
                    try {
                        final BufferedImage image = ImageIO.read(new File("C:\\Users\\TimVl\\Documents\\GitHub\\kutspel\\src\\Images\\wall.png"));
                        Image BufferedImage = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
                        g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                    } catch (IOException e) {
                        System.out.println("KUTIMAGES");
                    }
                }

                else if (board[i][j] instanceof Barricade) {
                    try {
                        final BufferedImage image = ImageIO.read(new File("C:\\Users\\TimVl\\Documents\\GitHub\\kutspel\\src\\Images\\barricade.png"));
                        Image BufferedImage = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
                        g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                    } catch (IOException e) {
                        System.out.println("KUTIMAGES");
                    }
                }

                else if (board[i][j] instanceof Exit) {
                    g2d.setColor(Color.GREEN);
                    g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                }

                else if (board[i][j] instanceof Key) {
                    try {
                        final BufferedImage image = ImageIO.read(new File("C:\\Users\\TimVl\\Documents\\GitHub\\kutspel\\src\\Images\\key.png"));
                        Image BufferedImage = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
                        g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                    } catch (IOException e) {
                        System.out.println("KUTIMAGES");
                    }
                }

                else if (board[i][j] != null) {
                    g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                }
                g2d.setColor(Color.BLACK);
                g2d.drawRect(i * 100, j *100 + 26, 100 , 100);
            }
        }
    }
}
