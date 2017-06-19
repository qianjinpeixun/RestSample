package com.qianjin.java.sss.java2s.lab07;

import javax.swing.JOptionPane;

public class Exercise1 {

    public static void main(String[] args) {
        // i. Prompt the user for an integer, and print to output the next
        // largest integer
        int value0 = promptForInt("Calculate the next largest integer.");
        int value1 = value0 + 1;
        System.out.println("the next largest integer of " + value0 + " is: " + value1);

        // ii. Prompt the user for a value, and print to output the square root
        // of its absolute value
        double value2 = promptForDouble("Calculate the square root using absolute value.");
        value2 = Math.abs(value2);
        double sqr = Math.sqrt(value2);
        System.out.println("the square root of " + value2 + "'s absolute is: " + sqr);

        // iii. Prompt the user for two integers, and print to output their
        // product

        int value3 = promptForInt("First number for product.");
        int value4 = promptForInt("Scecond number for product.");
        int product = value3 * value4;
        System.out.println("the product of " + value3 + " and " + value4 + " is: " + product);

        // iv. Prompt the user for three values, and print to output their
        // average
        double value5 = promptForDouble("First number for average.");
        double value6 = promptForDouble("Second number for average.");
        double value7 = promptForDouble("Third number for average.");
        double avg = (value5 + value6 + value7) / 3;
        System.out.println("the average of " + value5 + " , " + value6 + " and " + value7 + " is: " + avg);

    }

    /*
     * This method converts the user’s input to an integer value that is then
     * returned.
     * 
     * takes a single String parameter
     * 
     * returns an integer value
     */
    public static int promptForInt(String s) {
        String message = s + "\n" + "Please enter an Integer:";
        String result = JOptionPane.showInputDialog(message);
        int value = Integer.parseInt(result);
        return value;
    }

    /*
     * takes a single String parameter
     * 
     * returns a double value
     */
    public static double promptForDouble(String s) {
        String message = s + "\n" + "Please enter a Double:";
        String result = JOptionPane.showInputDialog(message);
        double value = Double.parseDouble(result);
        return value;
    }

}
