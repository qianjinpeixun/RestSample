package com.qianjin.java.sss.java2s.lab05;

public class Exercise2 {

	public static void main(String[] args) {
		fib(15);
		fib(16);
	}

	public static void fib(int number) {
		System.out.print("the first ");
		System.out.print(number);
		System.out.print(" Fibonacci numbers:");

		System.out.print(0);
		System.out.print(" ");
		System.out.print(1);
		System.out.print(" ");

		int a1 = 0;
		int a2 = 1;
		for (int i = 1; i < number-1; i++) {
			System.out.print(a1 + a2);
			System.out.print(" ");
			int t=a1;
			a1 = a2;
			a2 = t + a2;
		}
		System.out.println("");
	}
}
