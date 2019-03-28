package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    //Creates new gameboard
    //JPanel gameboard = new JPanel();

    Squares squares;

    public Gameboard() {
        squares = new Squares();
    }

    //Sets up the game
    public void setup() {

        //Create frame with its attributes, sets exit on close of program, sets size of frame, sets location in middle, sets not resizable, sets visible
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setResizable(false);


        //Sets up the size of the play field
        //gameboard.setLayout(new BorderLayout());
        //gameboard.setPreferredSize(new Dimension(width, height));

        //Adds and draws the gameboard
        //getContentPane().add(squares);

        drawBoard();
        add(squares);

        setSize(width, height);
        setVisible(true);

        //Do board check to see if the level is possible
    }


    public void drawBoard() {
        //Creates avatar (first because we don't want to place a wall on his head)
        squares.add(avatar);

        /*ArrayList<Square> squares = new ArrayList<>();
        squares.add(new Wall(7, 7));
        squares.add(new Barricade(5, 5));*/

        squares.add(new Wall(3,3));
        squares.add(new Barricade(6,6));

        //squares.add(new Square(4,4));
        //squares.add(new Square(2,2));

        //Wall wall1 = new Wall(this, 7, 7);
        //getContentPane().add(wall1);
        //gameboard.add(wall1);

        //Wall wall2 = new Wall(this, 4, 4);
        //getContentPane().add(wall2);
        //gameboard.add(wall2);
        //squareArrayList.add(new Barricade(this, 5, 6));
        repaint();
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
    }
}
