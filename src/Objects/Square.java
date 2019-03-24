package Objects;

import javax.swing.*;
import java.awt.*;

public class Square extends JLabel {
    private Gameboard gameboard;

    public Square(Gameboard gameboard){
        setBorder(BorderFactory.createLineBorder(Color.black));
        //this.gameboard = gameboard;
    }

    /*public Gameboard getGameboard(){
        return this.gameboard;
    }

    /*public void paintComponent(Graphics g){
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.red);
        repaint();
    }

    public void setCordinates(int x, int y){
        this.x = x;
        this.y = y;
    }*/
}
