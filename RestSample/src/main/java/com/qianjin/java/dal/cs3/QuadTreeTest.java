package com.qianjin.java.dal.cs3;

import java.util.Vector;

/*
 * This test class will create a object of class QuadTree, and call the methods to test if they work well
 */
public class QuadTreeTest {

	public static void main(String[] args) {

		Point point = new Point(10, 10);
		Rectangle rectangle = new Rectangle(point, 10, 10);
		QuadTree quadTree = new QuadTree(rectangle);

		System.out.println("Begining, Quadtree is null");
		System.out.println(quadTree);

		point = new Point(11, 11);
		quadTree.insert(point);
		System.out.println("After added new point:" + point);
		System.out.println(quadTree);

		point = new Point(16, 16);
		quadTree.insert(point);
		System.out.println("After added new point:" + point);
		System.out.println(quadTree);

		point = new Point(16, 10);
		quadTree.insert(point);
		System.out.println("After added new point:" + point);
		System.out.println(quadTree);

		point = new Point(10, 16);
		quadTree.insert(point);
		System.out.println("After added new point:" + point);
		System.out.println(quadTree);

		// create a new range, in order to find how many points inside this
		// range
		Vector set = new Vector();
		Point pp = new Point(10, 10);
		Rectangle range = new Rectangle(pp, 10, 9);
		quadTree.query(set, range);
		System.out.println(set.size());
		System.out.println(set);

	}
}
