package kutspel.Objects;

import kutspel.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startmenu extends JFrame {

    private Gameboard gameboard;

    public Startmenu(Gameboard gameboard){
        this.gameboard = gameboard;
    }

    public void Startmenu() {
        setTitle("Menu");
        setSize(400, 65);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton button1 = new JButton("Start game");
        JButton button2 = new JButton("Exit");

        JPanel panel = new JPanel();

        // Add button to JPanel
        panel.add(button1);
        panel.add(button2);

        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.startGame(gameboard);
                dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameboard.dispose();
                dispose();
            }
        });
    }
}
