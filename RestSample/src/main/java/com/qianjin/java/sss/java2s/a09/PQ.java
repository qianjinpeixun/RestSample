package com.qianjin.java.sss.java2s.a09;

/**
 * A Priority Queue class.
 * 
 * Revise this class by adding commands to count operations. What has been done
 * is add the commands to increment the operation counter at the appropriate
 * times.
 * 
 * A report (report.txt) has been created with this class which includes:
 * 
 * 1. the output the program produced
 * 
 * 2. formulas for the number of operations for adding to/removing from a PQ of
 * size N; (two formulas for removing from the PQ, since even and odd numbers
 * may do different amounts of work.)
 * 
 * 3. the orders of magnitude for those formulas.
 * 
 * @author Lingda Cai (A00372181)
 */
public class PQ<T extends Comparable<? super T>> {

    // ---------- Counter IVs and Methods ------------------------------ //
    private int opCount = 0;

    /**
     * Return the current operation count without changing it.
     * 
     * @return value of operation counter.
     */
    public int getOpCount() {
        return opCount;
    }

    /**
     * Set the operation count back to zero.
     */
    public void resetOpCount() {
        opCount = 0;
    }

    /**
     * Get the current operation count before setting it to zero.
     * 
     * @return the operation count before it was reset to zero.
     */
    public int getAndResetOpCount() {
        int result = opCount;
        opCount = 0;
        return result;
    }

    // ---------- Previous Implementation of PQ ------------------------- //

    public static final int DEFAULT_CAPACITY = 10;

    private T[] list;
    private int numInQueue;

    /**
     * Create a PQ with the given capacity.
     * 
     * @param capacity
     *            the requested capacity of the PQ.
     */
    public PQ(int capacity) {
        // make array one bigger because we don't use location 0.
        list = (T[]) new Comparable[capacity + 1];
        numInQueue = 0;
    }

    /**
     * Create a PQ with a default capacity.
     */
    public PQ() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Add newElement to this PQ
     * 
     * @param newElement
     *            the element to add
     * @return true if successful; false otherwise
     */
    public boolean add(T newElement) {
        ++opCount; // operation: numInQueue + 1
        int posn = numInQueue + 1;
        ++opCount; // comparison: posn == list.length
        if (posn == list.length) {
            return false;
        }
        ++opCount; // comparison: posn > 1
        while (posn > 1) {
            ++opCount; // operation: posn / 2
            ++opCount; // get list element: list[posn / 2];
            T other = list[posn / 2];
            ++opCount; // comparison: other.compareTo(newElement) > 0
            if (other.compareTo(newElement) > 0) {
                ++opCount; // set value of list element: list[posn] = other
                list[posn] = other;
                ++opCount; // operation: posn / 2
                posn = posn / 2;
            } else {
                break;
            }
        }
        ++opCount; // operation: list[posn] = newElement
        list[posn] = newElement;
        ++opCount; // operation: ++numInQueue
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
        ++opCount; // get list element: T result = list[1]
        T result = list[1];
        ++opCount; // get list element: T other = list[numInQueue]
        T other = list[numInQueue];
        ++opCount; // operation: posn = 1
        int posn = 1;
        ++opCount; // comparison:numInQueue > 2 * posn
        while (numInQueue > 2 * posn) {
            ++opCount; // function call: smallerChild(posn)
            int small = smallerChild(posn);
            ++opCount; // comparison: list[small].compareTo(other) < 0
            if (list[small].compareTo(other) < 0) {
                ++opCount; // set value: list[posn] = list[small];
                list[posn] = list[small];
                ++opCount; // set value: posn = small;
                posn = small;
            } else {
                break;
            }
        }
        ++opCount; // set value: list[posn] = other
        list[posn] = other;
        ++opCount; // calculation: --numInQueue;
        --numInQueue;
        return result;
    }

    private int smallerChild(int posn) {
        ++opCount; // operation: posn * 2;
        int c1 = posn * 2;
        ++opCount; // operation: c1 + 1;
        int c2 = c1 + 1;
        ++opCount; // comparison: c2 >= numInQueue
        if (c2 >= numInQueue) {
            return c1;
        } else if (list[c2].compareTo(list[c1]) < 0) {
            ++opCount; // comparison: list[c2].compareTo(list[c1]) < 0
            return c2;
        } else {
            ++opCount; // function, return
            return c1;
        }
    }
}