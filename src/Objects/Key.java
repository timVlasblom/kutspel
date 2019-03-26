package Objects;


public class Key extends Square {
    int code;

    public Key(Gameboard gameboard) {
        super(gameboard);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
