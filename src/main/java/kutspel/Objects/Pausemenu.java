package kutspel.Objects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pausemenu extends Menu{

    public Pausemenu(Gameboard gameboard){
        super(gameboard);

        JButton resumeButton = new JButton("Resume");
        JButton resetButton = new JButton("Reset game");
        JButton exitButton = new JButton("Exit");

        // Add button to JPanel
        panel.add(resumeButton);
        panel.add(resetButton);
        panel.add(exitButton);

        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
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

    public void resetBoard() {
        gameboard.dispose();
        gameboard = new Gameboard();
        gameboard.setup();
    }
}