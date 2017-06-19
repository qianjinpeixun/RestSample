package com.qianjin.java.sss.java2s.ass4;

import java.util.Scanner;

/*
 * a program that simulates a game of tic-tac-toe.
 * 
 * 
 */
public class Question1 {

    // this static variable used to determine if the board is full
    static int count = 0;

    public static void main(String[] args) {

        System.out.println("Let's play tic-tac-toe!");
        System.out.println("");

        boolean hasWinner = false;
        // The game board is represented by three rows of three squares each.
        // by default, each grid item is set with a space
        String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };

        // printBoard(board);

        while (!hasWinner) {
            // After each player takes their turn, a representation of the game
            // board should be printed to output
            printBoard(board);
            // two players, indicated separately by “X” and “O” marks on the
            // board.
            String player = "";
            if (count % 2 == 0) {
                player = "X";
            } else
                player = "O";
            // prompt the user for inputs at each player’s turn and update the
            // game board accordingly
            doPrompt(player, board);
            // At the end of each move, check whether there is a winner
            boolean bb = hasWinner(player, board);
            if (bb) {
                printBoard(board);
                System.out.println("Player " + player + " win, exit game!");
                break;
            }

            // The program will end after the last move is made
            if (count == 9) {
                printBoard(board);
                System.out.println("No winner, exit game!");
                break;
            }
        }

    }

    /*
     * determine the winner (either X’s or O’s) given any state of the game
     * board.
     */
    public static boolean hasWinner(String player, String[][] board) {
        for (int i = 0; i < 3; i++) {
            // check each line
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }

            // check each colum line
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }

        // check diagonal line
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }

        // check another diagonal line
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }

        return false;
    }

    /*
     * prompt the user to enter a position
     */
    public static void doPrompt(String player, String[][] board) {
        boolean b = false;
        // Continue prompting the user for player input until all squares are
        // occupied with a mark
        while (!b) {
            System.out.println("Enter two valid integers representing the row and column of the move for Player " + player + " :");
            // the user to enter row and column numbers to specify where each
            // player would like to make their mark in turn.
            Scanner keyboard = new Scanner(System.in);
            int x = keyboard.nextInt();
            int y = keyboard.nextInt();
            b = place(x, y, player, board);
        }

    }

    // if the input is correct, place a flag on the board
    public static boolean place(int x, int y, String flag, String[][] board) {
        x = x - 1;
        y = y - 1;
        // Players may not make a mark on an already-used square.
        // force the use to enter valid numerical input
        if (x < 0 || x > 2)
            return false;
        if (y < 0 || y > 2)
            return false;
        if (board[x][y].equals("X") || board[x][y].equals("O"))
            return false;
        board[x][y] = flag;
        count++;
        return true;
    }

    /*
     * print out text that visually represents the board
     */
    public static void printBoard(String[][] board) {

        for (int i = 0; i < 3; i++) {
            System.out.println("-------");
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.println("-------");
        System.out.println("");
    }

}
