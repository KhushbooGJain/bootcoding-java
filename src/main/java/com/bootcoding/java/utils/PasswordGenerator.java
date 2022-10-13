package com.bootcoding.java.utils;

import java.util.Random;

public class PasswordGenerator {

    public static String getRandomPassword(){
        String alphabates = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabates = alphabates.toLowerCase();
        String digits = "0123456789";
        String alphaNumeric = alphabates + lowerAlphabates + digits; //

        int passwordLength = 8;
        Random random = new Random();
        String password = "";
        for(int i = 1; i <= passwordLength; i++){
            char ch = alphaNumeric.charAt(random.nextInt(alphaNumeric.length()));
            password = password + ch;
        }

        return password;

    }

}
