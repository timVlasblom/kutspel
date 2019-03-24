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

    //Sets up the avatar class
    public Avatar(Gameboard gameboard) {
        super(gameboard);
        //SetBackground(Color.red);

        x = 0;
        y = 0;
        x1 = 0;
        y1 = 0;
        setFocusable(true);
        addKeyListener(this);
    }

    //Returns the x position of the avatar
    public int getCol() {
        return this.x;
    }

    //Returns the y position of the avatar
    public int getRow() {
        return this.y;
    }

    //Makes the player (avatar) red and sets the start location
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x1, y1, 50, 50);
        setOpaque(false);
        repaint();
    }

    //null
    public void keyTyped(KeyEvent event) {
    }

    //Detects if any of the desired keys is pressed and moves the avatar
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            y1 -= 100;
            y -= 1;
            if (y <= -1) {
                y1 = 0;
                y = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            y1 += 100;
            y += 1;
            if (y > 9) {
                y1 = 900;
                y = 9;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            x1 -= 100;
            x -= 1;
            if (x <= -1) {
                x1 = 0;
                x = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            x1 += 100;
            x += 1;
            if (x > 9) {
                x1 = 900;
                x = 9;
            }
        }
        super.getGameboard().update();
        repaint();
    }

    //null
    public void keyReleased(KeyEvent event) {
        repaint();
    }

}
