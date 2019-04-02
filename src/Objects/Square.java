package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Square extends JComponent {
    private int xPos;
    private int yPos;

    //Sets square settings
    public Square() {
    }

    public int getXpos() {
        return this.xPos;
    }

    public int getYpos() {
        return this.yPos;
    }


   public void paintComponent(Graphics g){
       super.paintComponent(g);
        g.fillRect(xPos*100, yPos*100, 100, 100);
        g.setColor(Color.darkGray);
    }

    /*public void setCordinates(int x, int y){
        this.x = x;
        this.y = y;
    }*/
}
