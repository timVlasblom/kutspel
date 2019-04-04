package kutspel.Objects;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

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
        assertTrue(gameboard.boardLength == 9);
    }

    @Test
    public void wallTest(){
        gameboard.startLevel();
        assertTrue(gameboard.board[3][3] instanceof Wall);
    }
}