package com.qianjin.java.sss.java2s.a07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * This class is designed to as a tool for selecting area with one colour in
 * photo such as magic wand tool.
 * 
 * This class uses the IntImage and private IntPair classes from the WireRouting
 * program. One modification of IntImage class is it's print method. added a
 * space after each integer output.
 * 
 * The common methods include <code>
 * labelAndAddNeighbours neighbours readLocation readImage readPositiveNumber
 * pause </code> are from the WireRouting program as well.
 * 
 * @author Lingda Cai (A00372181)
 * @version 1.0
 */
public class ComponentLabeler {

    private static final Scanner KBD = new Scanner(System.in);
    private static boolean tracing = false;

    public static void main(String[] args) {
        // create variables
        IntImage matrix;

        // introduce yourself
        printIntroduction();

        // read image
        matrix = readImage();

        // Scan thru matrix looking for unlabeled cells and handle those cells
        handleImage(matrix);

        // show the revised image
        System.out.println("Here is the revised image:");
        matrix.print();
        pause();
    }// end main

    /**
     * Start from (0,0) to the right-bottom corner, find those cells with value
     * of 1 and replace it's value with increment value
     * 
     * @param matrix
     *            the input matrix which includes only 0 or 1 cell
     */
    private static void handleImage(IntImage matrix) {
        // the default value is set to 2
        int currentValue = 2;
        // find if there is any one cell with value of 1
        IntPair found = getNextUnlabeledPoint(matrix);
        while (found != null) {
            // if found, start to handle it using a queue
            labelImage(matrix, found, currentValue);
            // increment value
            currentValue = currentValue + 1;
            // continue to find
            found = getNextUnlabeledPoint(matrix);
        } // end while

    }// end handleImage

