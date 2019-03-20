package Objects;

import javax.swing.*;
import java.awt.*;

public class Avatar extends Square{
    private int x;
    private int y;

        public Avatar(){
            super();
            setBackground(Color.red);

            x=0;
            y=0;
        }

        public int getRow(){
            return this.x;
        }

        public int getCol(){
            return this.y;
        }
}