package kutspel.Objects;

import javax.swing.*;

public class Barricade extends Square {
    Key key;

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
            JOptionPane.showMessageDialog(null, "Geen sleutel");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Foutieve sleutel");
            return false;
        }
    }
}
