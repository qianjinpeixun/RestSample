package com.qianjin.java.sss.java2s.ass2;

import java.util.Scanner;

/*
 * Include all of the work in Question2
 * 
 * a simple calculator program that takes input from the user to perform
 * addition, subtraction, multiplication, and division.
 */

public class Question2 {

    /*
     * uses the methods from parts (a) and (b) together to perform as many
     * integer arithmetic operations as the user desires, until they enter ‘q’
     * to quit.
     */
    public static void main(String[] args) {

        char c = prompt();
        // If the user enters something that does not correspond to one of the
        // five characters indicated in the prompt (‘a’, ‘s’, ‘m’, ‘d’, or ‘q’),
        // then the program should print another prompt, and continue printing
        // prompts until valid input is given
        while (c != 'q') {
            intCalculator(c);
            c = prompt();
        }
    }

    /*
     * print to output a prompt for the user, asking whether they want to
     * perform (a)ddition, (s)ubtraction, (m)ultiplication, or (d)ivision, or
     * else (q)uit the calculator
     * 
     * no parameters
     * 
     * return a character that corresponds to the first character of the String
     * given by the user as input.
     * 
     */
    public static char prompt() {
        char newString = 'a';
        // giving the appropriate prompt to user
        System.out.println("Do want to (a)dd, (s)ubtract, (m)ultiply, (d)ivide, or (q)uit?");
        // using the Scanner class to take input from the user.
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.next();
        // If it is a letter, the returned character should be lower case.
        s = s.toLowerCase();
        newString = s.charAt(0);
        return newString;
    }

    /*
     * perform integer arithmetic on a set of values given by the user.
     * 
     * take a single character as a parameter that should indicate whether
     * addition, subtraction, multiplication, or division will be performed
     * (‘a’, ‘s’, ‘m’, or ‘d’, respectively
     * 
     * no return
     */
    public static void intCalculator(char c) {
        Scanner keyboard = new Scanner(System.in);
        int result = 0;
        // print out a prompt indicating that the user should enter two integer
        // values
        System.out.print("Enter two integer values to ");

        if (c == 'a') {

            System.out.println("add:");
            int a = keyboard.nextInt();
            int b = keyboard.nextInt();
            result = a + b;

        } else if (c == 's') {
            System.out.println("subtract:");
            int a = keyboard.nextInt();
            int b = keyboard.nextInt();
            result = a - b;

        } else if (c == 'm') {
            System.out.println("multiply:");
            int a = keyboard.nextInt();
            int b = keyboard.nextInt();
            result = a * b;
        } else if (c == 'd') {
            System.out.println("divide:");
            int a = keyboard.nextInt();
            int b = keyboard.nextInt();
            result = a / b;
        }

        // print out the result of performing the indicated arithmetic operation
        // on the two values given by the user.
        System.out.println("Your result is: " + result);
    }

}
