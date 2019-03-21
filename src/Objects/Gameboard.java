package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class Gameboard extends JFrame{

    //Size of the frame
    int frameWidth = 1000;
    int frameHeight = 1000;

    //Size of the gameboard
    int row = 9;
    int col = 9;

    Avatar avatar = new Avatar(this);

    JPanel gameboard = new JPanel();
    //JFrame frame = new JFrame();

    Square[][] squares = new Square[row][col];

    public void setup() {
        //Setup the frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setResizable(false);

        //Setup the play field
        gameboard.setLayout(new GridLayout(row, col));

        //Fill the frame with squares

        add(gameboard);
        setVisible(true);
        drawBoard();
        //An avatar is a square, but with different methods and color

        frame.add(gameboard);
        frame.setVisible(true);
        while (true){
            avatar.moveAvatar();
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){}

        }
    }

    public void drawBoard() {
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
    }

}
