package kutspel.Objects;

import javax.swing.*;

public class Menu extends JFrame {

    Gameboard gameboard;
    JPanel panel;

    //Creates menu JFrame and adds JPanel
    public Menu(Gameboard gameboard) {
        this.gameboard = gameboard;
        this.panel = new JPanel();

        setTitle("Menu");
        setSize(400, 65);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        //Adds JPanel to the JFrame
        this.getContentPane().add(panel);
    }

    //Starts the game
    public void startGame() {
        gameboard.setup();
    }

    //Closes the game
    public void exit() {
        gameboard.dispose();
    }
}
