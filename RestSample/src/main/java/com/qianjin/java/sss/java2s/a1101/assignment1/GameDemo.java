package com.qianjin.java.sss.java2s.a1101.assignment1;

import java.util.Scanner;
import java.util.Random;

public class GameDemo {

    public static void main(String[] args) {

        String[] songs = { "Despacito", "Wild Thoughts", "Shape Of You", "Believer", "Humble", "Mask Off", "Stay", "Body Like A Back Road", "Redbone", "Issues", "slow hands" };
        Random rand = new Random();
        int randValue = rand.nextInt(songs.length);
        String secret = songs[randValue].toLowerCase();
        System.out.println(secret);
        Game game = new Game(secret);
        Scanner keyboard = new Scanner(System.in);
        int limit = 6;
        int times = 0;
        char[] correctLetters = new char[100];
        char[] inCorrectLetters = new char[100];
        int jackPot = 0;
        int totalJackPot = 0;
        int spinWheel = 0;
        String input = "";
        char inputChar;
        int numbersOfChar = 0;

        while (true) {
            if (times == 0) {
                System.out.println("Welcome to the Guessing Game. The topic is song titles.");
                System.out.println("");
                System.out.println("You have 6 guesses. Your puzzle has the following letters:");
                System.out.println("");
                System.out.println(game.getDisguisedPhrase());
                System.out.println("");
            }
            System.out.println("Round " + (times + 1) + ":");
            spinWheel = game.spinWheel();
            System.out.println("After sprinning the wheel, you got $" + spinWheel + ".");
            System.out.print("Please guess a letter: ");
            inputChar = keyboard.next().charAt(0);
            numbersOfChar = game.guessLetter(inputChar);

            if (times <= limit) {
                if (numbersOfChar > 0) {
                    times++;
                    jackPot = numbersOfChar * spinWheel;
                    totalJackPot = totalJackPot + jackPot;
                    System.out.println("There is/are " + numbersOfChar + " " + inputChar);
                } else {
                    boolean used = false;
                    for (int j = 0; j < inCorrectLetters.length; j++) {
                        if (inCorrectLetters[j] == inputChar) {
                            used = true;
                            break;
                        }
                    }
                    if (used) {
                        System.out.println("Too bad - you already guessed a and there is no " + inputChar);
                    } else {
                        System.out.println("There is no " + inputChar);
                        inCorrectLetters[times] = inputChar;
                        times++;
                    }
                }
                System.out.println("");
                System.out.println(game.getDisguisedPhrase());
                System.out.println("");
            }
            System.out.println("Do you know the song? (y or n):");
            inputChar = keyboard.next().toLowerCase().charAt(0);
            if (inputChar == 'n') {
                if (times == limit) {
                    System.out.println("Too bad - wrong song! It is " + String.valueOf(game.getSecretPhrase()) + " . You lost $" + totalJackPot + "! Game over.");
                    break;
                } else {
                    System.out.println("Your jackpot is $" + totalJackPot);
                    System.out.println("You have " + (limit - times) + " guesses left.");
                }
            } else {
                System.out.print("What is it: ");
                // input = keyboard.next().toLowerCase();
                input = keyboard.next().toLowerCase();
                System.out.println("");
                if (input.toLowerCase().equals(secret.toLowerCase())) {
                    System.out.println("Great Guess! you win $" + totalJackPot + "!");
                } else {
                    System.out.println("Too bad - wrong song! It is " + String.valueOf(game.getSecretPhrase()) + " . You lost $" + totalJackPot + "! Game over.");
                }
                System.out.println("");
                System.out.println("Play again (Y/N) ");
                inputChar = keyboard.next().toLowerCase().charAt(0);
                if (inputChar == 'y') {
                    times = 0;
                    totalJackPot = 0;
                    continue;
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
            System.out.println("");

        }
    }
}
