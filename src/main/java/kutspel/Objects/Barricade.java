package kutspel.Objects;

import javax.swing.*;

public class Barricade extends Square {
    Key key;

    public Barricade(Key key) {
        super();
        this.key = key;
    }

    public Key getCode() {
        return key;
    }

    public boolean checkKey(Key avatarkey) {
        if (this.key == avatarkey) {
            System.out.println("Goede sleutel");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Foutieve sleutel");
            return false;
        }
    }
}
