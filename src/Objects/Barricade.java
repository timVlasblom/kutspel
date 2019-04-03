package Objects;

public class Barricade extends Square{
        Key key;
        Gameboard gameboard;

        public Barricade(Key key){
                super();
                this.key = key;
        }

        public Key getCode() {
                return key;
        }

        public boolean checkKey(){
                Key avatarkey = gameboard.getAvatarKey();
                if(this.key == avatarkey){
                        System.out.println("Goede sleutel");
                        return true;
                }
                else{
                        System.out.println("Foute sleutel");
                        return false;
                }
        }
}
