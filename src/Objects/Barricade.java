package Objects;


public class Barricade extends Square{
        int code;
        public Barricade(Gameboard gameboard, int x, int y){
                super(gameboard, x, y);
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }
}
