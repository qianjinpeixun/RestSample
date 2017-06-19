package com.qianjin.java.sss.java2s.ass3;

import java.util.Scanner;

/*
 * Include all of the work in BonusQuestion
 */
public class BonusQuestion {

    /*
     * prompts the user for six names and collects these in an array of Strings
     * 
     */
    public static void main(String[] args) {

        String input = "";
        Scanner keyboard = new Scanner(System.in);
        String[] names = { "", "", "", "", "", "", "" };
        for (int i = 1; i < 7; i++) {
            System.out.println("Please enter number " + i + "'s name:");
            input = keyboard.nextLine();
            names[i - 1] = grabFirstToken(input);
        }
        input = shuffleNames(names);
        System.out.println("After shuffle, the result is:");
        System.out.println(input);

    }

    /*
     * takes a single String parameter
     * 
     * returns a String value that is equivalent to a substring of the String
     * parameter up to the first whitespace character (either space, tab, or
     * newline).
     * 
     */

    public static String grabFirstToken(String s) {
        String newS = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
                break;
            }
            newS = newS + c;
        }
        return newS;
    }

    /*
     * treat the Strings given by the parameter array as names, and re-combine
     * them so that they will print out with each name in a different column
     * instead of on a different line. The names appear in the same order,
     * left-to-right, as the order they are given in the parameter are takes an
     * array of Strings as a parameter
     * 
     * returns a String value.
     */

    public static String shuffleNames(String[] s) {
        String newS = "";
        // find the largest length
        int max = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > max) {
                max = s[i].length();
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() > i) {
                    newS = newS + s[j].charAt(i);
                } else {
                    newS = newS + " ";
                }
            }
            newS = newS + "\n";
        }
        return newS;
    }
}
