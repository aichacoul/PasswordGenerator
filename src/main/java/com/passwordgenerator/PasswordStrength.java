package com.passwordgenerator;

public class PasswordStrength {

    public String evaluate(String password) {

        int score = 0;

        if (password.length() >= 8)
            score++;

        if (password.matches(".*[A-Z].*"))
            score++;

        if (password.matches(".*[a-z].*"))
            score++;

        if (password.matches(".*\\d.*"))
            score++;

        if (password.matches(".*[!@#$%^&*].*"))
            score++;

        if (score <= 1)
            return "très faible";
        else if (score == 2)
            return "faible";
        else if (score == 3)
            return "Moyen";
        else if (score == 4)
            return "fort";
        else
            return "Très fort";

    }
}
