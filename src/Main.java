import Objects.Avatar;
import Objects.Square;
import Objects.Wall;

import javax.swing.*;
import java.awt.*;

public class Main
{
    //Size of the frame
    int frameWidth = 1000;
    int frameHeight = 1000;

    //Size of the gameboard
    int row = 9;
    int col = 9;

    Avatar avatar = new Avatar();

    JPanel gameboard = new JPanel();
    JFrame frame = new JFrame();

    public static void main(String[] args)
    {
        Main main = new Main();
        main.setup();
    }

    public void setup(){
        //Setup the frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);

        //Setup the play field
        gameboard.setLayout(new GridLayout(row,col));

        //Fill the frame with squares
        Square[][] squares = new Square[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                    squares[i][j] = new Square();
            }
        }
        squares[3][3] = new Wall();
        drawBoard(squares);

        //An avatar is a square, but with different methods and color

        frame.add(gameboard);
        frame.setVisible(true);
    }

    public void drawBoard(Square squares[][]){
        squares[avatar.getRow()][avatar.getCol()] = avatar;
        gameboard.removeAll();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                gameboard.add(squares[i][j]);
            }
        }
    }

}