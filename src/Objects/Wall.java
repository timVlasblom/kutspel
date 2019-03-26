package Objects;

import java.awt.*;

public class Wall extends Square{

        public Wall(Gameboard gameboard, int x, int y){
                super(gameboard);
                setBackground(Color.black);
                repaint();
        }

        public void paintComponent(Graphics g, int x, int y) {
                g.setColor(Color.BLACK);
                g.fillRect(x * 100, y * 100, 100, 100);
                repaint();
        }
}
