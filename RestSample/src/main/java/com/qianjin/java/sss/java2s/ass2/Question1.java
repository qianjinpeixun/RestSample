package com.qianjin.java.sss.java2s.ass2;

import java.util.Scanner;

/*
 * Include all of the work in Question1
 */

public class Question1 {

    /*
     * a main method that calls the methods from parts (b), (d), and (f)
     * 
     */
    public static void main(String[] args) {

        String s = "Nepal";
        String newS = allShifts(s);
        System.out.println("The input ‘" + s + "‘ has all of the possible shifts of characters : ");
        System.out.println(newS);

        System.out.println("");
        boolean b = checkForPalindrome();
        System.out.print(b);
        System.out.println("");

        System.out.println("");
        mirror();
    }

    /*
     * shifts a certain number of characters from the end of a String to the
     * front. take a String and an integer as parameters.
     * 
     * The String parameter is the String to be used, and the integer is the
     * number of characters to shift from the end to the beginning of the
     * String.
     * 
     * Return a String that corresponds to the parameter String after the
     * appropriate number of characters on the end have been shifted to the
     * beginning, in the same order they originally appeared
     */
    public static String shiftString(String s, int length) {
        String newString = "";
        // start to add the last part
        for (int i = (s.length() - length); i < s.length(); i++) {
            newString = newString + s.charAt(i);
        }
        // start to add the head part
        for (int i = 0; i < (s.length() - length); i++) {
            newString = newString + s.charAt(i);
        }
        return newString;
    }

    /*
     * calculates all of the possible back-to-front character shifts for a given
     * String.
     * 
     * take a single String as a parameter and return a String that represents
     * all of the possible shifts of characters (from the end to the front),
     * starting with the original String, and with each shift being represented
     * on a separate line.
     */
    public static String allShifts(String s) {
        String newString = s;
        // reuse the method in part a)
        for (int i = 1; i < s.length(); i++) {
            newString = newString + "\n" + shiftString(s, i);
        }
        return newString;
    }

    /*
     * determines whether a String value is the same backwards as forwards.
     * 
     * take one String parameter that is the String value to be checked
     * 
     * return true only if the String parameter consists of the same sequence of
     * characters back to front as it does front to back (ignoring case, in both
     * instances). Otherwise, it should return false.
     */
    public static boolean isPalindrome(String s) {
        String newString = "";
        // create a new string with the invert order
        for (int i = 0; i < s.length(); i++) {
            newString = s.charAt(i) + newString;
        }
        // using if to check
        if (newString.equalsIgnoreCase(s))
            return true;
        else
            return false;
    }

    /*
     * determines whether a String given as input by the user is a palindrome.
     * 
     * no any parameters
     * 
     * return true if the user-inputted String was a palindrome (ignoring case),
     * and false otherwise
     * 
     */
    public static boolean checkForPalindrome() {
        // use the Scanner class to take input from the user when the method is
        // called
        Scanner keyboard = new Scanner(System.in);
        // Give the user a meaningful prompt for their input
        System.out.println("Please enter the word which to be checked:");
        String s = keyboard.next();
        boolean b = isPalindrome(s);
        System.out.print("The input ‘" + s + "’ is a palindrome: ");
        return b;
    }

    /*
     * reverses the order of the characters in a String.
     * 
     * take a single String as a parameter
     * 
     * return a String that corresponds to the parameter String when written in
     * reverse order.
     */

    public static String flip(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            newString = s.charAt(i) + newString;
        }
        return newString;
    }

    /*
     * creates a palindrome from a String given as input by the user.
     * 
     * no parameters
     * 
     * return a String that is mirrored around the last letter of the input
     * 
     */
    public static String mirror() {
        String newString = "";
        // use the Scanner class to take input from the user when the method is
        // called.
        Scanner keyboard = new Scanner(System.in);
        // Give the user a meaningful prompt for their input
        System.out.println("Please enter the word which to be mirrored:");
        String s = keyboard.next();
        newString = s + flip(s);
        System.out.println("The input ‘" + s + "‘ has a mirrored around the last letter: " + newString);
        return newString;
    }

}
