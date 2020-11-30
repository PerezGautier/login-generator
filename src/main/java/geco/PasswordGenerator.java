package geco;

public class PasswordGenerator {

    /**
     * Constructeur.
     */
    public PasswordGenerator(){

    }

    /**
     * Génère et renvoie un password de longueur length.
     * @param length longueur du mdp
     * @return String
     */
    public String getRandomPassword(int length) {
        String chars = "a";
        StringBuilder pass = new StringBuilder(length);
        for (int x = 0; x < length; x++) {
            int i = (int) (Math.random() * chars.length());
            pass.append(chars.charAt(i));
        }
        return pass.toString();
    }
}
