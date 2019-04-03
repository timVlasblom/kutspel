package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends JComponent implements KeyListener {
    //x & y position
    private int xPos;
    private int yPos;

    private Gameboard gameboard;
    private Key key;

    protected Image image;

    //Sets up the avatar class
    public Avatar(Gameboard gameboard) {
        xPos = 0;
        yPos = 0;
        setFocusable(true);
        addKeyListener(this);
        this.gameboard = gameboard;
//        image = Toolkit.getDefaultToolkit().createImage("src/Warlock.png");

        Key test = new Key();
        this.key = test;
    }

    public Image getImage() {
        return image;
    }

    public Key getKey(){
        return this.key;
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

        if(checkMovable(x,y)){
            moveAvatar(x,y);
        }

        gameboard.repaint();
        checkFinish();
    }


    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    public void moveAvatar(int x, int y) {
        xPos += x;
        yPos += y;
    }

    //Shows the location of the avatar in the run console and restarts the game when the game has been finished
    public void checkFinish() {
        if (gameboard.boardLength == getCol() & gameboard.boardLength == getRow()) {
            JOptionPane.showMessageDialog(null, "Game finished");
            resetColRow();
        }
    }

    public boolean checkMovable(int x, int y) {
        if (((xPos + x) >= 0) && ((xPos + x) <= gameboard.boardLength) && ((yPos + y) >= 0) && ((yPos + y) <= gameboard.boardLength)) {
            if (!checkPossible(x, y)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPossible(int x, int y) {

        for (int i = 0; i < gameboard.boardLength; i++) {
            for (int j = 0; j < gameboard.boardLength; j++) {
                if (gameboard.board[i][j] == gameboard.board[xPos + x][yPos + y]) {
                    if (gameboard.board[i][j] instanceof Wall) {
                        return true;
                    }
                    if (gameboard.board[i][j] instanceof Barricade) {
                        if (!gameboard.checkBarricade(i, j)) {
                            return true;
                        }
                        else{
                            gameboard.board[i][j] = null;
                        }
                    }
                    if (gameboard.board[i][j] instanceof Key) {
                        Key keySquare = (Key) gameboard.board[i][j];
                        swapKeys(keySquare);
                        gameboard.board[i][j] = null;
                    }

                }
            }
        }
        return false;
    }

    public void swapKeys(Key keySquare){
        this.key = keySquare;
    }


}