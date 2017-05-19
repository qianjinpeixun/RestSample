package com.qianjin.java.sss.java2s.lab05;

public class Exercise1 {
	public static void main(String[] args) {
		alternateNumbers(6);
		alternateNumbers(7);
	}

	public static void alternateNumbers(int number) {
		System.out.print("(");
		System.out.print(number);
		System.out.print(")");
		System.out.print("：");
		System.out.print(" ");

		for (int i = 1; i < number; i++) {
			if (i % 2 == 0)
				System.out.print(0 - i);
			else
				System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("");
	}

}
