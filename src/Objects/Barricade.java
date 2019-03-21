package Objects;


public class Barricade extends Square{
        int code;
        public Barricade(Gameboard gameboard){
                super(gameboard);
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }
}
