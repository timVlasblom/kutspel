package kutspel.Objects;

import kutspel.Main;
import kutspel.Objects.Gameboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startmenu extends JFrame {

    Gameboard gameboard = new Gameboard();

    public void Startmenu() {
        setTitle("Menu");
        setSize(400, 65);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton button1 = new JButton("Start game");
        JButton button2 = new JButton("Reset game");
        JButton button3 = new JButton("Exit");

        JPanel panel = new JPanel();

        // Add button to JPanel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.startGame();
                dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.resetBoard(gameboard);
                dispose();
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameboard.dispose();
                dispose();
            }
        });
    }
}
