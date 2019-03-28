package Objects;

import javax.swing.*;
import java.awt.*;

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
    JPanel gameboard = new JPanel();

    //Creates new squares
    Square[][] squares = new Square[col][row];

    //Sets up the game
    public void setup() {

        //Create frame with its attributes, sets exit on close of program, sets size of frame, sets location in middle, sets not resizable, sets visible
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //Sets up the size of the play field
        gameboard.setLayout(new BorderLayout());
        //gameboard.setPreferredSize(new Dimension(width, height));

        //Draw lines (instead of squares?)

        //Adds and draws the gameboard
        getContentPane().add(gameboard);
        drawBoard();

        //Do board check to see if the level is possible
    }


    public void drawBoard() {
        //Creates avatar (first because we don't want to place a wall on his head)
        gameboard.removeAll();
        gameboard.add(avatar);
        gameboard.add(new Wall(this, 5, 2));
        //gameboard.add(new Exit(this, 9, 9));
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
