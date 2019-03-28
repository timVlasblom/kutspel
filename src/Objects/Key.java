package Objects;


public class Key extends Square {
    int code;

    public Key(Gameboard gameboard, int x, int y) {
        super(gameboard, x, y);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
