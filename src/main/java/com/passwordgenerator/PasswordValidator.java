package com.passwordgenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PasswordValidator {

    public int getScore(String password){

        try{

            // Exécution de Zxcvbn dans un conteneur Docker pour évaluer la robustesse
            String command = "const zxcvbn=require('/app/node_modules/zxcvbn'); console.log(zxcvbn('" + password + "').score)";
            ProcessBuilder pb = new ProcessBuilder(
                    "docker",
                    "exec",
                    "zxcvbn-container",
                    "node",
                    "-e",
                    command
            );
            pb.redirectErrorStream(true);

            Process Process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(Process.getInputStream()));
            String result = reader.readLine();

            Process.waitFor();
            System.out.println("réponse docker :" + result);

            if (result == null){
                return -1;
            }
            // Récupération du score retourné par le conteneur
            return Integer.parseInt(result.trim());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
