package com.qianjin.java.sss.java2s.a02;


/**
 * This classes "implement" the interfaces of RingIterator, but it really just throw UnsupportedOperationExceptions for all the methods.
 * In order to simplify the implementation, a String object is set to generic RingIterator interface 
 *
 * @author Lingda Cai A00372181
 * @version 1.0
 */
public class MyRingIterator implements RingIterator<String> {

	public String next() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public boolean remove() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public boolean isHead() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public boolean isLast() {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public boolean hasNext() {
		throw new UnsupportedOperationException("Not supported yet.");

	}
}
