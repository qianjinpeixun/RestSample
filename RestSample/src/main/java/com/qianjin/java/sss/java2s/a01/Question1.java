package com.qianjin.java.sss.java2s.a01;

/*
 * Include all of the following work in Question1
 */
public class Question1 {

    // a main method that calls each of the custom methods
    public static void main(String[] args) {

        boolean b1 = isInInterval(12.5, 0, 20);
        System.out.println(b1);
        System.out.println();
        boolean b2 = isInInterval(12.5, 19, 20);
        System.out.println(b2);
        System.out.println();
        // call the method from part (b), using the parameters (in order): 9,
        // true
        printAlternates(9, true);
        System.out.println();
        printAlternates(10, false);

    }

    // determines whether a double value is in the interval defined by two
    // integer values.
    public static boolean isInInterval(double value, int lower, int upper) {
        // return true only if the double value is both greater than (or equal
        // to) the lower end of the interval and less than (or equal to) the
        // upper end of the interval. Otherwise, it should return false.

        if (value >= lower && value <= upper)
            return true;
        else
            return false;
    }

    // print all of the odd values or all of the even values.
    // a boolean value that determines whether your method will print off all
    // the even integers (starting at 0), or all the odd integers (starting at
    // 1).
    public static void printAlternates(int value, boolean isEven) {
        for (int i = 0; i <= value; i++) {
            // If the Boolean parameter is true, then print off all the even
            // integers (starting at 0);
            if (isEven == true) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            } else {
                if (i % 2 == 1) {
                    System.out.println(i);
                }
            }
        }
    }

}
