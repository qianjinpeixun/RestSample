package com.qianjin.java.sss.java2s.lab05;

public class Exercise3 {

	public static boolean isADivisor(int a, int b) {
		if (a % b == 0)
			return true;
		else
			return false;
	}
	
	public static boolean isPrime (int a){
		for(int i=2;i<a-1;i++){
			if(isADivisor(a,i)==true){
				return false;
			}
		}
		return true;
	}
	
	public static void printPrimes (int a,int b){
		for(int i=a;i<=b;i++){
			if(isPrime(i)==true)
				System.out.println(i);
		}
	}
	
	public static void printNumber(int a){
		for(int i=2;i<a-1;i++){
			if(isADivisor(a,i)==true){
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args){
		
		System.out.println(isADivisor(18, 9));
		System.out.println(isADivisor(21, 4));
		System.out.println(isADivisor(11, 11));
		System.out.println(isPrime(11));
		System.out.println(isPrime(25));
		printPrimes(5,15);
		printNumber(2211);
		printPrimes(200,400);
		printPrimes(2000 ,2200);
		printPrimes(200000000  ,200000200 );
		
		
	}
}
