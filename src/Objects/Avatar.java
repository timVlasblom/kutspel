package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends Square implements KeyListener {
    private int x;
    private int y;

    public Avatar(Gameboard gameboard) {
        super(gameboard);
        setBackground(Color.red);

        x = 0;
        y = 0;

        setFocusable(true);
        addKeyListener(this);
    }

    public int getRow() {
        return this.x;
    }

    public int getCol() {
        return this.y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
        repaint();
    }

    public void keyTyped(KeyEvent event) {
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            y -= 1;
            if (y == 0) {
                y += 1;
            } else {
                y = y;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            y += 1;
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            x -= 1;
            if (x == 0) {
                x += 1;
            } else {
                x = x;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            x += 1;
        }
        // super.getGameboard().drawBoard();
        repaint();
    }


    public void keyReleased(KeyEvent event) {
        repaint();
    }

}
