package com.qianjin.java.sss.java2s.a01;

import javax.swing.plaf.synth.SynthSeparatorUI;

/*
 * Include all of the following work in Question 2
 */
public class Question2 {

    // a main method that calls each of the custom methods
    public static void main(String[] args) {

        // print first style square having size 6
        printSquare(5);
        System.out.println();

        // print second style square having size 6
        printSquare2(6);
        System.out.println();

        // print a rectangle that has height 9 and length 5.
        printRectangle(5, 9);
        System.out.println();
        
        //call each method two more times with parameters
        printSquare(6);
        System.out.println();
        printSquare(7);
        System.out.println();
        printSquare(8);
        System.out.println();

        printSquare2(7);
        System.out.println();
        printSquare2(8);
        System.out.println();
        printSquare2(9);
        System.out.println();

        printRectangle(6, 9);
        System.out.println();
        printRectangle(7, 9);
        System.out.println();
        printRectangle(8, 9);
        System.out.println();
        printRectangle(9, 10);
        System.out.println();
        printRectangle(9, 11);
        System.out.println();
        printRectangle(9, 12);

    }

    // a method that will print a square made up of * (asterisk) symbols. The
    // square should be hollow inside (so made up of spaces), except for an
    // interior diagonal line that connects the top-left corner of the square to
    // the bottom-right corner of the square.
    public static void printSquare(int value) {
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                // the first and last line, print with *
                // the first and last column, print with *
                // if i==j,means the point is in the line from the top-left
                // corner of the square to the bottom-right corner of the
                // square, then print with * as well
                // otherwise, print with space
                if (i == 0 || i == (value - 1) || j == 0 || j == (value - 1) || i == j || i == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // print a rectangle made up of * (asterisk) symbols
    public static void printRectangle(int height, int length) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                // If the rectangle�s height is both odd and greater than 2,
                // then the middle row should be filled with spaces instead of *
                // symbols
                // the first and last column should be filled with *
                if (height > 2 && (height % 2 == 1) && i == ((height / 2)) && j != 0 && j != (length - 1)) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    // This square should be filled in with * symbols, except for an interior
    // diagonal line that connects the top-right corner to the bottom-left
    // corner
    public static void printSquare2(int value) {

        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                if (j == (value - 1 - i) && j != 0 && j != (value - 1)) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }

    }

}
