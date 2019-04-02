package Objects;

import javax.swing.*;
import java.awt.*;

public class Wall extends Square {

        public Wall(int x, int y){
            super(x, y);
        }

    public void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        System.out.println(getX());
        System.out.println(getY());
        g.fillRect(getXpos() * 100, getYpos() * 100, 100, 100);
        repaint();
    }
}
