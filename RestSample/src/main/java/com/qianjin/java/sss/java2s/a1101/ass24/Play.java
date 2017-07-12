package com.qianjin.java.sss.java2s.a1101.ass24;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Connect4Board conn = new Connect4Board();

        System.out.print("Welcome to Connect 4. Please enter your names.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player 1 name: ");
        String player1 = scanner.next();
        System.out.print("Player 2 name: ");
        String player2 = scanner.next();

        System.out.print(player1 + " - you have red chips \"R\" and go first.\n");
        System.out.println(conn.toString());
        int column = 99;
        while (!(column < 7 && column >= 0)) {
            System.out.print("Please input a column# between 1 -7:");
            column = scanner.nextInt() - 1;
        }
        conn.add(column, "R");
        System.out.println(conn.toString());

        System.out.print(player2 + " - you have red chips \"Y\" and go first.\n");
        System.out.println("");
        column = 99;
        while (!(column < 7 && column >= 0)) {
            System.out.print("Please input a column# between 1 -7:");
            column = scanner.nextInt() - 1;
        }
        conn.add(column, "Y");
        System.out.println(conn.toString());

        int count = 2;

        while (true) {

            column = 99;
            while (!(column < 7 && column >= 0)) {
                System.out.print("RED Please input a column# between 1 -7: ");
                column = scanner.nextInt() - 1;
            }
            conn.add(column, "R");
            System.out.println(conn.toString());
            count++;
            if (conn.winner()) {
                System.out.print("RED – Connect 4! Congratulations " + player1 + "! You Win in " + count + " turns.");
            }
            column = 99;
            while (!(column < 7 && column >= 0)) {
                System.out.print("YELLOW Please input a column# between 1 -7: ");
                column = scanner.nextInt() - 1;
            }
            conn.add(column, "Y");
            System.out.println(conn.toString());
            count++;
            if (conn.winner()) {
                System.out.print("YELLOW – Connect 4! Congratulations " + player2 + "! You Win in " + count + " turns.");
            }

            System.out.print("");
            System.out.print("");
        }
    }
}
