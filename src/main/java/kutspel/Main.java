package kutspel;

import kutspel.Objects.*;

public class Main {
    public static void main(String[] args) {
        Gameboard gameboard = new Gameboard();
        gameboard.setup();
    }

    public static void resetBoard(Gameboard gameboard){
        gameboard.dispose();
        gameboard = new Gameboard();
        gameboard.setup();
    }
}