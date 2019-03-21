package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends Square implements KeyListener {
    private int x;
    private int y;

    public Avatar(Gameboard gameboard) {
        super(gameboard);
        setBackground(Color.red);

            x=0;
            y=0;

            setFocusable(true);
            addKeyListener(this);
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

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
        repaint();
    }

    public void keyTyped(KeyEvent e){}

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x+=10;
            repaint();
        }
    }

    public void keyReleased(KeyEvent e){
        repaint();
    }

}
