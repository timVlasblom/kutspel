package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar extends Square implements KeyListener {
    private int x;
    private int y;

        public Avatar(){
            super();
            setBackground(Color.red);

            x=0;
            y=0;

            setFocusable(true);
            addKeyListener(this);
        }

        public int getRow(){
            return this.x;
        }

        public int getCol(){
            return this.y;
        }

        public void moveUp(){
            this.y+=1;
            repaint();
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

