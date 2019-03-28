package Objects;


public class Key extends Square {
    int code;

    public Key(int x, int y) {
        super(x, y);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
