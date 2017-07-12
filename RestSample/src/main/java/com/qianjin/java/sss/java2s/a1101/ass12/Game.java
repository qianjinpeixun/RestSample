package com.qianjin.java.sss.java2s.a1101.ass12;


/*
 * Assignment1, Question 1 CSCI 1101 Game.java game is Wheel of Fortune. July 6,
 * 2017 Yiping Liang B00744822 This is entirely my own work.
 */
import java.util.Random;

public class Game {

    private char[] secretPhrase;
    private char[] disguisedPhrase;
    private int count;
    private int incount;
    private int amount;

    public Game(String secret) {
        secretPhrase = secret.toCharArray();
        count = 0;
        incount = 0;
        amount = 0;
        disguisedPhrase = new char[secret.length()];
        for (int i = 0; i < disguisedPhrase.length; i++) {
            if (secretPhrase[i] == ' ')
                disguisedPhrase[i] = ' ';
            else
                disguisedPhrase[i] = '_';
        }
    }

    public char[] getSecretPhrase() {// returns the secret phrase.
        return secretPhrase;
    }

    public void setSecretPhrase(char[] secretPhrase) {
        this.secretPhrase = secretPhrase;
    }

    public String GetDisguisedPhrase() {
        return String.valueOf(disguisedPhrase);
    }

    public void setDisguisedPhrase(char[] disguisedPhrase) {
        this.disguisedPhrase = disguisedPhrase;
    }

    public int getCount() {// returns the number of guesses made.
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIncount() {
        return incount;
    }

    public void setIncount(int incount) {
        this.incount = incount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int spinWheel() {// which returns a random int of 100, 200 or 500
        Random rand = new Random();
        int value = rand.nextInt(3);
        if (value == 0)
            value = 100;
        else if (value == 1)
            value = 200;
        else
            value = 500;
        return value;
    }

    public int guessLetter(char c) {
        int numberOfTimes = 0;
        for (int i = 0; i < secretPhrase.length; i++) {
            if (secretPhrase[i] == c) {
                disguisedPhrase[i] = c;// put input to array
                numberOfTimes++;
            }
        }
        return numberOfTimes;
    }

    public void increaseJackpot(int amt) {
        this.amount = this.amount + amt;
    }

    public boolean isFound() {// returns true if the hidden phrase has been
                              // discovered.
        for (int i = 0; i < secretPhrase.length; i++) {
            if (secretPhrase[i] != disguisedPhrase[i]) {
                return false;
            }
        }
        return true;
    }

}
