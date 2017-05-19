package com.qianjin.java.sss.java2s.a03;

/**
 * This class is designed for keeping track of how many times a number comes up (when, for example, rolling a die). 
 * This class can work with the provided sample driver program (TestRandom).
 * This class uses an array in the implementation as introduction in the class.
 *
 * @author Lingda Cai A00372181
 * @version 1.0
 */
public class IntCounter {

	private int total;
	private int min;
	private int max;
	private int[] counts;

	/*
	 * If the minimum is not specified, it is zero. 
	 */
	public IntCounter(int max) {
		this.max = max;
		this.min=0;
		counts=new int[max+1];
		for(int i=0;i<max+1;i++){
			counts[i]=0;
		}
	}

	/*
	 * If both values are specified, the minimum comes first
	 */
	public IntCounter(int min, int max) {
		this.min = min;
		this.max = max;
		counts=new int[max-min+1];
		for(int i=min;i<max+1;i++){
			counts[i-min]=0;
		}
	}

	public static String getAuthorData() {
		return "Lingda Cai (A00372181)";
	}

	public void count(int value) {
		total++;
		for(int i=min;i<max+1;i++){
			if(value==i){
				counts[i-min]=counts[i-min]+1;
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public int getCount(int value) {
		int ret=0;
		for(int i=min;i<max+1;i++){
			if(value==i){
				ret=counts[i-min];
			}
		}
		return ret;
	}

	public int[] toArray() {
		return counts;
	}

}
