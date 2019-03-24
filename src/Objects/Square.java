package Objects;

import javax.swing.*;
import java.awt.*;

public class Square extends JLabel {
    private Gameboard gameboard;

    //Sets square settings
    public Square(Gameboard gameboard) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setOpaque(false);
        this.gameboard = gameboard;
    }

    //Returns gameboard
    public Gameboard getGameboard() {
        return this.gameboard;
    }

    /*public void paintComponent(Graphics g){
        g.fillRect(0, 0, 50, 50);
        g.setColor(Color.red);
        repaint();
    }

    /*public void setCordinates(int x, int y){
        this.x = x;
        this.y = y;
    }*/
}
