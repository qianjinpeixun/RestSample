package com.qianjin.java.sss.java2s;

/**
 * This classes "implement" the interfaces of Ring, but it really just throw UnsupportedOperationExceptions for all the methods.
 * In order to simplify the implementation, a String object is set to generic Ring interface 
 *
 * @author Lingda Cai A00372181
 * @version 1.0
 */

public class MyRing implements Ring<String> {

	public RingIterator<String> iterator() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public boolean isEmpty() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public boolean add(String s) {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public boolean remove(int index) {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public String get(int index) {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public String getFirst() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public String getLast() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public int size() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public String toString() {
		throw new UnsupportedOperationException("Not supported yet.");

	}
}
