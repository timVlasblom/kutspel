package Objects;

public class Barricade extends Square{
        Key key;
        public Barricade(Key key){
                super();
                this.key = key;
        }

        public Key getCode() {
                return key;
        }
}
