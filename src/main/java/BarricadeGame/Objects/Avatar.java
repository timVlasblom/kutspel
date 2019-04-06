package BarricadeGame.Objects;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends JComponent implements KeyListener {
    //x&y position, the last known location array of the avatar, gameboard + key
    private int xPos;
    private int yPos;
    private int[] lastLocation;
    private Gameboard gameboard;
    private Key key;

    //Sets up the avatar class
    public Avatar(Gameboard gameboard) {
        xPos = 0;
        yPos = 0;

        setFocusable(true);
        addKeyListener(this);

        Key startKey = new Key(0);

        this.gameboard = gameboard;
        this.key = startKey;
        this.lastLocation = new int[2];
    }

    //Returns the x position of the avatar
    public int getCol() {
        return this.xPos;
    }

    //Returns the y position of the avatar
    public int getRow() {
        return this.yPos;
    }

    //Returns the last known x position of the avatar
    public int getLocationX() {
        return lastLocation[0];
    }

    //Returns the last known y position of the avatar
    public int getLocationY() {
        return lastLocation[1];
    }

    //Returns the key
    public Key getKey() {
        return this.key;
    }

    //Detects if any of the desired keys is pressed and moves the avatar if possible, or brings up the pause menu
    public void keyPressed(KeyEvent event) {
        lastLocation[0] = xPos;
        lastLocation[1] = yPos;

        int x = 0;
        int y = 0;

        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            x = 0;
            y = -1;
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            x = 0;
            y = 1;
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            x = -1;
            y = 0;
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            x = 1;
            y = 0;
        }
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            new Pausemenu(gameboard);
        }
        if (checkPossible(x, y)) {
            moveAvatar(x, y);
        }
        checkFinish();
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    //Checks if move is possible
    public boolean checkPossible(int x, int y) {
        boolean possible = false;
        boolean moveable = true;
        if (((xPos + x) >= 0) && ((xPos + x) < gameboard.getBoardLength()) && ((yPos + y) >= 0) && ((yPos + y) < gameboard.getBoardLength())) {
            possible = true;
            for (int i = 0; i < gameboard.getBoardLength(); i++) {
                for (int j = 0; j < gameboard.getBoardLength(); j++) {
                    if (gameboard.getBoard()[i][j] == gameboard.getBoard()[xPos + x][yPos + y]) {
                        if (gameboard.getBoard()[i][j] instanceof Wall) {
                            moveable = false;
                        }
                        if (gameboard.getBoard()[i][j] instanceof Barricade) {
                            if (!gameboard.checkBarricade(i, j)) {
                                moveable = false;
                            } else {
                                gameboard.getBoard()[i][j] = null;
                            }
                        }
                        if (gameboard.getBoard()[i][j] instanceof Key) {
                            Key keySquare = (Key) gameboard.getBoard()[i][j];
                            swapKeys(keySquare);
                            gameboard.getBoard()[i][j] = null;
                        }
                    }
                }
            }
        }
        if (possible && moveable)
            return true;
        else
            return false;
    }

    //Moves the avatar
    public void moveAvatar(int x, int y) {
        xPos += x;
        yPos += y;
        gameboard.repaint();
    }

    //Gives a message if the game has been finished and brings up the start menu
    public void checkFinish() {
        if (gameboard.getBoardLength() == getCol() + 1 & gameboard.getBoardLength() == getRow() + 1) {
            JOptionPane.showMessageDialog(null, "Game finished, well done!","Cleared", JOptionPane.INFORMATION_MESSAGE);
            gameboard.dispose();
            gameboard = new Gameboard();
            new Startmenu(gameboard);
        }
    }

    //Swaps the avatar key
    public void swapKeys(Key keySquare) {
        this.key = keySquare;
    }
}