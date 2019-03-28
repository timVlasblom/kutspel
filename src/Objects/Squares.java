package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Squares extends JPanel {
    private Square[][] squares;


    public Squares(){
        squares = new Square[10][10];
        setLayout(new BorderLayout());

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                squares[i][j] = new Square(i, j);
                add(squares[i][j]);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void addClass(Square square){

        int x = square.getX();
        int y = square.getY();
        squares[x][y] = square;
    }
}
