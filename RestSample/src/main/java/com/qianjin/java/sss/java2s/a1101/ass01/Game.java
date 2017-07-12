package com.qianjin.java.sss.java2s.a1101.ass01;

import java.util.Random;

public class Game {
    private char[] secret;
    private char[] disguised;
    private int amount;
    private int guessMade;
    private int inguess;

    public Game(char[] secret) {
        this.secret = secret;
        disguised = new char[secret.length];
        for (int i = 0; i < secret.length; i++) {
            if (secret[i] == ' ') {
                disguised[i] = ' ';
            } else {
                disguised[i] = '_';
            }
        }
        amount = 0;
        guessMade = 0;
        inguess = 0;
    }

    public int spinWheel() {
        Random rand = new Random();
        int i = rand.nextInt(3);
        if (i == 0) {
            return 200;
        } else if (i == 1) {
            return 500;
        } else
            return 1000;

    }

    public int guessLetter(char c) {
        guessMade++;
        int count = 0;
        for (int i = 0; i < secret.length; i++) {
            if (secret[i] == c) {
                count++;
                disguised[i] = c;
            }
        }
        if (count == 0) {
            inguess++;
        }
        return count;
    }

    public String GetDisguisedPhrase() {
        return String.valueOf(disguised).toUpperCase();
    }

    public String getSecretPhrase() {
        return String.valueOf(secret);
    }

    public int increaseJackpot(int amt) {
        amount = amount + amt;
        return amount;
    }

    public int getGuessCount() {
        return guessMade;
    }

    public boolean isFound() {

        String s = String.valueOf(secret);
        String d = String.valueOf(disguised);
        if (s.equals(d)) {
            return true;
        } else {
            return false;
        }
    }
}
