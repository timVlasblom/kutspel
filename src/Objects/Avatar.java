package Objects;

import com.sun.javaws.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Avatar extends Square {
    private int x;
    private int y;

    public Avatar() {
        super();
        setBackground(Color.red);

        x = 0;
        y = 0;
    }

    public int getRow() {
        return this.x;
    }

    public int getCol() {
        return this.y;
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
            y += 1;
            Main.drawBoard();
        }
    }
}
