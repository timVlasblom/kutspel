package kutspel.Objects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startmenu extends Menu {

    //Creates start menu and adds buttons to JFrame
    public Startmenu(Gameboard gameboard) {
        super(gameboard);

        //Create buttons
        JButton startButton = new JButton("Start game");
        JButton exitButton = new JButton("Exit");

        //Add buttons to JPanel
        panel.add(startButton);
        panel.add(exitButton);

        //Perfoms action if pressed
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
                dispose();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
                dispose();
            }
        });
    }

}
