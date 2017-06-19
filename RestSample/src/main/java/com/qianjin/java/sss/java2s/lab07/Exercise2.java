package com.qianjin.java.sss.java2s.lab07;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        // Prompt the user for a number of kilometres, and convert this
        // into miles
        System.out.println("Please enter a number of kilometres:");
        double d1 = keyboard.nextDouble();
        double d2 = convertDistance(d1, true);
        System.out.println("There are " + d2 + " miles in " + d1 + " kilometres!");
        System.out.println();

        // prompt the user for a number of miles, which should be converted into
        // kilometres.
        System.out.println("Please enter a number of miles:");
        double d3 = keyboard.nextDouble();
        double d4 = convertDistance(d3, false);
        System.out.println("There are " + d4 + " kilometres in " + d3 + " miles!");

    }

    /*
     * converting between kilometres and miles
     * 
     * that takes a double and a Boolean parameter
     * 
     * returns a double value
     */

    public static double convertDistance(double d, boolean b) {
        double value = 0;
        // convert from kilometres into miles if the Boolean parameter is true
        if (b) {
            value = d * 0.621371;
        } else {
            value = d * 1.60934;
        }
        return value;
    }
}
