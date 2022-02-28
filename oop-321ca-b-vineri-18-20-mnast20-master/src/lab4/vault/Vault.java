package lab4.vault;

public class Vault {

    private static final int maxTries = 3;

    public boolean checkPassword(String password) {
        String hidden = password.substring(4, 12);

        /**
         * Am inlocuit numarul 11 cu 12, deoarece substringul hidden ar fi avut intotdeauna o lungime de 7 caractere.
         * Pentru ca lungimea stringului "POO#lab4" este egala cu 8 != 7, acel if clause ar fi returnat intotdeauna false.
         * In scopul rezolvarii problemei, am marit lungimea stringului astfel incat sa fie comparate doua stringuri de aceeasi lungime.
         */

        if (hidden.equals("POO#lab4")) {
            System.out.println("Access granted!");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Vault vault = new Vault();
        Thief Gigel = new Thief("Gigel", "Expert");
        Gigel.initializePasswords();

        for (int i = 0; i < maxTries; i++) {

            boolean isVaultCorrupted = vault.checkPassword(Gigel.getPasswords().get(i));
            if (isVaultCorrupted == true) {
                Gigel.setMoney(9999);
            } else {
                System.out.println("You have " + (3 - i) + " tries left until vault is self destroying");
                System.out.println("Access failed...");
            }
        }
    }
}