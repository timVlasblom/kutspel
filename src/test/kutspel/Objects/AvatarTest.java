/*package kutspel.Objects;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class AvatarTest {
    private Avatar avatar;
    private Robot robot;

    @Before
    public void setUp() throws Exception {
        Gameboard gameboard = new Gameboard();
        this.avatar = new Avatar(gameboard);
        this.robot = new Robot();

    }

    @Test
    public void resetTest() {
        avatar.moveAvatar(4,4);
        avatar.resetColRow();
        assertTrue(avatar.getCol() == 0 || avatar.getRow() == 0);
    }

    @Test
    public void moveAvatar() {
        avatar.moveAvatar(4,4);
        assertTrue(avatar.getCol() == 4 || avatar.getRow() == 4);
    }

    @Test
    public void keyPressed() {
        avatar.moveAvatar(4,4);
        robot.keyPress(KeyEvent.VK_DOWN);
        assertTrue(avatar.getCol() == 4 || avatar.getRow() == 5);
    }

    @Test
    public void checkFinish(){
        avatar.moveAvatar(9,9);
        avatar.checkFinish();
        assertTrue(avatar.getCol() == 0 || avatar.getRow() == 0);

    }
}*/