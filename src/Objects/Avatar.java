package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Avatar extends Square {
    private int x;
    private int y;

    public Avatar(Gameboard gameboard) {
        super(gameboard);
        setBackground(Color.red);

        x = 0;
        y = 0;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                moveIt(event);
            }
        });
    }

    public void moveAvatar() {

    }

    public int getRow() {
        return this.x;
    }

    public int getCol() {
        return this.y;
    }

    public void moveIt(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
            y -= 1;
            super.getGameboard().drawBoard();
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
            y += 1;
            super.getGameboard().drawBoard();
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
            x -= 1;
            super.getGameboard().drawBoard();
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            x += 1;
            System.out.println(x);
            super.getGameboard().drawBoard();
        }
    }
}
