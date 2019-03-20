package Objects;

import javax.swing.*;
import java.awt.*;

public class Square extends JLabel {

    public Square(){
        setSize(50, 50);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
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