    /**
     * This method is designed to check if there is any items needs to be
     * handled
     * 
     * @param matrix
     *            try to scan the matrix to found if there is unlabeled point
     * @return IntPair if a point which value is 1,1, return this point,
     *         otherwise return null
     */
    private static IntPair getNextUnlabeledPoint(IntImage matrix) {
        // default value is true
        IntPair foundPoint = null;
        boolean found = false;
        // in a loop, check if any point which value is set to 1,1
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                if (matrix.get(i, j) == 1) {
                    found = true;
                    foundPoint = new IntPair(i, j);
                    break;
                }
            } // end for
            if (found == true) {
                break;
            }
        } // end for
        return foundPoint;
    }// end getNextUnlabeledPoint

    /**
     * uses a queue to label cells
     * 
     * @param matrix
     *            the input matrix which will been handled
     * @param point
     *            the start point
     * @param currentValue
     *            what's the value will be set
     */
    private static void labelImage(IntImage matrix, IntPair point, int currentValue) {
        // create queue and put start location into it
        QueueInterface<IntPair> q = new ListQueue<>();
        // set a value with increment
        matrix.set(point.row, point.col, currentValue);
        // put cell on a queue
        q.add(point);

        // while there are still places to look
        while (!q.isEmpty()) {
            // print a trace if required
            if (tracing) {
                System.out.println("\nTracing distance labelling:");
                System.out.println("Queue = " + q);
                matrix.print();
                pause();
            }
            // find and label the neighbours of the first position in the queue
            labelAndAddNeighbours(q, matrix, currentValue);
            // dequeue this cell
            q.remove();
        }

    }

    /**
     * This method is copied from WireRouting, can be reused for this class
     * process all the neighbours of q's front element
     * 
     * @param q
     *            the current point
     * @param matrix
     *            the input matrix
     * @param currentValue
     *            the current value
     */
    private static void labelAndAddNeighbours(QueueInterface<IntPair> q, IntImage matrix, int currentValue) {
        // get the front element and add one to its label
        IntPair current = q.front();
        int value = currentValue;

        // for each neighbour
        for (IntPair nbr : neighbours(matrix, current)) {
            // if its current label is zero
            if (matrix.get(nbr.row, nbr.col) == 1) {
                // label it and add it to the queue
                matrix.set(nbr.row, nbr.col, value);
                q.add(nbr);
            } // end if
        } // end for
    }// end labelAndAddNeighbours

    /**
     * This method is copied from WireRouting, can be reused for this class
     * 
     * get a list of all the current node's neighbours
     * 
     * @param matrix
     *            the iput matrix
     * @param current
     *            the current point
     * @return Iterable<IntPair> the available cells
     */
    private static Iterable<IntPair> neighbours(IntImage matrix, IntPair current) {
        List<IntPair> nbrs = new ArrayList<>();
        int r = current.row;
        int c = current.col;

        // check north
        if (matrix.validAddress(r - 1, c)) {
            nbrs.add(new IntPair(r - 1, c));
        } // end if

        // check south
        if (matrix.validAddress(r + 1, c)) {
            nbrs.add(new IntPair(r + 1, c));
        } // end if

        // check east
        if (matrix.validAddress(r, c + 1)) {
            nbrs.add(new IntPair(r, c + 1));
        } // end if

        // check west
        if (matrix.validAddress(r, c - 1)) {
            nbrs.add(new IntPair(r, c - 1));
        } // end if

        // list is complete
        return nbrs;
    }// end neighbours

    /**
     * This method is copied from WireRouting, can be reused for this class
     * 
     * read a row and column
     * 
     */
    private static IntPair readLocation(String prompt) {
        int row, col;

        System.out.print(prompt);
        row = KBD.nextInt();
        col = KBD.nextInt();
        KBD.nextLine();

        return new IntPair(row, col);
    }

    /**
     * This method is copied from WireRouting, can be reused for this class
     * 
     * get image size and values
     */
    private static IntImage readImage() {
        // create variables
        int numRows, numCols;
        IntImage result;

        // get size of image
        System.out.println("How many rows and columns does the board have?");
        System.out.print("\tNumber of rows: ");
        numRows = readPositiveNumber();
        System.out.print("\tNumber of columns: ");
        numCols = readPositiveNumber();
        pause();

        // create image
        result = new IntImage(numRows, numCols);

        // read in the image
        System.out.println("Create the board by typing " + numRows + " lines with " + numCols + " numbers on each line.\n" + "(The numbers should be zeroes and ones only!)");
        if (result.load(KBD)) {
            System.out.println("\nThank you.  The image is complete.\n");
            pause();
        } else {
            System.out.println("\nI'm sorry, that wasn't right!\n" + "Please try running this program again.\n");
            pause();
            System.exit(1);
        }

        // return loaded image
        return result;
    }

    /**
     * This method is copied from WireRouting, can be reused for this class
     * 
     * read a number greater than zero
     */
    private static int readPositiveNumber() {
        int num = KBD.nextInt();
        KBD.nextLine();
        while (num < 1) {
            System.out.print("Please enter a POSITIVE number: ");
            num = KBD.nextInt();
            KBD.nextLine();
        } // end while
        return num;
    }// end readPositiveNumber

    /**
     * This method is copied from WireRouting, can be reused for this class
     * 
     * introduce yourself and pause
     * 
     */
    private static void printIntroduction() {
        System.out.println("Image Component Labeler\n-----------------------\n");
        System.out.println("This program labels all the connected components of a 0-1 image (a dot-matrix image).\n");
        System.out.println("IntImage and IntPair class by Mark Young\nComponentLabeler by Lingda Cai (A00372181)\n");
        pause();
    }// end printIntroduction

    /**
     * This method is copied from WireRouting, can be reused for this class
     * 
     * prompt the user and wait for them to press enter
     */
    private static void pause() {
        System.out.print("\n...press enter...");
        KBD.nextLine();
        System.out.println();
    }// end pause

    /**
     * This inner class is reused from WireRounting.java This class is designed
     * to be a pair of int values which used as a location in the matrix
     * encapsulated so we can put it in a queue
     * 
     */
    private static class IntPair {

        int row, col;

        // create a pair
        public IntPair(int r, int c) {
            row = r;
            col = c;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", row, col);
        }

        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof IntPair)) {
                return false;
            } // end if
            IntPair that = (IntPair) other;
            return this.row == that.row && this.col == that.col;
        }

        // generated by NetBeans
        // it likes to have this when the equals method is defined
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 37 * hash + this.row;
            hash = 37 * hash + this.col;
            return hash;
        }
    }// end IntPair

}
