package Objects;

import javax.swing.*;
import java.awt.*;

public class Gameboard extends JFrame {

    //Size of the gameboard
    int row = 10;
    int col = 10;

    //Size of the last known location array
    int[] lastLocation = new int[2];

    //Size of the frame
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;

    //Create new avatar
    Avatar avatar = new Avatar(this);

    JPanel gameboard = new JPanel();
    //JFrame frame = new JFrame();

    Square[][] squares = new Square[row][col];

    public void setup() {
        //Create frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);

        //Setup the play field
        gameboard.setLayout(new GridLayout(row, col));

        // Draw lines

        // Create avatar (first because we don't want to place a wall on his head)

        //Fill the frame with squares and set it visible
        add(gameboard);
        setVisible(true);
        drawBoard();

        // Do board check to see if the level is possible

    }

    public void drawBoard() {
        //squares[lastLocation[0]][lastLocation[1]] = new Square(this);
        //squares[0][0] = null;
        squares[avatar.getRow()][avatar.getCol()] = avatar;

        gameboard.removeAll();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (squares[i][j] != avatar) {
                    squares[i][j] = new Square(this);
                }
                gameboard.add(squares[i][j]);
            }
        }
        //lastLocation[0] = avatar.getRow();
        //lastLocation[1] = avatar.getCol();
        System.out.println(avatar.getRow() + " " + avatar.getCol());
    }
}
