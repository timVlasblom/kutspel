package Objects;

import java.awt.*;

public class Wall extends Square {

    public Wall(Gameboard gameboard, int x, int y) {
        super(gameboard, x, y);
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX() * 99, getY() * 99, 100, 100);
        repaint();
    }
}
