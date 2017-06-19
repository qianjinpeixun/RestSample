package com.qianjin.java.sss.java2s.a06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *
 * This class is designed to implement a postfix calculator using a Deque for a
 * stack for lab 6.
 * 
 * The postfix expressions include just numbers and operators. Allow double
 * values for the numbers.
 * 
 * 
 *
 * @author Lingda Cai (A00372181)
 * @version 1.0
 */
public class Calculator {

    static private Deque<Double> stack = new ArrayDeque<Double>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // starts by identifying this class itself and the information about the
        // student, and explaining to the user how to use the program.
        System.out.println("This program reads and evaluates postfix expressions.");
        System.out.println("Enter your expression at the >>> sign.");
        System.out.println("Enter QUIT to exit the program.");
        System.out.println("");

        System.out.print(">>> ");
        String line = scanner.nextLine();
        // Using a while loop to repeatedly prompt the user for a postfix
        // expression, and evaluate each of them until the user enters quit
        // The user enters the postfix expression at the prompt, all on one
        // line, with spaces between the numbers and operators. The program
        // reports each operation as it's carried out.
        while (!line.equalsIgnoreCase("quit")) {
            double result = 0;
            try {
                result = cal(line);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } // end try

            System.out.println("");

            System.out.print(">>> ");
            line = scanner.nextLine();

        } // end while
        scanner.close();

    }// end main

    /**
     * a postfix expressions include just numbers and operators
     * 
     * @param line
     *            the input needs to be evaluated
     * @return the result of evaluation
     * @throws Exception
     *             if the input is not a correct expression
     */

    private static double cal(String line) throws Exception {
        // empty the stack for each evaluation
        stack.clear();
        // the default value
        double ret = 0;
        // start to get the input value by user
        Scanner sc = new Scanner(line);
        // using a while loop to handle each item in this line
        while (sc.hasNext()) {
            String item = sc.next();
            // if the item is not a number, start to evaluate
            if (!isNumber(item)) {
                // check if the operation symbol is correct
                if (!isOperation(item)) {
                    throw new Exception("Error: Unknown operator: " + item);
                } else {
                    try {
                        // convert to double value
                        double d1 = stack.pop().doubleValue();
                        // convert to double value
                        double d2 = stack.pop().doubleValue();
                        // For any operator, pull the last two numbers off the
                        // stack, apply the operator,
                        double d3 = doOperation(d2, d1, item);
                        // and then push the result back onto the stack.

                        stack.push(d3);
                    } catch (java.util.NoSuchElementException e) {
                        throw new Exception("Error: not enuf numbers in that expression!");
                    } // end try
                }
            } else {
                // Push any numbers onto a stack.
                stack.push(Double.valueOf(item));
            } // end if
        } // end while

        // When getting to the end of an expression, the value of the
        // expression is the number left on the stack. (There should be
        // exactly one number left on the stack.)
        if (stack.size() > 1) {
            // if the size is more than one, trigtger an exception
            throw new Exception("Error: too many numbers in that expression!");
        } // end if
        ret = stack.pop();
        return ret;
    }// end cal

    /**
     * evaluate one operation according to the input value
     * 
     * @param d1
     *            the first number
     * @param d2
     *            the second number
     * @param operation
     *            the operation symbol for evaluation
     * @return double, the value of evaluation
     */
    private static double doOperation(double d1, double d2, String operation) {
        // default value
        double ret = 1;
        // if the operation is add or others
        if (operation.equals("+")) {
            ret = d1 + d2;
            System.out.println(d1 + " + " + d2 + " = " + ret);
            System.out.println("");
        } else if (operation.equals("-")) {
            ret = d1 - d2;
            System.out.println(d1 + " - " + d2 + " = " + ret);
            System.out.println("");
        } else if (operation.equals("*")) {
            ret = d1 * d2;
            System.out.println(d1 + " * " + d2 + " = " + ret);
            System.out.println("");
        } else if (operation.equals("/")) {
            ret = d1 / d2;
            System.out.println(d1 + " / " + d2 + " = " + ret);
            System.out.println("");
        } else if (operation.equals("%")) {
            ret = d1 % d2;
            System.out.println(d1 + " % " + d2 + " = " + ret);
            System.out.println("");
        } else if (operation.equals("^")) {
            for (int i = 0; i < d2; i++) {
                ret = ret * d1;
            }
            System.out.println(d1 + " ^ " + d2 + " = " + ret);
            System.out.println("");

        } else if (operation.equals("//")) {
            int temp = (int) (d1 / d2);
            ret = temp;
            System.out.println(d1 + " // " + d2 + " = " + ret);
            System.out.println("");
        } // end if

        return ret;
    }// end doOperation

    /**
     * check if the input is an operation symbol
     * 
     * @param value
     *            this class only support operators +, -, *, / and % the
     *            calculator also accepts the operators ^ (exponentiation) and
     *            // (integer division)
     * @return boolean if the input value is one of operation, return true,
     *         otherwise false
     */
    private static boolean isOperation(String value) {
        // default value
        boolean ret = false;
        // if the operation smybol is correct and legal
        if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/") || value.equals("%") || value.equals("^") || value.equals("//")) {
            ret = true;
        } // end if
        return ret;
    }// end isOperation

    /**
     * If the input is a number.
     * 
     * @param value
     *            the input for validation.
     * @return boolean if the input is a number, return true. otherwise return
     *         false.
     * 
     */
    private static boolean isNumber(String value) {
        boolean ret = false;
        // if the input is not a number, there will be an exception during try
        // to convert it to a double number type.
        try {
            double dd = Double.valueOf(value).doubleValue();
            ret = true;
        } catch (java.lang.NumberFormatException e) {
            ret = false;
        } // end try
        return ret;
    }// end isNumber
}
