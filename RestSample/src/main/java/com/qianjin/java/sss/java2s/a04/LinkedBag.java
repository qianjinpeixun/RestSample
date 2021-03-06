package com.qianjin.java.sss.java2s.a04;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Lingda Cai (A00372181)
 * @version 4.3
 */
public final class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode; // Reference to first node
    private int numberOfEntries; // how many items are in the bag
                                 // (so we don't have to count every time)

    /**
     * Get a String that represents the bag, the string using parentheses (round
     * brackets) instead of brackets (square brackets) The elements of this
     * return will be in any order. If an element is in the bag multiple times,
     * the same number of times will return.
     * 
     * @return A String that represents the bag which begins with a '(' and ends
     *         with a ')'. Each element in the String (except the last) is
     *         followed by a comma and then a space.
     */
    public String toString() {
        // return string need to begin with a '('
        String ret = "(";
        // start to handle all nodes from the first node
        Node currentNode = firstNode;

        // if the bag is empty, return () directly
        if (currentNode == null) {
            return ret + ")";
        }

        // in a loop, get the all object in this bag
        for (int counter = 0; counter < numberOfEntries; ++counter) {
            // Each element in the String (except the last) is followed by a
            // comma and then a space.
            ret = ret + currentNode.data.toString() + ", ";
            currentNode = currentNode.next;
        } // end for

        // remove the last comma and space
        ret = ret.substring(0, ret.length() - 2);
        // ends with a ')'
        ret = ret + ")";

        return ret;
    } // end toString

    /**
     * Removes every occurrence of anElement from the bag. According to the
     * requirement of this lab, this method don't call any of the other methods.
     * 
     * @param t
     *            the node which needs to be removed
     * 
     */
    public void expunge(T t) {
        // from the first node to find
        Node currentNode = firstNode;

        // Start to find in a loop till reach the last node
        while (currentNode != null) {
            // if found t, copy first node's data into this node and moving the
            // first node to the next one.
            if (currentNode.data.equals(t)) {
                // copy the first node's value to current node
                currentNode.data = firstNode.data;
                // move the fristNode to next one
                firstNode = firstNode.next;
                // shrink the size of bag
                numberOfEntries--;
            }
            // move to the next one
            currentNode = currentNode.next;
        } // end while
    } // end expunge

    /**
     * Move every element from this bag into the otherBag.
     * 
     * @param bag
     *            the anohter bag which will contain all of the nodes of the
     *            current bag.
     */
    public void moveTo(LinkedBag<T> bag) {
        // from the first node to find
        Node currentNode = firstNode;

        // Start to handle in a loop till reach the last node
        while (currentNode != null) {
            // add a new node into newBag with the value of current node.
            bag.add(currentNode.data);
            // moving to next one.
            currentNode = currentNode.next;
        } // end while

        // after the whole moving, make the current bag empty.
        firstNode = null;
        // shrink the numbers to zero
        numberOfEntries = 0;
    } // end moveTo

    /**
     * Create an empty Bag.
     */
    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    /**
     * Return whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    /**
     * Gets the number of entries currently in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry
     *            The object to be added as a new entry
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) { // OutOfMemoryError possible
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;

        return true;
    } // end add

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

        Node currentNode = firstNode;
        for (int index = 0; index < numberOfEntries; ++index) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
        } // end for

        return result;
    } // end toArray

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry
     *            The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;

        Node currentNode = firstNode;
        for (int counter = 0; counter < numberOfEntries; ++counter) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            } // end if

            currentNode = currentNode.next;
        } // end for

        return frequency;
    } // end getFrequencyOf

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry
     *            The entry to locate.
     * @return True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        for (int i = 0; !found && i < numberOfEntries; ++i) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end for

        return found;
    } // end contains

    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node findNode(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        for (int i = 0; !found && i < numberOfEntries; ++i) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end for

        return currentNode;
    } // end findNode

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while (!isEmpty())
            remove();
    } // end clear

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
        } // end if

        return result;
    } // end remove

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry
     *            The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = findNode(anEntry);

        if (nodeN != null) {
            // Replace located entry with entry in first node
            nodeN.data = firstNode.data;

            // Remove first node
            firstNode = firstNode.next;
            numberOfEntries--;

            result = true;
        } // end if

        return result;
    } // end remove

    // Private class for holding the data and pointers
    private class Node {
        public T data; // Entry in bag
        public Node next; // Link to next node

        public Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        public Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node

} // end LinkedBag
