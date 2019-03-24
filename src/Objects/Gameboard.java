package Objects;

import javax.swing.*;
import java.awt.*;

public class Gameboard extends JFrame {

    //Size of the application frame, in pixels
    static int width = 1000;
    static int height = 1000;

    //The amount of squares in the field, colum x row
    int col = 10;
    int row = 10;

    //Size of the last known location array of the avatar
    int[] lastLocation = new int[2];

    //Creates new avatar
    Avatar avatar = new Avatar(this);

    //Creates new gameboard
    JPanel gameboard = new JPanel();
    //JFrame frame = new JFrame();

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
        gameboard.setLayout(new GridLayout(col, row));

        //Draw lines (instead of squares?)

        //Adds and draws the gameboard
        add(gameboard);
        drawBoard();

        //Do board check to see if the level is possible

    }

    public void drawBoard() {
        //squares[lastLocation[0]][lastLocation[1]] = new Square(this);
        //squares[0][0] = null;

        //Creates avatar (first because we don't want to place a wall on his head)
        squares[avatar.getCol()][avatar.getRow()] = avatar;

        //Fills the frame with squares
        gameboard.removeAll();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (squares[i][j] != avatar) {
                    squares[i][j] = new Square(this);
                }
                gameboard.add(squares[i][j]);
            }
        }
        //lastLocation[0] = avatar.getCow();
        //lastLocation[1] = avatar.getRol();

    }

    //Shows the location of the avatar in the run console and closes the frame when the game has been finished
    public void update() {
        if (squares[9][9] == squares[avatar.getCol()][avatar.getRow()]) {
            System.out.println("Game finished");
            dispose();
        } else {
            System.out.println(avatar.getCol() + " " + avatar.getRow());
        }
    }
}
