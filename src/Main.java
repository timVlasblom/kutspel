import Objects.Avatar;
import Objects.Square;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        //Size of the frame
        int frameWidth = 1000;
        int frameHeight = 1000;

        //Size of the gameboard
        int row = 9;
        int col = 9;

        Avatar avatar = new Avatar();

        //Setup the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);

        //Setup the play field
        JPanel gameboard = new JPanel();
        gameboard.setLayout(new GridLayout(row,col));

        //Fill the frame with squares
        Square[][] squares = new Square[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                squares[i][j] = new Square();

                gameboard.add(squares[i][j]);
            }
        }

        //An avatar is a square, but with different methods and color
        squares[0][0].setBackground(Color.red);

        frame.add(gameboard);
        frame.setVisible(true);
    }

}