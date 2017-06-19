package com.qianjin.java.sss.java2s.a08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A Priority Queue class.
 * 
 * 1. Allow to grow from its original size up to a maximum size.
 * 
 * 2. added a Comparator<T> instance variable in order to support different sort
 * ways
 * 
 * 3. added a new constructor that accepts a Comparator<T> argument.
 * 
 * 4. Revise the original constructor to call the revised constructor using the
 * Comparator, and using lambda expressions
 * 
 * 5. remove the calls of compareTo of comparable interface, replacing with the
 * calls: compare with Compartor in the add/remove/smallerChild methods.
 * 
 * @author Lingda Cai (A00372181)
 */
public class PQ<T extends Comparable<? super T>> {

    public static final int DEFAULT_CAPACITY = 10;

    public static final int MAX_CAPACITY = 10000;

    private T[] list;
    private int numInQueue;

    // a Comparator<T> instance variable
    private Comparator<T> comparator;

    /**
     * Default constructor, create a default Comparator for lexicographic order
     */
    public PQ() {
        // Revise the original constructor to call the revised constructor using
        // the Comparator using lambda expressions
        this((t1, t2) -> {
            return t1.compareTo(t2);
        });
    }// end default constructor

    /**
     * added a constructor that accepts a Comparator<T> argument
     * 
     * @param c
     *            the Comparator for sort
     */
    public PQ(Comparator<T> c) {
        this.comparator = c;
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
        numInQueue = 0;
    }// end constructor

    /**
     * If the list length reach the default size, double the size till reach the
     * max capacity.
     * 
     * This code is copied from ResizingArrayBag
     * 
     * @return true if successful; false otherwise
     * 
     */
    private boolean resize() {
        int oldSize = list.length;
        int newSize = Math.min(MAX_CAPACITY, 2 * oldSize);
        if (newSize > oldSize) {
            list = Arrays.copyOf(list, newSize);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add newElement to this PQ
     * 
     * @param newElement
     *            the element to add
     * @return true if successful; false otherwise
     */
    public boolean add(T newElement) {
        int posn = numInQueue + 1;
        if (posn == list.length) {
            // copy the code from ResizingArrayBag
            if (!resize()) {
                // couldn't actually resize the array
                return false;
            }
        }
        while (posn > 1) {
            T other = list[posn / 2];
            // if (other.compareTo(newElement) > 0) {
            // Revise the calls to compareTo in the methods to be calls to
            // compare using the saved Comparator.
            if (comparator.compare(other, newElement) > 0) {

                list[posn] = other;
                posn = posn / 2;
            } else {
                break;
            }
        }
        list[posn] = newElement;
        ++numInQueue;
        return true;
    }

    /**
     * Whether this PQ is empty.
     * 
     * @return whether this PQ is empty.
     */
    public boolean isEmpty() {
        return numInQueue == 0;
    }

    /**
     * Remove the highest-priority item from this PQ.
     * 
     * @return the highest-priority item from this PQ
     */
    public T remove() {
        T result = list[1];
        T other = list[numInQueue];
        int posn = 1;
        while (numInQueue > 2 * posn) {
            int small = smallerChild(posn);
            // Revise the calls to compareTo in the methods to be calls to
            // compare using the saved Comparator.
            // if (list[small].compareTo(other) < 0) {
            if (comparator.compare(list[small], other) < 0) {
                list[posn] = list[small];
                posn = small;
            } else {
                break;
            }
        }
        list[posn] = other;
        --numInQueue;
        return result;
    }

    private int smallerChild(int posn) {
        int c1 = posn * 2;
        int c2 = c1 + 1;
        if (c2 >= numInQueue) {
            return c1;
            // Revise the calls to compareTo in the methods to be calls to
            // compare using the saved Comparator.
            // } else if (list[c2].compareTo(list[c1]) < 0) {
        } else if (comparator.compare(list[c2], list[c1]) < 0) {
            return c2;
        } else {
            return c1;
        }
    }
}