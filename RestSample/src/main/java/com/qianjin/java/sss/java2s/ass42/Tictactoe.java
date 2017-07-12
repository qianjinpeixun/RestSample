package com.qianjin.java.sss.java2s.ass42;


import java.util.Scanner;

public class Tictactoe {

    private static String[][] grid = { { "-", "-", "-", "-", "-", "-", "-" }, { "|", " ", "|", " ", "|", " ", "|" }, { "-", "-", "-", "-", "-", "-", "-" },
            { "|", " ", "|", " ", "|", " ", "|" }, { "-", "-", "-", "-", "-", "-", "-" }, { "|", " ", "|", " ", "|", " ", "|" }, { "-", "-", "-", "-", "-", "-", "-" } };

    public static void main(String[] args) {
        System.out.println("Let's play tic-tac-toe!");
        int count = 0;
        while (!checkWinner()) {
            if (isFull()) {
                System.out.println("game over!");
                break;
            }
            if (count % 2 == 0) {
                move("X", "Enter two valid integer representing the row and column of the move for Player X");
                count++;
            } else {
                move("O", "Enter two valid integer representing the row and column of the move for Player O");
                count++;
            }
            
        }

        // print winner
        if (checkWinner()) {
            if (count % 2 == 1) {
                showFrid();
                System.out.println("Congratulations! Play X is the winner!");

            } else {
                showFrid();
                System.out.println("Congratulations! Play O is the winner!");

            }
        }
    }

    public static void showFrid() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

    }

    public static boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (grid[(i * 2) + 1][(j * 2) + 1].equals(" "))
                    return false;
            }
        return true;
    }

    public static boolean checkWinner() {

        if (!grid[1][1].equals(" ") && grid[1][1].equals(grid[1][3]) && grid[1][1].equals(grid[1][5]))
            return true;
        if (!grid[3][1].equals(" ") && grid[3][1].equals(grid[3][3]) && grid[3][1].equals(grid[3][5]))
            return true;
        if (!grid[5][1].equals(" ") && grid[5][1].equals(grid[5][3]) && grid[5][1].equals(grid[5][5]))
            return true;

        if (!grid[1][1].equals(" ") && grid[1][1].equals(grid[3][1]) && grid[1][1].equals(grid[5][1]))
            return true;
        if (!grid[1][3].equals(" ") && grid[1][3].equals(grid[3][3]) && grid[1][3].equals(grid[5][3]))
            return true;
        if (!grid[1][5].equals(" ") && grid[1][5].equals(grid[3][5]) && grid[1][5].equals(grid[5][5]))
            return true;

        if (!grid[1][1].equals(" ") && grid[1][1].equals(grid[3][3]) && grid[1][1].equals(grid[5][5]))
            return true;

        if (!grid[1][5].equals(" ") && grid[1][5].equals(grid[3][3]) && grid[1][5].equals(grid[5][1]))
            return true;

        return false;
    }

    public static void move(String string, String message) {
        Scanner kb = new Scanner(System.in);
        // System.out.println("Please enter the row and column you want to put
        // :");
        showFrid();
        boolean judge = false;
        while (!judge) {
            System.out.println(message);
            int row = kb.nextInt();
            int column = kb.nextInt();
            if (row < 1 || row > 3 || column < 0 || column > 3) {
                judge = false;
            } else {
                if (grid[(row - 1) * 2 + 1][(column * 2) - 1].equals(" ")) {
                    grid[(row - 1) * 2 + 1][(column * 2) - 1] = string;
                    judge = true;
                }
            }

        }

    }

}
