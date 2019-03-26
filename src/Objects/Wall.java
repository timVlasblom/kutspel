package Objects;

import java.awt.*;

public class Wall extends Square{

        public Wall(Gameboard gameboard, int x, int y){
                super(gameboard, x, y);
                //setBackground(Color.black);
                repaint();
        }

        public void paintComponent(Graphics g) {
                g.setColor(Color.BLACK);
                g.fillRect(getX() * 100, getY() * 100, 100, 100);
                repaint();
        }
}
