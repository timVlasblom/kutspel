import Objects.Avatar;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public int boardSize = 9;

    public static void main(String[] args)
    {
        //Gameboard gameboard = new Gameboard;
        Avatar avatar = new Avatar();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        JPanel bord = new JPanel();
        bord.setLayout(new GridLayout(5,5));


        for(int i = 0; i < 25; i++){
            bord.add(new JButton());
        }


        frame.add(bord);
        frame.setVisible(true);
    }

}