package com.qianjin.java.sss.java2s.lab052;

public class Exercise3 {

	public static boolean isADivisor(int a, int b) {
		if (a % b == 0)
			return true;
		else
			return false;
	}

	public static boolean isPrime(int a) {

		int i = 2;
		while (i < a) {
			if (isADivisor(a, i) == true) {
				return false;
			}
			i = i + 1;
		}
		return true;
	}

	public static void printPrimes(int a, int b) {
		int i = a;
		while (i <= b) {
			if (isPrime(i) == true)
				System.out.println(i);
			i = i + 1;
		}
	}

	public static void printNumber(int a) {
		int i = 2;
		while (i < a - 1) {
			if (isADivisor(a, i) == true) {
				System.out.println(i);
			}
			i = i + 1;
		}
	}

	public static void main(String[] args) {

		System.out.print("isADivisor(18, 9)=");
		System.out.println(isADivisor(18, 9));

		System.out.print("isADivisor(21, 4)=");
		System.out.println(isADivisor(21, 4));
		System.out.print("isADivisor(11, 11)=");
		System.out.println(isADivisor(11, 11));
		System.out.print("isPrime(11)=");
		System.out.println(isPrime(11));
		System.out.print("isPrime(25)=");
		System.out.println(isPrime(25));
		System.out.println("The result of printPrimes(5,15) is:");
		printPrimes(5, 15);
		System.out.println("The result of printNumber(2211) is:");
		printNumber(2211);
		System.out.println("The result of printPrimes(200,400) is:");
		printPrimes(200, 400);
		System.out.println("The result of printPrimes(2000 ,2200) is:");
		printPrimes(2000, 2200);
		System.out.println("The result of printPrimes(200000000  ,200000200 ) is:");
		printPrimes(200000000, 200000200);

	}
}
