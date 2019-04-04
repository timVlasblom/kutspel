package kutspel.Objects;

import kutspel.Main;
import kutspel.Objects.Gameboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startmenu extends Menu {

    public Startmenu(Gameboard gameboard) {
        super(gameboard);

        JButton startButton = new JButton("Start game");
        JButton exitButton = new JButton("Exit");

        // Add button to JPanel
        panel.add(startButton);
        panel.add(exitButton);

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
