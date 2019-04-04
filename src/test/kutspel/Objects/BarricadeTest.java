package kutspel.Objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarricadeTest {
    private Gameboard gameboard;
    private Key key;
    private Key key2;
    private Barricade barricade;

    @Before
    public void setUp() throws Exception {
        this.gameboard = new Gameboard();
        Key key100 = new Key(100);
        this.key = key100;
        this.key2 = new Key(50);
        this.barricade = new Barricade(key100);
    }

    @Test
    public void checkKey() {
        assertTrue(barricade.checkKey(key));
        assertFalse(barricade.checkKey(key2));
    }
}