package com.qianjin.java.sss.java2s.a092;

/**
 * A Priority Queue class.
 * 
 * @author Mark Young (A00000000)
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
        ++opCount; // assignment: posn = numInQueue + 1
        int posn = numInQueue + 1;

        ++opCount; // comparison: if (posn == list.length)
        if (posn == list.length) {
            return false;
        }
        ++opCount; // comparison: posn > 1
        while (posn > 1) {

            ++opCount;  // assignment: other = list[posn / 2]
            T other = list[posn / 2];
            ++opCount; // comparison: other.compareTo(newElement) > 0
            if (other.compareTo(newElement) > 0) {
                ++opCount; // assignment: list[posn] = other
                list[posn] = other;
                ++opCount; // assignment: posn = posn / 2
                posn = posn / 2;
            } else {
                break;
            }
        }
        ++opCount; // assignment: list[posn] = newElement
        list[posn] = newElement;
        ++opCount; // assignment: ++numInQueue
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
        ++opCount; // assignment: result = list[1]
        T result = list[1];
        ++opCount; // assignment: other = list[numInQueue]
        T other = list[numInQueue];
        ++opCount; // assignment: posn = 1
        int posn = 1;
        ++opCount; // comparison: numInQueue > 2 * posn
        while (numInQueue > 2 * posn) {
            ++opCount; // assignment: small = smallerChild(posn)
            int small = smallerChild(posn);
            ++opCount; // comparison: list[small].compareTo(other) < 0
            if (list[small].compareTo(other) < 0) {
                ++opCount; // assignment: list[posn] = list[small]
                list[posn] = list[small];
                ++opCount; // assignment: posn = small
                posn = small;
            } else {
                break;
            }
        }
        ++opCount; // assignment: list[posn] = other
        list[posn] = other;
        ++opCount; // assignment: --numInQueue
        --numInQueue;
        return result;
    }

    private int smallerChild(int posn) {
        ++opCount; // assignment: c1 = posn * 2
        int c1 = posn * 2;
        ++opCount; // assignment: c2 = c1 + 1
        int c2 = c1 + 1;
        ++opCount; // comparison: c2 >= numInQueue or
                   // list[c2].compareTo(list[c1]) < 0
        if (c2 >= numInQueue) {
            return c1;
        } else if (list[c2].compareTo(list[c1]) < 0) {
            return c2;
        } else {
            return c1;
        }
    }
}