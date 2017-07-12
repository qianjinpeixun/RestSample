package com.qianjin.java.sss.java2s.a082;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A Priority Queue class.
 * 
 * @author Mark Young (A00000000)
 */
public class PQ<T extends Comparable<? super T>> {

    public static final int DEFAULT_CAPACITY = 10;
    public static final int MAXIMUM_CAPACITY = 10000;

    private T[] list;
    private int numInQueue;
    // instance variable to save Comparator object
    private Comparator<T> newComparator;

    public PQ() {
        // set the default comparator
        //this((T t1, T t2) -> t1.compareTo(t2));
    }// end default constructor

    /**
     * Accept a <code>Comparator</code> according to different soft ways
     * 
     * @param newComparator
     *            which comparator will be used
     */
    public PQ(Comparator<T> newComparator) {
        this.newComparator = newComparator;
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
        numInQueue = 0;
    }// end constructor

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
            // if it reach the maximum, return false
            if (posn == MAXIMUM_CAPACITY) {
                return false;
            } else {
                // start to resize the current capacity
                int resize_capacity = list.length * 2;
                // try to double the current capacity
                // if the resize capacity is more than maximum threshold, use
                // the maximum value as default
                if (resize_capacity > MAXIMUM_CAPACITY) {
                    resize_capacity = MAXIMUM_CAPACITY;
                }
                // create a temporary list for resize
                T[] list2 = (T[]) new Comparable[resize_capacity];
                // deep copy the current list's value
                for (int i = 0; i < list.length; i++) {
                    list2[i] = list[i];
                }
                // modify the current list
                list = list2;
            }
        }
        while (posn > 1) {
            T other = list[posn / 2];
            //using the comparator  
            if (newComparator.compare(other, newElement) > 0) {
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
            if (newComparator.compare(list[small], other) < 0) {
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
        } else if (newComparator.compare(list[c2], list[c1]) < 0) {
            return c2;
        } else {
            return c1;
        }
    }
}