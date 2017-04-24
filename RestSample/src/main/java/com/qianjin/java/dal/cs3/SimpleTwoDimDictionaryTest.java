package com.qianjin.java.dal.cs3;

/*
 * In order to test the whole assignment result, this class has been created
 */
public class SimpleTwoDimDictionaryTest {

	public static void main(String[] args) {
		Point point = new Point(10, 10);
		Rectangle rectangle = new Rectangle(point, 10, 10);
		QuadTree quadTree = new QuadTree(rectangle);

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

		SimpleTwoDimDictionary simpleTwoDimDictionary = new SimpleTwoDimDictionary(quadTree);

		Point pp = new Point(10, 10);
		Rectangle range = new Rectangle(pp, 10, 9);
		int count = simpleTwoDimDictionary.count(range);
		System.out.println("current ount inside this range is " + count);
		simpleTwoDimDictionary.display();

	}
}
