package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends JLabel implements KeyListener {
    private int x;
    private int y;
    private Gameboard gameboard;

    //Sets up the avatar class
    public Avatar(Gameboard gameboard) {
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setOpaque(false);
        //SetBackground(Color.red);
        setSize(1000, 1000);
        x = 0;
        y = 0;
        setFocusable(true);
        addKeyListener(this);
        this.gameboard = gameboard;
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
        g.fillRect(x * 100, y * 100, 100, 100);
        repaint();
    }

    //null
    public void keyTyped(KeyEvent event) {
    }

    //Detects if any of the desired keys is pressed and moves the avatar
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            y -= 1;
            if (y <= -1) {
                y = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            y += 1;
            if (y > 9) {
                y = 9;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            x -= 1;
            if (x <= -1) {
                x = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            x += 1;
            if (x > 9) {
                x = 9;
            }
        }
        System.out.println(x + " " + y);
        //gameboard.update();
        repaint();
    }

    //null
    public void keyReleased(KeyEvent event) {
        repaint();
    }

}
