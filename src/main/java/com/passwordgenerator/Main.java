package com.passwordgenerator;

import javax.swing.text.html.Option;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PasswordOptions options = new PasswordOptions();

        System.out.println("==== password generator ====");
        System.out.println(" longueur du mot de passe : ");

        // Configuration des options de génération selon les choix utilisateur
        options.length = scanner.nextInt();

        System.out.println("inclure des majuscules ? (true/false) : ");
        options.uppercase = scanner.nextBoolean();

        System.out.println("inclure des minuscules ? (true/false) : ");
        options.lowercase = scanner.nextBoolean();

        System.out.println("inclure des chiffres ? (true/false) : ");
        options.digits = scanner.nextBoolean();

        System.out.println("inclure des symboles ? (true/false) : ");
        options.symbols = scanner.nextBoolean();

        System.out.print("Combien de mots de passe voulez-vous générer ? ");
        options.quantity = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator();
        PasswordValidator validator = new PasswordValidator();
        System.out.println("\n==== password generator ====");

        // Application CLI de génération de mots de passe sécurisés
        for (int i = 1; i <= options.quantity; i++) {

            String password = generator.géneratePassword(options);

            //  Utilise un mode rafale et une analyse via Docker + Zxcvbn
            int score = validator.getScore(password);
            String level;

            switch (score) {

                case 0:
                    level = "très faible";
                    break;
                case 1:
                    level = " faible";
                    break;
                case 2:
                    level = "Moyen";
                    break;
                case 3:
                    level = "fort";
                    break;
                case 4:
                    level = "très fort";
                    break;
                default:
                    level = "Erreur";
            }

            System.out.println("Mot de passe " + i +" : " + password);
            System.out.println("score zxcvbn : " + score);
            System.out.println("Niveau : " + level);
            System.out.println();
        }
    }
}
