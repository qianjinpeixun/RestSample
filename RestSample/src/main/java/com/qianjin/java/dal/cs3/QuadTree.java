package com.qianjin.java.dal.cs3;

import java.util.*;

/**
 * This class implements a quadTree data structure. 
 * @author CS Student
 *
 */
public class QuadTree {

	/*
	 * Override the default toString method, just simple to print the current
	 * number of points and other information (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		System.out.println("nums=" + num + ",point=" + point + ",bounds=" + bounds + ",sub=" + sub);
		return "";
	}

	Rectangle bounds;
	int num;
	Point point;
	QuadTree sub[];

	/*
	 * this constructor need one parameter: one rectangle, means this QuadTree
	 * can store whose positions of points
	 */

	public QuadTree(Rectangle bounds) {
		this.bounds = bounds;
		num = 0;
	}

	/*
	 * the first input: Vector, basiclly is an empty object, after this method,
	 * the result will be stored in this object
	 */
	public Vector query(Vector set, Rectangle range) {
		if (bounds.interects(range)) {
			if (num == 1) {
				if (range.contains(point)) {
					set.addElement(point);
				}
			} else if (num > 1) {
				for (int i = 0; i < 4; i++) {
					sub[i].query(set, range);
				}
			}
		}
		return set;
	}

	/*
	 * eadh time after adding a new Point, needs to adjust quadTree, if it's
	 * necessary, a new quadrant will be splited
	 */
	public void insert(Point p) {
		if (num == 0) {
			point = p;
		} else if (num == 1) {
			split();
			sub[quadrant(point)].insert(point);
			point = null;
			sub[quadrant(p)].insert(p);
		} else {
			sub[quadrant(p)].insert(p);
		}
		num++;
	}

	/*
	 * creating a new four quadrant in order to put a point
	 */
	private void split() {
		sub = new QuadTree[4];
		Point p0 = new Point(bounds.left(), bounds.top());
		int w0 = (int) ((bounds.right() - bounds.left()) / 2);
		int h0 = (int) ((bounds.bottom() - bounds.top()) / 2);
		Rectangle rec0 = new Rectangle(p0, w0, h0);
		sub[0] = new QuadTree(rec0);

		p0 = new Point(bounds.left() + w0 / 2, bounds.top());
		Rectangle rec1 = new Rectangle(p0, w0, h0);
		sub[1] = new QuadTree(rec1);

		p0 = new Point(bounds.left(), bounds.top() + h0 / 2);
		Rectangle rec2 = new Rectangle(p0, w0, h0);
		sub[2] = new QuadTree(rec2);

		p0 = new Point(bounds.left() + w0 / 2, bounds.top() + h0 / 2);
		Rectangle rec3 = new Rectangle(p0, w0, h0);
		sub[3] = new QuadTree(rec3);
	}

	/*
	 * In order to get which quadrant one point should be inside
	 */
	private int quadrant(Point p) {
		int ret = 0;
		if (sub[0].bounds.contains(p))
			return 0;
		else if (sub[1].bounds.contains(p))
			return 1;
		else if (sub[2].bounds.contains(p))
			return 2;
		else if (sub[3].bounds.contains(p))
			return 3;
		return ret;
	}
}
