package Objects;

import java.awt.*;

public class Exit extends Square {

    public Exit(Gameboard gameboard, int x, int y) {
        super(gameboard, x, y);
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX() * 99, getY() * 99, 100, 100);
        repaint();
    }
}

