package com.qianjin.java.sss.java2s.ass3;

import java.util.Scanner;

/*
 * Include all of the work in Question1
 */

public class Question1 {

    /*
     * takes a character array and a character value as parameters
     * 
     * returns a boolean.returning true if the character value exists, and false
     * otherwise.
     * 
     * This method determines whether the parameter character value exists
     * within the parameter array.
     */
    public static boolean arrayContains(char[] arrays, char c) {
        boolean isCorrect = false;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == c) {
                isCorrect = true;
                break;
            }
        }
        return isCorrect;
    }

    /*
     * takes a character array and a String as parameters.The parameter
     * character array represents a set of valid character values, and the
     * parameter String represents a prompt.
     * 
     * returns a character.
     * 
     * This method prints to output the prompt for the user, then use the
     * Scanner class to take input from the user. Consider only the first
     * character of the user’s input, and convert it to lower case. If the
     * entered character is not within the array of valid character values, then
     * continue prompting; otherwise, return the (valid, converted to lowercase)
     * character entered by the user.
     * 
     */
    public static char doPrompt(char[] arrays, String s) {
        char valided = 'a';
        Scanner keyboard = new Scanner(System.in);
        boolean found = true;
        while (found) {
            System.out.println(s);
            found = false;
            char input = keyboard.next().toLowerCase().charAt(0);
            found=arrayContains(arrays,input);
            if (found) {
                valided = input;
                break;
            } else {
                found = true;
            }
        }

        return valided;
    }

    /*
     * 
     * takes a single character parameter which represents the arithmetic
     * operation that will be performed.
     * 
     * has no return value.
     * 
     * This method will perform floating point (double) arithmetic on a set of
     * values given by the user, either addition, subtraction, multiplication,
     * or division depending on whether the parameter character is ‘a’, ‘s’,
     * ‘m’, or ‘d’, respectively. CSCI 1100 Assignment 3, page 2
     * 
     * All other character values will be ignored, and the resulting value will
     * 0.0..
     * 
     * This method print out a prompt indicating that the user should enter two
     * double values, then use the Scanner class to collect both values, and
     * finally perform the appropriate arithmetic operation.
     * 
     * This method do not return any value, but prints out the result of
     * performing the indicated arithmetic operation on the two values given by
     * the user, with an appropriate message.
     * 
     */

    public static void arithCalculator(char c) {
        Scanner keyboard = new Scanner(System.in);
        double d1 = 0.0;

        double d2 = 0.0;

        double result = 0.0;
        if (c == 'a') {
            System.out.println("Enter two double values to add:");
            d2 = keyboard.nextDouble();
            d1 = keyboard.nextDouble();
            result = d1 + d2;
        } else if (c == 's') {
            System.out.println("Enter two double values to subtract:");
            d1 = keyboard.nextDouble();
            d2 = keyboard.nextDouble();
            result = d1 - d2;
        } else if (c == 'm') {
            System.out.println("Enter two double values to multiplfy:");
            d1 = keyboard.nextDouble();
            d2 = keyboard.nextDouble();
            result = d1 * d2;
        } else if (c == 'd') {
            System.out.println("Enter two double values to divide:");
            d1 = keyboard.nextDouble();
            d2 = keyboard.nextDouble();
            result = d1 / d2;
        }
        System.out.println("Your result is: " + result);

    }

    /*
     * takes a single character parameter which represents the trigonometric
     * operation that will be performed.
     * 
     * has no return value.
     * 
     * This method uses the Math class to calculate one of the basic trig
     * functions based on a single double value given by the user, either sin,
     * cos, or tan depending on whether the parameter character is ‘s’, ‘c’, or
     * ‘t’, respectively.
     * 
     * All other character values will be ignored, and the resulting value will
     * 0.0..
     * 
     * This method should print out a prompt indicating that the user should
     * enter one double value, then use the Scanner class to collect the value,
     * and finally perform the appropriate trigonometric operation.
     * 
     * This method do not return any value, but prints out the result of
     * performing the indicated trigonometric operation on the single value
     * given by the user, with an appropriate message.
     */

    public static void trigCalculator(char c) {
        System.out.println("Enter one double value for your trig function:");
        Scanner keyboard = new Scanner(System.in);
        double d1 = keyboard.nextDouble();
        double result = 0.0;
        if (c == 's') {
            result = Math.sin(d1);
        } else if (c == 'c') {
            result = Math.cos(d1);
        } else if (c == 't') {
            result = Math.tan(d1);
        }
        System.out.println("Your result is:"+result);

    }

    /*
     * This main method uses the methods from parts (b), (c), and (d) together
     * to perform as many operations as the user desires, until they enter ‘q’
     * to quit.
     * 
     * The user should first be prompted by a “main menu” to choose between
     * (a)rithmetic, (t)rigonometry, or (q)uitting the program.
     * 
     * If the user enters something that does not begin with one of these three
     * valid characters, then they are continually prompted until they give
     * valid input.
     * 
     * If they choose arithmetic, then the user should be prompted to choose
     * between addition, subtraction, multiplication, or division. If the user’s
     * inputted choice is not valid, then continue prompting until it is. Two
     * double values are then read from the user’s input using the Scanner
     * class, the indicated operation is performed, and the result printed to
     * output. The user is then returned to the main menu selection.
     * 
     * If instead the user chooses trigonometry, then they should be prompted to
     * choose between performing the sin, cos, or tan operation. If the user’s
     * inputted choice is not valid, then continue prompting until it is. One
     * double value is then read from the user’s input, the operation is
     * performed, and the result printed to output. The user is then returned to
     * the main menu selection.
     * 
     */

    public static void main(String[] args) {

        System.out.println("Do you want to perform (a)rithmetic, (t)rigonometry, or (q)uit?");
        Scanner keyboard = new Scanner(System.in);

        char[] arit = { 'a', 'r', 'i', 't', 'h', 'm', 'e', 't', 'i', 'c' };
        char[] trig = { 't', 'r', 'i', 'g', 'o', 'n', 'o', 'm', 'e', 't', 'r', 'y' };
        char[] quit = { 'q', 'u', 'i', 't' };
        char[] operations = { 'a', 's', 'm', 'd' };
        char[] operations_sin={'s','c','t'};

        // start to loop
        while (true) {
            String input = keyboard.next();
            int len = input.length();
            char[] inputChar = new char[input.length()];
            // convert the input to char array
            for (int i = 0; i < input.length(); i++) {
                inputChar[i] = input.charAt(i);
            }
            // determine what's the input
            boolean found = true;
            for (int i = 0; i < len; i++) {
                if (inputChar[i] != arit[i]) {
                    found = false;
                    break;
                }
            }
            if (found == true) {
                char c1 = doPrompt(operations, "Do want to (a)dd, (s)ubtract, (m)ultiply, or (d)ivide?");
                arithCalculator(c1);
            } else {
                found = true;
                for (int i = 0; i < len; i++) {
                    if (inputChar[i] != trig[i]) {
                        found = false;
                        break;
                    }
                }
                if (found == true) {
                    char c1 = doPrompt(operations_sin, "Do you want to compute (s)in, (c)os, or (t)an?");
                    trigCalculator(c1);
                } else {
                    found = true;
                    for (int i = 0; i < len; i++) {
                        if (inputChar[i] != quit[i]) {
                            found = false;
                            break;
                        }
                    }
                    if (found == true) {
                        break;
                    }
                }
            }
            System.out.println("Do you want to perform (a)rithmetic, (t)rigonometry, or (q)uit?");

        }

    }
}
