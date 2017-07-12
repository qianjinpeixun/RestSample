package com.qianjin.java.sss.java2s.a1101.ass21;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        Connect4Board connect4 = new Connect4Board();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to connect 4. Please enter your names.");
        System.out.print("Player 1 name: ");
        String p1 = keyboard.next();
        System.out.print("Player 2 name: ");
        String p2 = keyboard.next();

        int turns = 0;
        int col = 0;
        Chip chip;
        boolean added = false;
        while (true) {

            if (turns == 0) {
                System.out.println(p1 + " - you have red chips \"R\" and you go first.");
                System.out.println(connect4.toString());
                while (true) {
                    System.out.print("Please input a column# between 1-7: ");
                    col = keyboard.nextInt();
                    if (col >= 1 && col <= 7)
                        break;
                }
                chip = new Chip("Red");
                connect4.add(col - 1, "red");
                turns++;
                System.out.println(connect4.toString());
                System.out.println(p2 + " - you have yellow chips \"Y\" and you go next\n");
                while (true) {
                    System.out.print("Please input a column# between 1-7: ");
                    col = keyboard.nextInt();
                    if (col >= 1 && col <= 7)
                        break;
                }
                chip = new Chip("Yellow");
                connect4.add(col - 1, "Yellow");
                turns++;
                System.out.println(connect4.toString());
            } else {
                while (true) {
                    System.out.print("RED Please input a column# between 1-7: ");
                    col = keyboard.nextInt();
                    if (col < 1 && col > 7)
                        continue;
                    chip = new Chip("RED");
                    added = connect4.add(col - 1, "RED");
                    if (added) {
                        break;
                    }
                }
                System.out.println(connect4.toString());
                boolean win = connect4.winner();
                turns++;
                if (win) {
                    System.out.println("RED - Connect 4! Congratulations " + p1 + "! You Win in " + turns + " turns.");
                    System.out.print("Play Again? Y/N: ");
                    String answer = keyboard.next().toLowerCase();
                    if (answer.charAt(0) == 'y') {
                        connect4 = new Connect4Board();
                        turns = 0;
                        continue;
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Yellow Please input a column# between 1-7: ");
                    col = keyboard.nextInt();
                    if (col < 1 && col > 7)
                        continue;
                    chip = new Chip("Yellow");
                    added = connect4.add(col - 1, "Yellow");
                    if (added)
                        break;
                }
                System.out.println(connect4.toString());

                win = connect4.winner();
                turns++;
                if (win) {
                    System.out.println("Yellow - Connect 4! Congratulations " + p2 + "! You Win in " + turns + " turns.");

                    System.out.print("Play Again? Y/N: ");
                    String answer = keyboard.next().toLowerCase();
                    if (answer.charAt(0) == 'y') {
                        connect4 = new Connect4Board();
                        turns = 0;
                        System.out.println();
                        continue;
                    } else {
                        break;
                    }

                }
            }
        }

    }

}
