package com.qianjin.java.sss.java2s.a1101.ass23;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Connect4Board game = new Connect4Board();

        System.out.print("Welcome to Connect 4. Please enter your names.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player 1 name: ");
        String p1 = scanner.next();
        System.out.print("Player 2 name: ");
        String p2 = scanner.next();

        int rounds = 0;
        int position = 0;

        while (true) {
            if (rounds == 0) {
                System.out.print(p1 + " - you have red chips \"R\" and go first.\n");
                System.out.print(game.toString());
                System.out.print("Please input a column# between 1 -7:");
                position = scanner.nextInt();
                position--;
                game.add(position, "R");
                System.out.print(game.toString());
                rounds++;
            }

            if (rounds == 1) {
                System.out.print(p2 + " - you have red chips \"Y\" and go first.\n");
                System.out.print(game.toString());
                System.out.print("Please input a column# between 1 -7:");
                position = scanner.nextInt();
                position--;
                game.add(position, "Y");
                System.out.print(game.toString());
                rounds++;
            }

            System.out.print("RED Please input a column# between 1 -7: ");
            position = scanner.nextInt();
            position--;
            game.add(position, "R");
            System.out.print(game.toString());
            rounds++;
            if (game.winner()) {
                System.out.print("RED – Connect 4! Congratulations " + p1 + "! You Win in " + rounds + " turns.");
            }

            System.out.print("YELLOW Please input a column# between 1 -7: ");
            position = scanner.nextInt();
            position--;
            game.add(position, "Y");
            System.out.print(game.toString());
            rounds++;
            if (game.winner()) {
                System.out.print("YELLOW – Connect 4! Congratulations " + p2 + "! You Win in " + rounds + " turns.");
            }

            System.out.print("");
            System.out.print("");
        }
    }
}
