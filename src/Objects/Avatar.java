package Objects;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends JComponent implements KeyListener {
    //x & y position
    private int xPos;
    private int yPos;

    private Gameboard gameboard;

    //Size of the last known location array of the avatar
    int[] lastLocation = new int[2];

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
        gameboard.repaint();
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
        gameboard.repaint();
        update();
    }

    //Shows the location of the avatar in the run console and restarts the game when the game has been finished
    public void update() {
        if (9 == getCol() & 9 == getRow()) {
            JOptionPane.showMessageDialog(null, "Game finished");
            resetColRow();

        } else {
            used();
            System.out.println(getCol() + " " + getRow());
            lastLocation[0] = getCol();
            lastLocation[1] = getRow();
        }
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    public void used() {
        for (int i = 0; i < gameboard.board.length; i++) {
            for (int j = 0; j < gameboard.board.length; j++) {
                if (gameboard.board[i][j] == gameboard.board[xPos][yPos]) {
                    if (gameboard.board[i][j] instanceof Wall || gameboard.board[i][j] instanceof Barricade) {
                        xPos = lastLocation[0];
                        yPos = lastLocation[1];
                    }
                }
            }
        }
    }
}