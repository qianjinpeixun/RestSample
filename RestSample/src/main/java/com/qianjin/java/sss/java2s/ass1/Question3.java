package com.qianjin.java.sss.java2s.ass1;

/*
 * Include all of the following work in Question 3
 */
public class Question3 {

    // the main method that calls the interval printing method from part (c).
    public static void main(String[] args) {
        print(1, 15);
        System.out.println();
        print(15, 25);
        System.out.println();
        print(25, 35);
        System.out.println();
    }

    // determines if a given integer number is a square
    // that is, if the number is equal to x*x for some other x. Some examples of
    // square numbers are 4, 9, and 49, since these are equal to 2*2, 3*3, and
    // 7*7, respectively.
    public static boolean isSquare(int value) {
        for (int i = 1; i <= value; i++) {
            if (value == (i * i))
                return true;
        }
        return false;
    }

    // determines if a given integer number is a cube,
    // that is, if the number is equal to x*x*x for some other x. Some examples
    // of cube numbers are 8, 125, and 216, since these are equal to 2*2*2,
    // 5*5*5, and 6*6*6, respectively.
    public static boolean isCube(int value) {
        for (int i = 1; i <= value; i++) {
            if (value == (i * i * i))
                return true;
        }
        return false;
    }

    // a method that loops over a given interval and prints out all numbers that
    // are not squares or cubes within the interval, including its end points
    public static void print(int lower, int upper) {
        for (int i = lower; i <= upper; i++) {
            boolean b1 = isSquare(i);
            boolean b2 = isCube(i);
            // all values should be printed on the same line, and all values
            // should be separated by spaces
            if (b1 == false && b2 == false) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println();

    }
}
