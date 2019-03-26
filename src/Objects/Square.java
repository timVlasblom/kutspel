package Objects;

import javax.swing.*;
import java.awt.*;

public class Square extends JLabel {
    private Gameboard gameboard;
    private int x;
    private int y;

    //Sets square settings
    public Square(Gameboard gameboard, int x, int y) {
        setOpaque(false);
        this.gameboard = gameboard;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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
