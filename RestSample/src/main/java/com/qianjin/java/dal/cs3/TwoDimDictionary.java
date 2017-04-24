package com.qianjin.java.dal.cs3;

import java.util.*;

public interface TwoDimDictionary {

	public void insert(Point p);
	//return the number of points in the data structure that are inside the rect query bounds b
	public int count(Rectangle b);
	
	//add to ArrayList s reference to all points in the data structure that are inside the rac query vounds b
	public ArrayList query(ArrayList s, Rectangle b);
	
	//return number of points stores in the data structure
	public int size();
	
	//print a representation of the data structure
	public void display();
	
}
