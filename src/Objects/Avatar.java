package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends Square implements KeyListener {
    private int x;
    private int y;
    private int x1;
    private int y1;

    public Avatar(Gameboard gameboard) {
        super(gameboard);
        setBackground(Color.red);

        x = 0;
        y = 0;
        x1 = 0;
        y1 = 0;
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
        g.fillRect(x1, y1, 50, 50);
        repaint();
    }

    public void keyTyped(KeyEvent event) {
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            y1 -= 10;
            if (y1 <= -1) {
                y1 = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            y1 += 10;
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            x1 -= 10;
            if (x1 <= -1) {
                x1 = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            x1 += 10;
        }
        // super.getGameboard().drawBoard();
        repaint();
    }


    public void keyReleased(KeyEvent event) {
        repaint();
    }

}
