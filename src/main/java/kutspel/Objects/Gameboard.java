package kutspel.Objects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Gameboard extends JFrame implements ActionListener{

    //Size of the application frame, length of the board
    static private int width = 1300;
    static private int height = 1029;
    private int boardLength;

    boolean setup = true;
    //Static paths of images
    static private String keyImg = "src\\main\\resources\\key.png";
    static private String avatarImg = "src\\main\\resources\\avatar.png";
    static private String barricadeImg = "src\\main\\resources\\barricade.png";
    static private String wallImg = "src\\main\\resources\\wall.png";


    //Creates new avatar, Square array for board (colum x row), new gameboard
    private Avatar avatar;
    private Square[][] board;
    private JPanel gameboard;

    public Gameboard() {
        this.avatar = new Avatar(this);
        this.board = new Square[10][10];
        this.gameboard = new JPanel();
    }

    //Sets up the game; Create frame with its attributes, draws level, adds gameboard and avatar, sets exit on close of program, sets size of frame, sets not resizable, sets location in middle, sets visible
    public void setup() {
        boardLength = board.length - 1;
        startLevel();
        add(gameboard);
        gameboard.add(avatar);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(width, height));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Returns the length of the gameboard
    public int getBoardLength() {
        return this.boardLength;
    }

    //Returns the length of the gameboard
    public Square[][] getBoard() {
        return this.board;
    }

    //Creates avatar (first because we don't want to place a wall on his head), then creates all other objects
    public void startLevel() {
        gameboard.setLayout(new BorderLayout());

        board[3][3] = new Wall();
        board[1][0] = new Wall();
        board[2][0] = new Wall();
        board[2][2] = new Wall();
        board[2][3] = new Wall();
        board[3][4] = new Wall();
        board[4][4] = new Wall();
        board[5][5] = new Wall();
        board[1][5] = new Wall();
        board[2][5] = new Wall();
        board[3][8] = new Wall();
        board[0][6] = new Wall();
        board[9][9] = new Exit();
        Key key200 = new Key(200);
        board[2][1] = key200;
        Key key100 = new Key(100);
        board[2][2] = key100;
        board[3][1] = new Barricade(key200);
        board[3][2] = new Barricade(key100);
        board[6][6] = new Barricade(key100);
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
        if (setup) {
            for (int i = 0; board.length > i; i++) {
                for (int j = 0; board[i].length > j; j++) {
                    if (board[i][j] instanceof Wall) {
                        try {
                            final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\wall.png"));
                            Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                        } catch (IOException e) {
                            System.out.println("Barricade error");
                        }
                    } else if (board[i][j] instanceof Barricade) {
                        try {
                            final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\barricade.png"));
                            Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                        } catch (IOException e) {
                            System.out.println("Barricade error");
                        }

                    } else if (board[i][j] instanceof Key) {
                        try {
                            g2d.setColor(Color.LIGHT_GRAY);
                            g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                            final BufferedImage image = ImageIO.read(new File("src\\main\\resources\\key.png"));
                            Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            g.drawImage(BufferedImage, i * 100, j * 100 + 26, null);
                            g.setColor(Color.BLACK);
                            g.drawString("hoi", i * 100 + 5, j * 100 + 41);
                        } catch (IOException e) {
                            System.out.println("Key error");
                        }
                    } else if (board[i][j] instanceof Exit) {
                        g2d.setColor(Color.GREEN);
                        g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                    } else if (board[i][j] == null) {
                        g2d.setColor(Color.LIGHT_GRAY);
                        g2d.fillRect(i * 100, j * 100 + 26, 100, 100);
                    }
                    g2d.setColor(Color.GRAY);
                    g2d.drawRect(i * 100, j * 100 + 26, 100, 100);
                }
                g2d.fillRect(avatar.getLocationX() * 100, avatar.getLocationY() * 100 + 26, 100, 100);

                Font font = g.getFont().deriveFont(18.0f);
                g.setFont(font);
            }
        }else{
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(avatar.getLocationX() * 100, avatar.getLocationY() * 100 + 26, 100, 100);
            g2d.setColor(Color.GRAY);
            g2d.drawRect(avatar.getLocationX() * 100, avatar.getLocationY() * 100 + 26, 100, 100);
        }

        try {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(avatar.getCol() * 100, avatar.getRow() * 100 + 26, 100, 100);
            final BufferedImage image = ImageIO.read(new File(avatarImg));
            Image BufferedImage = image.getScaledInstance(99, 99, Image.SCALE_SMOOTH);
            g.drawImage(BufferedImage, avatar.getCol() * 100 + 1, avatar.getRow() * 100 + 27, null);
            g2d.setColor(Color.GRAY);
            g2d.drawRect(avatar.getCol() * 100, avatar.getRow() * 100 + 26, 100, 100);
        } catch (IOException e) {
            System.out.println("Avatar error");
        }
        try {

            g2d.setColor(new Color(112, 112, 112));
            g2d.fillRect(1000, 0, width - 1000, height);

            g2d.setColor(Color.darkGray);
            g2d.fillRect(1100, 129, 100, 100);

            g.setColor(Color.BLACK);
            g.drawString("Currently holding", 1080, 120);
            if (avatar.getKey().getCode() != 0) {
                final BufferedImage image = ImageIO.read(new File(keyImg));
                Image BufferedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                g.drawImage(BufferedImage, 1105, 129, null);
                g.setColor(Color.WHITE);
                String keyValue = avatar.getKey().getCode() + "";
                g.drawString(keyValue, 1100, 145);
            }
        } catch (IOException e) {
            System.out.println("Display error");
        }
        setup = false;
    }

    public void actionPerformed(ActionEvent event){

    }
}
