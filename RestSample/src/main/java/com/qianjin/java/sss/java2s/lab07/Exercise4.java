package com.qianjin.java.sss.java2s.lab07;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exercise4 {
    
    public static void main(String[] args){
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Please enter the numbers of which will be calculated the average value:");
        int value=keyboard.nextInt();
        double d=getAverage(value);
        System.out.println("the average of "+value+" numbers is:"+d);
    }

    /*
     * prompt the user for a number of double values and then return their
     * average.
     * 
     * takes a single integer as a parameter
     * 
     * returns a double value
     */
    public static double getAverage(int value) {
        double result = 0;
        for (int i = 1; i < value+1; i++) {
            String s = JOptionPane.showInputDialog("Please enter no. " + i + "'s value(double):");
            double d = Double.parseDouble(s);
            result = result + d;
        }
        return result / value;
    }
}
