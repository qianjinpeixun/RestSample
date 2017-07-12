package com.qianjin.java.sss.java2s.a1101.ass22;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Connect4Board board = new Connect4Board();
        String red = "R";
        String yellow = "Y";
        String name1 = "";
        String name2 = "";
        boolean b = false;
        int col = 0;
        int turns = 0;
        boolean play = true;
        String p = "";
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to Connect 4. Please enter your names.");
        System.out.print("Player 1 name: ");
        name1 = kb.next();
        System.out.print("Player 2 name: ");
        name2 = kb.next();

        while (play) {
            if (turns == 0) {
                System.out.println(name1 + " - you have red chips \"" + red + "\" and go first.\n\n");
                System.out.println(board.toString());
                System.out.print("Please input a column# between 1 -7: ");
            } else {
                System.out.print("RED Please input a column# between 1 -7: ");
            }

            col = kb.nextInt();
            b = board.add(col, red);
            turns++;
            System.out.println(board.toString());
            b=board.winner();
            if(b){
                System.out.println("RED – Connect 4! Congratulations "+name1+"! You Win in "+turns+" turns.");
                System.out.print("Play Again? Y/N: ");
                p = kb.next();
                if (p.toLowerCase().equals("y")) {
                    turns=0;
                    board = new Connect4Board();
                    continue;
                } else {
                    play = false;
                    continue;
                }
            }
            
            if (turns == 1) {
                System.out.println(name2+" - you have yellow chips \"" + yellow + "\" and you go next.\n\n");
                System.out.print("Please input a column# between 1 -7: ");
            } else {
                System.out.print("YELLOW Please input a column# between 1 -7: ");
            }

            col = kb.nextInt();
            b = board.add(col, yellow);
            turns++;
            System.out.println(board.toString());
            b=board.winner();
            if(b){
                System.out.println("YELLOW – Connect 4! Congratulations "+name1+"! You Win in "+turns+" turns.");
                System.out.print("Play Again? Y/N: ");
                p = kb.next();
                if (p.toLowerCase().equals("y")) {
                    turns=0;
                    board = new Connect4Board();
                    continue;

                } else {
                    play = false;
                    continue;
                }
            }
            
            
        }
    }
}
