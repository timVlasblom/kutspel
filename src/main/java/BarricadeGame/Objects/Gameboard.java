package BarricadeGame.Objects;

import java.awt.*;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Gameboard extends JFrame {
    //Size of the application frame
    static private int width = 1300;
    static private int height = 1000;

    //Static paths of images
    static private String keyImg = "src\\main\\resources\\key.png";
    static private String avatarImg = "src\\main\\resources\\avatar.png";
    static private String barricadeImg = "src\\main\\resources\\barricade.png";
    static private String wallImg = "src\\main\\resources\\wall.png";

    //Avatar and gameboard, Square array for board (colum x row)
    private Avatar avatar;
    private JPanel gameboard;
    private Square[][] board;
    private boolean setup;

    //Sets up the gameboard class
    public Gameboard() {
        this.avatar = new Avatar(this);
        this.board = new Square[10][10];
        this.gameboard = new JPanel();
        setup = true;
    }

    //Sets up the JFrame and the game;
    public void setup() {
        getContentPane().setPreferredSize(new Dimension(width, height));
        setUndecorated(true);

        drawLevel();
        add(gameboard);
        gameboard.add(avatar);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Returns the length of the gameboard
    public int getBoardLength() {
        return this.board.length;
    }

    //Returns the array of the gameboard
    public Square[][] getBoard() {
        return this.board;
    }

    //Creates all other objects
    public void drawLevel() {
        gameboard.setLayout(new BorderLayout());

        board[9][9] = new Exit();
        board[1][0] = new Wall();
        board[2][0] = new Wall();
        board[1][1] = new Wall();
        board[5][1] = new Wall();
        board[6][1] = new Wall();
        board[8][1] = new Wall();
        board[1][2] = new Wall();
        board[3][2] = new Wall();
        board[7][2] = new Wall();
        board[3][3] = new Wall();
        board[5][3] = new Wall();
        board[6][3] = new Wall();
        board[7][3] = new Wall();
        board[9][3] = new Wall();
        board[0][4] = new Wall();
        board[1][4] = new Wall();
        board[3][4] = new Wall();
        board[4][4] = new Wall();
        board[0][5] = new Wall();
        board[1][5] = new Wall();
        board[2][5] = new Wall();
        board[3][5] = new Wall();
        board[4][5] = new Wall();
        board[5][5] = new Wall();
        board[7][5] = new Wall();
        board[8][5] = new Wall();
        board[9][5] = new Wall();
        board[3][6] = new Wall();
        board[4][6] = new Wall();
        board[9][6] = new Wall();
        board[1][7] = new Wall();
        board[5][7] = new Wall();
        board[7][7] = new Wall();
        board[8][7] = new Wall();
        board[9][7] = new Wall();
        board[1][8] = new Wall();
        board[2][8] = new Wall();
        board[3][8] = new Wall();
        board[9][8] = new Wall();
        board[4][9] = new Wall();
        board[5][9] = new Wall();
        board[6][9] = new Wall();
        board[7][9] = new Wall();

        Key key100 = new Key(100);
        Key key150 = new Key(150);
        Key key200 = new Key(200);
        Key key300 = new Key(300);

        board[2][4] = key100;
        board[9][4] = key100;
        board[6][2] = key150;
        board[5][4] = key200;
        board[3][9] = key300;

        board[3][1] = new Barricade(key100);
        board[6][4] = new Barricade(key100);
        board[8][2] = new Barricade(key150);
        board[6][6] = new Barricade(key200);
        board[8][8] = new Barricade(key300);
    }

    //Checks if the barricade code matches the key code
    public boolean checkBarricade(int i, int j) {
        Barricade barricade = (Barricade) board[i][j];
        if (barricade.checkKey(avatar.getKey())) {
            return true;
        } else {
            return false;
        }
    }

    //Paints everything on the the board
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = g.getFont().deriveFont(18.0f);
        g.setFont(font);

        if (setup) {
            for (int i = 0; board.length > i; i++) {
                for (int j = 0; board[i].length > j; j++) {
                    if (board[i][j] instanceof Wall) {
                        try {
                            final BufferedImage image = ImageIO.read(new File(wallImg));
                            Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            g.drawImage(BufferedImage, i * 100, j * 100, null);
                        } catch (IOException e) {
                            System.out.println("Wall error");
                        }
                    } else if (board[i][j] instanceof Barricade) {
                        try {
                            final BufferedImage image = ImageIO.read(new File(barricadeImg));
                            Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            g.drawImage(BufferedImage, i * 100, j * 100, null);
                            g.setColor(Color.WHITE);
                            Barricade barricade = (Barricade) board[i][j];
                            String keyValue = barricade.getCode() + "";
                            g.drawString(keyValue, i * 100 + 5, j * 100 + 19);
                        } catch (IOException e) {
                            System.out.println("Barricade error");
                        }
                    } else if (board[i][j] instanceof Key) {
                        try {
                            g2d.setColor(Color.LIGHT_GRAY);
                            g2d.fillRect(i * 100, j * 100, 100, 100);
                            final BufferedImage image = ImageIO.read(new File(keyImg));
                            Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            g.drawImage(BufferedImage, i * 100, j * 100, null);
                            g.setColor(Color.BLACK);
                            Key key = (Key) board[i][j];
                            String keyValue = key.getCode() + "";
                            g.drawString(keyValue, i * 100 + 5, j * 100 + 19);
                        } catch (IOException e) {
                            System.out.println("Key error");
                        }
                    } else if (board[i][j] instanceof Exit) {
                        g2d.setColor(Color.GREEN);
                        g2d.fillRect(i * 100, j * 100, 100, 100);
                    } else if (board[i][j] == null) {
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(i * 100, j * 100, 100, 100);
                    } else if (board[i][j] != null) {
                        g2d.fillRect(i * 100, j * 100, 100, 100);
                    }
                    g2d.setColor(Color.GRAY);
                    g2d.drawRect(i * 100, j * 100, 100, 100);
                }
            }
            g2d.fillRect(avatar.getLocationX() * 100, avatar.getLocationY() * 100, 100, 100);

            g2d.setColor(new Color(112, 112, 112));
            g2d.fillRect(1000, 0, width - 1000, height);

            g.setColor(Color.BLACK);
            g.drawString("Currently holding:", 1080, 100);
            g.drawString("Press ESC for menu", 1070, 980);
            g.drawString("Controls:", 1050, 490);
            g.drawString("Up = Arrow up or W", 1050, 530);
            g.drawString("Down = Arrow Down or S", 1050, 550);
            g.drawString("Left = Arrow Left or A", 1050, 570);
            g.drawString("Right = Arrow Right or D", 1050, 590);
        } else {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(avatar.getLocationX() * 100, avatar.getLocationY() * 100, 100, 100);
            g2d.setColor(Color.GRAY);
            g2d.drawRect(avatar.getLocationX() * 100, avatar.getLocationY() * 100, 100, 100);
        }
        try {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(avatar.getCol() * 100 + 1, avatar.getRow() * 100 + 1, 99, 99);
            final BufferedImage image = ImageIO.read(new File(avatarImg));
            Image BufferedImage = image.getScaledInstance(99, 99, Image.SCALE_SMOOTH);
            g.drawImage(BufferedImage, avatar.getCol() * 100 + 1, avatar.getRow() * 100 + 1, null);
        } catch (IOException e) {
            System.out.println("Avatar error");
        }
        try {
            g2d.setColor(Color.darkGray);
            g2d.fillRect(1100, 125, 100, 100);
            if (avatar.getKey().getCode() != 0) {
                g.setColor(Color.WHITE);
                String keyValue = avatar.getKey().getCode() + "";
                g.drawString(keyValue, 1105, 145);
                final BufferedImage image = ImageIO.read(new File(keyImg));
                Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                g.drawImage(BufferedImage, 1101, 122, null);
            }
        } catch (IOException e) {
            System.out.println("Display error");
        }
        setup = false;
    }
}