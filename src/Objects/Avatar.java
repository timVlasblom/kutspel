package Objects;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends JComponent implements KeyListener {
    //x & y position
    private int xPos;
    private int yPos;

    private Gameboard gameboard;

    //Sets up the avatar class
    public Avatar(Gameboard gameboard) {
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

    //Resets the x&y position of the avatar
    public void resetColRow() {
        xPos = 0;
        yPos = 0;
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
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    public void used() {
        for (int i = 0; gameboard.board.length > i; i++) {
            for (int j = 0; gameboard.board[i].length > j; j++) {
                if (gameboard.board[i][j] != null) {
                    System.out.println("kan niet");
                }
            }
        }
    }
}