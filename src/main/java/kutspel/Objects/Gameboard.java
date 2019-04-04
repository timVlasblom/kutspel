package kutspel.Objects;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.WindowConstants;
import java.awt.image.BufferedImage;
import java.io.File;

public class Gameboard extends JFrame {
    //Size of the application frame
    static int width = 1003;
    static int height = 1029;

    int boardLength;

    //Creates new avatar and gameboard, makes a list of all objects, the amount of squares in the field, colum x row
    Avatar avatar = new Avatar(this);
    JPanel gameboard = new JPanel();
    Square[][] board = new Square[10][10];


    //Sets up the game; Create frame with its attributes, draws level, adds gameboard, sets exit on close of program, sets size of frame, sets not resizable, sets location in middle, sets visible
    public void setup() {
        boardLength = board.length - 1;
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
        board[2][1] = new Key();
        Key key100 = new Key();
        board[2][2] = key100;

        board[6][6] = new Barricade(key100);
    }

    public boolean checkBarricade(int i, int j){
        Barricade barricade = (Barricade) board[i][j];
        if(barricade.checkKey(avatar.getKey())){
            return true;
        }
        else{
            return false;
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(avatar.lastLocation[0] * 100, avatar.lastLocation[1] * 100 + 26, 100, 100);
        for (int i = 0; board.length > i; i++) {
            for (int j = 0; board[i].length > j; j++) {

                if (board[i][j] instanceof Wall) {
                    try {
                        final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\wall.png"));
                        Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                    } catch (IOException e) {
                        System.out.println("KUTIMAGES");
                    }
                } else if (board[i][j] instanceof Barricade) {
                    try {
                        final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\barricade.png"));
                        Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                    } catch (IOException e) {
                        System.out.println("KUTIMAGES");
                    }
                } else if (board[i][j] instanceof Exit) {
                    g2d.setColor(Color.GREEN);
                    g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                } else if (board[i][j] instanceof Key) {
                    try {
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                        final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\key.png"));
                        Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                    } catch (IOException e) {
                        System.out.println("KUTIMAGES");
                    }
                } else if (board[i][j] == null) {
                    g2d.setColor(Color.LIGHT_GRAY);
                    g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                } else if (board[i][j] != null) {
                    g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                }
                g2d.setColor(Color.BLACK);
                g2d.drawRect(i * 100, j * 100 + 26, 100, 100);
            }
            try {
                final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\avatar.png"));
                Image BufferedImage = image.getScaledInstance(99,99, Image.SCALE_SMOOTH);
                g.drawImage(BufferedImage, avatar.getCol() * 100 + 1, avatar.getRow() * 100 + 27, null);
            } catch (IOException e) {
                System.out.println("KUTIMAGES");
            }
        }
        try {
            final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\avatar.png"));
            Image BufferedImage = image.getScaledInstance(99, 99, Image.SCALE_SMOOTH);
            g.drawImage(BufferedImage, avatar.getCol() * 100 + 1, avatar.getRow() * 100 + 27, null);
        } catch (IOException e) {
            System.out.println("KUTIMAGES");
        }
    }
}
