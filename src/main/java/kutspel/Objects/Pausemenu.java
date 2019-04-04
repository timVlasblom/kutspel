package kutspel.Objects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pausemenu extends Menu {

    //Creates pause menu and adds buttons to JFrame
    public Pausemenu(Gameboard gameboard) {
        super(gameboard);

        //Create buttons
        JButton resumeButton = new JButton("Resume");
        JButton resetButton = new JButton("Reset game");
        JButton exitButton = new JButton("Exit");

        //Add buttons to JPanel
        panel.add(resumeButton);
        panel.add(resetButton);
        panel.add(exitButton);

        //Perfoms action if pressed
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetBoard();
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

    //Resets the gameboard
    public void resetBoard() {
        gameboard.dispose();
        gameboard = new Gameboard();
        gameboard.setup();
    }
}