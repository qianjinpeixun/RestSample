package com.qianjin.java.sss.java2s.a03;

import java.util.Arrays;

/**
 * This class is designed for keeping track of how many times a number comes up
 * For example, rolling a die. This class can work with the provided sample
 * driver program (TestRandom). This class uses an array in the implementation
 * as introduction in the class.
 *
 * @author Lingda Cai A00372181
 * @version 1.0
 */
public class IntCounter {

	// This is to store the total number of counting
	private int total;
	// This is for storing the start(minimum) value, by default is zero
	private int min;
	// This is for storing the end(maximum) value
	private int max;
	// This is an array in order to store each dice number's existing numbers
	private int[] counts;

	/**
	 * If the minimum is not specified, it is zero.
	 * 
	 * @param max
	 *            a maximum possible value.
	 * @throws IllegalArgumentException
	 *             If the input variable of maximum is less than or equals o,
	 *             throw an exception
	 */
	public IntCounter(int max) {
		// if the max value is under than or equals zero, throw an exception
		if (max <= 0)
			throw new IllegalArgumentException("Invalid value of maximum: " + max);
		else {
			this.max = max;
			this.min = 0;
			// set the capacity of array
			counts = new int[max + 1];
			// set the default value in array to zero
			for (int i = 0; i < max + 1; i++) {
				counts[i] = 0;
			}
		}
	}

	/**
	 * If both values are specified, the minimum comes first
	 * 
	 * @param min
	 *            a minimum possible value.
	 * @param max
	 *            a maximum possible value.
	 * @throws IllegalArgumentException
	 *             If the input variable of maximum is less than or equals o,
	 *             throw an exception
	 * @throws IllegalArgumentException
	 *             If the min value is bigger than or equals max value, return
	 *             this exception
	 * 
	 */
	public IntCounter(int min, int max) {
		// if the min value is less than or equals zero, an exception will be
		// returned
		if (max <= 0)
			throw new IllegalArgumentException("Invalid value of maximum: " + max);
		else if (min >= max) {
			throw new IllegalArgumentException("Invalid value minimux must be less than maximum value.");
		} else {
			this.min = min;
			this.max = max;
			// set the capacity of array
			counts = new int[max - min + 1];
			// set the default value in array to zero
			for (int i = min; i < max + 1; i++) {
				counts[i - min] = 0;
			}
		}
	}

	/**
	 * According to the requirement of lab, this class must also have the
	 * getAuthorData method that the program uses to print out your name and ID
	 * number as the author of the IntCounter class.
	 * 
	 * @return String the name and ID number
	 */
	public static String getAuthorData() {
		return "Lingda Cai (A00372181)";
	}

	/**
	 *
	 * @param
	 */

	/**
	 * Count particular values as prompted by the client program.
	 * <p>
	 * Preconditions: <code>value</code> contains numbers in the range
	 * [min..max] where <code>max - min == 5</code>.
	 * <p>
	 * Postconditions:
	 * <ul>
	 * <li><code>total</code> has been increased;
	 * <li>the count of <code>value</code> has been increased.
	 * </ul>
	 * 
	 * @param value
	 *            item index, such as the number of side of dice
	 */

	public void count(int value) {
		// each time, change the value of total
		total++;
		// add the number according to value
		for (int i = min; i < max + 1; i++) {
			if (value == i) {
				counts[i - min] = counts[i - min] + 1;
			}
		}
	}

	/**
	 * The total of all counts so far In order to avoid the client change the
	 * value of total, just a getter method is provided.
	 * 
	 * @return current total counts
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Using an int array holding the counts of each item. ( such as the count of
	 * one side of dice)
	 * 
	 * @param value,
	 *            which side of dice
	 * @return count, the current count of this side coming up
	 */
	public int getCount(int value) {
		int ret = 0;
		//finding the number according to value
		for (int i = min; i < max + 1; i++) {
			if (value == i) {
				ret = counts[i - min];
			}
		}
		return ret;
	}

	/**
	 * Secure by preventing the client from modifying the counts (other than by
	 * asking for a value to be counted)
	 * 
	 * @return IntArray return the copy of current array
	 */
	public int[] toArray() {
		return Arrays.copyOf(counts, counts.length);
	}

}
