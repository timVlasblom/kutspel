package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends JComponent implements KeyListener {
    private int xPos;
    private int yPos;
    private Gameboard gameboard;

    //Sets up the avatar class
    public Avatar(Gameboard gameboard) {
        //setBorder(BorderFactory.createLineBorder(Color.black));
        //SetBackground(Color.red);
        setSize(1000, 1000);
        xPos = 0;
        yPos = 0;
        setFocusable(true);
        addKeyListener(this);
        this.gameboard = gameboard;
    }

    //Returns the x position of the avatar
    public int getCol() {
        return this.xPos;
    }

    //Returns the y position of the avatar
    public int getRow() {
        return this.yPos;
    }

    public void resetCol() {
        xPos = 0;
    }

    //Returns the y position of the avatar
    public void resetRow() {
        yPos = 0;
    }

    //Makes the player (avatar) red and sets the start location
//    public void paintComponent(Graphics g) {
//        g.setColor(Color.RED);
//        g.fillRect(xPos * 100, yPos * 100, 100, 100);
//        ///repaint();
//    }

    //null
    public void keyTyped(KeyEvent event) {
    }

    //Detects if any of the desired keys is pressed and moves the avatar
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            yPos -= 1;
            if (yPos <= -1) {
                yPos = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            yPos += 1;
            if (yPos > 9) {
                yPos = 9;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            xPos -= 1;
            if (xPos <= -1) {
                xPos = 0;
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            xPos += 1;
            if (xPos > 9) {
                xPos = 9;
            }
        }
        gameboard.update();
        repaint();
    }

//    null
    public void keyReleased(KeyEvent event) {
        gameboard.update();
    }

}
