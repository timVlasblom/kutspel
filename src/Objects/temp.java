package Objects;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class temp extends JComponent implements KeyListener {
    //x & y position
    private int xPos;
    private int yPos;

    private Gameboard gameboard;

    //Sets up the avatar class
    public temp(Gameboard gameboard) {
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

    //Detects if any of the desired keys is pressed and moves the avatar if possible
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            if (checkPossible(0, -1)) {
                moveAvatar(0, -1);
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            if (checkPossible(0, 1)) {
                moveAvatar(0, 1);
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            if (checkPossible(-1, 0)) {
                moveAvatar(-1, 0);
            }
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            if (checkPossible(1, 0)) {
                moveAvatar(1, 0);
            }
        }
        gameboard.repaint();
        checkFinish();
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    //Shows the location of the avatar in the run console and restarts the game when the game has been finished
    public void checkFinish() {
        if (9 == getCol() & 9 == getRow()) {
            JOptionPane.showMessageDialog(null, "Game finished");
            resetColRow();
        }
    }

    public void moveAvatar(int x, int y) {
        xPos += x;
        yPos += y;
    }

    public boolean checkPossible(int x, int y) {
        if (((xPos + x) >= 0) && ((xPos + x) <= 9) && ((yPos + y) >= 0) && ((yPos + y) <= 9)) {
            for (int i = 0; i < gameboard.board.length; i++) {
                for (int j = 0; j < gameboard.board.length; j++) {
                    if (gameboard.board[i][j] == gameboard.board[xPos + x][yPos + y]) {
                        if (gameboard.board[i][j] instanceof Wall || gameboard.board[i][j] instanceof Barricade) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}