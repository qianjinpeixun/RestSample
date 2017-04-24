package com.qianjin.java.dal.cs3;

/*
 * A utility class in order encapulate the rectangle object
 */
public class Rectangle {

	// the left-top corner is 0,0
	private Point p;
	private int width;
	private int height;

	public Rectangle(Point p,int width, int height){
		this.p=p;
		this.width=width;
		this.height=height;
	}
	
	@Override
	public String toString() {
		return "Rectangle [p=" + p + ", width=" + width + ", height=" + height + "]";
	}

	public boolean contains(Point p2) {
		boolean ret = false;
		if (p2.getX() >= left() && p2.getX() <= right() && p2.getY() >= top() && p2.getY() <= bottom())
			ret = true;
		return ret;
	}

	public boolean interects(Rectangle r) {
		boolean ret = true;
		if (r.right() < left())
			ret = false;
		else if (r.bottom() < top())
			ret = false;
		else if (r.left() > right())
			ret = false;
		else if (r.top() > bottom())
			ret = false;
		return ret;
	}

	public boolean coveredBy(Rectangle r) {
		boolean ret = false;
		if (left() >= r.left() && right() <= r.right() && top() <= r.top() && bottom() >= r.bottom())
			ret = true;
		return ret;
	}

	public int quadrant(Point p2) {
		int ret = 0;

		return ret;
	}

	public int left() {
		return p.getX();
	}

	public int right() {
		return p.getX() + width;
	}

	public int top() {
		return p.getY();
	}

	public int bottom() {
		return p.getY() + height;
	}

}
