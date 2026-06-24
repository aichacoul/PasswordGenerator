package com.passwordgenerator;


import java.security.SecureRandom;

public class PasswordGenerator {


    // Génère un mot de passe aléatoire selon les options choisies par l'utilisateur
    private static final SecureRandom random = new SecureRandom();

    // génère un mot de passe de longueur donnée
    public  String géneratePassword(PasswordOptions options) {

        String characters = "";
        if (options.uppercase) {
           characters += "ABCDEFGHIJKLMNOPKRSTUVWXYZ";
        }
        if (options.lowercase) {
            characters += "abcdefghijklmnopqrstuvwxyz";
        }
        if (options.digits) {
            characters += "0123456789";
        }
        if (options.symbols) {
            characters += "!@#$%^&*";
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));

        }
        return password.toString();
    }
}
