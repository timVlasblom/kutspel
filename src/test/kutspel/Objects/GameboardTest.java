package kutspel.Objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameboardTest {
    private Gameboard gameboard;

    @Before
    public void setUp() throws Exception {
        this.gameboard = new Gameboard();
    }

    @Test
    public void lengthTest() {
        gameboard.setup();
        assertTrue(gameboard.getBoardLength() == 9);
    }

    @Test
    public void wallTest() {
        gameboard.startLevel();
        assertTrue(gameboard.getBoard()[3][3] instanceof Wall);
    }

    @Test
    public void exitTest() {
        gameboard.startLevel();
        assertTrue(gameboard.getBoard()[9][9] instanceof Exit);
    }

    @Test

    public void keyTest() {
        gameboard.startLevel();
        assertTrue(gameboard.getBoard()[2][4] instanceof Key);
    }

    @Test
    public void barricadeTest() {
        gameboard.startLevel();
        assertTrue(gameboard.getBoard()[6][6] instanceof Barricade);
    }
}