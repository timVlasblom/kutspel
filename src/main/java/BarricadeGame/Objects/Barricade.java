package BarricadeGame.Objects;

import javax.swing.*;

public class Barricade extends Square {
    private Key key;

    public Barricade(Key key) {
        super();
        this.key = key;
    }

    public int getCode() {
        return key.getCode();
    }

    public boolean checkKey(Key avatarkey) {
        if (this.key == avatarkey) {
            return true;
        } else if (avatarkey.getCode() == 0) {
            JOptionPane.showMessageDialog(null, "You have no key!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "You have the wrong key!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
