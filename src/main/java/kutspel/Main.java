package kutspel;

import kutspel.Objects.*;

public class Main {
    public static void main(String[] args) {
        Gameboard gameboard = new Gameboard();
        Startmenu startmenu = new Startmenu(gameboard);
        startmenu.Startmenu();
    }

    public static void startGame(Gameboard gameboard){
        gameboard.setup();
    }

    public static void resetBoard(Gameboard gameboard) {

        gameboard.setup();
    }
}