package com.qianjin.java.dal.cs3;

import java.util.ArrayList;
import java.util.Vector;

/*
 * This class implement one interface in order to make a show case how the QuadTree data structure work
 */
public class SimpleTwoDimDictionary implements TwoDimDictionary {

	private QuadTree quadTree;

	public SimpleTwoDimDictionary(QuadTree quadTree) {
		this.quadTree = quadTree;
	}

	public void insert(Point p) {
		quadTree.insert(p);
	}

	// return the number of points in the data structure that are inside the
	// rect query bounds b
	public int count(Rectangle b) {
		Vector set = new Vector();
		set = quadTree.query(set, b);
		if (set != null)
			return set.size();
		else
			return 0;

	}

	// add to ArrayList s reference to all points in the data structure that are
	// inside the rac query vounds b
	public ArrayList query(ArrayList s, Rectangle b) {
		Vector set = new Vector();
		set = quadTree.query(set, b);
		ArrayList arrayList = new ArrayList(set);
		return arrayList;

	}

	// return number of points stores in the data structure
	public int size() {
		return quadTree.num;
	}

	// print a representation of the data structure
	public void display() {
		System.out.println("Current QuadTress is:");
		String ret = quadTree.toString();
	}

}
