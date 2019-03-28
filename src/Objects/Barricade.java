package Objects;


import java.awt.*;

public class Barricade extends Square{
        int code;
        public Barricade(Gameboard gameboard, int x, int y){
                super(gameboard, x, y);
                repaint();
        }

        public void paintComponent(Graphics g) {
                g.setColor(Color.BLUE);
                g.fillRect(getX() * 100, getY() * 100, 100, 100);
                repaint();
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }
}
