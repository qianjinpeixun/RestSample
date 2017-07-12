package com.qianjin.java.sss.java2s.a1101.ass01;

import java.util.Scanner;
import java.util.Random;

public class GameDemo {
    public static void main(String[] args) {
        String[] songs = { "shake it off ", "satisfaction", "mr jones", "uptown funk" };
        Random rand = new Random();
        int r = rand.nextInt(songs.length);
        String secretword = songs[r];

        System.out.println("Welcome to the Guessing Game. The topic is song titles.\n");
        System.out.println("You have 6 guesses. Your puzzle has the following letters:\n");
        Game game = new Game(secretword.toLowerCase().toCharArray());
        System.out.println(game.getSecretPhrase());
        System.out.println(game.GetDisguisedPhrase() + "\n");

        int money = 0;
        int totalMoney = 0;
        String letter = "";
        char key;
        int numbers = 0;
        int currentCount = 0;
        char[] incorrectedLetters = new char[6];
        boolean quit = false;

        Scanner kb = new Scanner(System.in);

        while (!quit) {
            if (currentCount >= 6) {
                break;
            }
            money = game.spinWheel();
            System.out.println("Round " + (currentCount + 1) + ":");
            System.out.println("After spinning the wheel, you got $" + money + ".");
            System.out.print("Please guess a letter:");
            letter = kb.nextLine();
            key = letter.toLowerCase().charAt(0);
            numbers = game.guessLetter(key);
            if (numbers == 0) {
                boolean found = false;
                for (int i = 0; i < 6; i++) {
                    if (incorrectedLetters[i] == key) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Too bad – you already guessed a and there is no " + key + ".");
                } else {
                    System.out.println("There is no " + key + ".");
                    incorrectedLetters[currentCount] = key;
                    currentCount++;
                }
            } else {
                currentCount++;
                System.out.println("There is/are " + numbers + " " + key + ".\n");
                totalMoney = totalMoney + money * numbers;
            }
            System.out.println(game.GetDisguisedPhrase() + "\n");
            System.out.print("Do you know the song? (y or n):");
            letter = kb.nextLine().toLowerCase();
            if (letter.equals("n")) {
                if (currentCount >= 6) {
                    System.out.println("Too bad – wrong song! It is " + game.getSecretPhrase() + ". You lost $" + totalMoney + "! Game over.");
                    System.out.println("Play again (Y/N): ");
                    letter = kb.nextLine().toLowerCase();
                    key = letter.charAt(0);
                    if (key == 'n') {
                        quit = true;
                        System.out.println("Thanks for playing!");
                        break;
                    } else {
                        quit = false;
                        rand = new Random();
                        r = rand.nextInt(songs.length);
                        secretword = songs[r];
                        game = new Game(secretword.toLowerCase().toCharArray());
                        money = 0;
                        totalMoney = 0;
                        letter = "";
                        numbers = 0;
                        currentCount = 0;
                        incorrectedLetters = new char[6];
                        System.out.println("Welcome to the Guessing Game. The topic is song titles.\n");
                        System.out.println("You have 6 guesses. Your puzzle has the following letters:\n");
                        System.out.println(game.getSecretPhrase());
                        System.out.println(game.GetDisguisedPhrase() + "\n");
                        continue;

                    }
                }
                System.out.println("Your jackpot is " + totalMoney);
                System.out.println("You have " + (6 - currentCount) + " guesses left.\n");
            } else {
                System.out.println("What is it:");
                letter = kb.nextLine().toLowerCase();
                if (letter.equals(game.getSecretPhrase())) {
                    System.out.println("Great Guess! You win $" + totalMoney + "!");

                } else {
                    System.out.println("Too bad – wrong song! It is " + game.getSecretPhrase() + ". You lost $" + totalMoney + "! Game over.");

                }
                System.out.println("Play again (Y/N): ");
                letter = kb.nextLine().toLowerCase();
                key = letter.charAt(0);
                if (key == 'n') {
                    quit = true;
                    System.out.println("Thanks for playing!");
                } else {
                    quit = false;
                    rand = new Random();
                    r = rand.nextInt(songs.length);
                    secretword = songs[r];
                    game = new Game(secretword.toLowerCase().toCharArray());
                    money = 0;
                    totalMoney = 0;
                    letter = "";
                    numbers = 0;
                    currentCount = 0;
                    incorrectedLetters = new char[6];
                    System.out.println("Welcome to the Guessing Game. The topic is song titles.\n");
                    System.out.println("You have 6 guesses. Your puzzle has the following letters:\n");
                    System.out.println(game.getSecretPhrase());
                    System.out.println(game.GetDisguisedPhrase() + "\n");

                }
            }
        }
    }
}