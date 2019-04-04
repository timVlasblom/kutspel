package kutspel.Objects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    Gameboard gameboard;
    JPanel panel;

    public Menu (Gameboard gameboard){
        this.gameboard = gameboard;

        this.panel = new JPanel();

        setTitle("Menu");
        setSize(400, 65);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);
    }

    public void startGame(){
        gameboard.setup();
    }

    public void exit(){
        gameboard.dispose();
    }

}
