package com.qianjin.java.sss.java2s.lab07;

import java.util.Scanner;

public class Exercise3 {

    /*
     * Print out both the circumference and area of the circle, using a nicely
     * formatted message that also includes the original radius value, followed
     * by the volume of a sphere having the same radius.
     * 
     */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the radius of a circle:");
        double d1 = keyboard.nextDouble();
        double d2 = circleCirc(d1);
        System.out.println("the circumference of the circle with radius " + d1 + " is: " + d2);
        double d3 = circleArea(d1);
        System.out.println("the area of the circle with radius " + d1 + " is: " + d3);
        double d4 = sphereVolume(d1);
        System.out.println("the volume of a sphere with radius " + d1 + " is: " + d4);

    }

    /*
     * calculate the circumference using the absolute value of the double
     * parameter as the circle’s radius.
     */
    public static double circleCirc(double d) {
        double pi=3.14159;
        return Math.abs(d) * 2 * pi;
    }

    /*
     * calculate the area using the absolute value of the double parameter as
     * the circle’s radius.
     */
    public static double circleArea(double d) {
        double pi=3.14159;
        return Math.abs(d) * Math.abs(d) * pi;
    }

    /*
     * calculate the volume using the absolute value of the double parameter as
     * the sphere’s radius.
     */
    public static double sphereVolume(double d) {
        double pi=3.14159;
        return Math.abs(d) * Math.abs(d) * Math.abs(d) * 4 * pi / 3;
    }
}
