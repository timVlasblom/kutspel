package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Squares extends JPanel {
    private Square[][] squares;


    public Squares(){
        squares = new Square[10][10];
        setLayout(new BorderLayout());

        drawPanel();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void drawPanel(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(squares[i][j] == null){
                    removeAll();
                    squares[i][j] = new Square(i, j);
                }
                add(squares[i][j]);
            }
        }

    }

    public void addClass(Square square){

        int x = square.getXpos();
        int y = square.getYpos();
        squares[x][y] = square;
        drawPanel();
    }
}
