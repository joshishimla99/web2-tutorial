package com.weird.examples;

public class CycleLength {
	
	static int calculateCycleLength(int n, int len, int maxLen) {
		
		if (n <= 1) {
			return len;
		}
		if ((n % 2) == 0) {
			System.out.print(n + "  ");
			n = n / 2;
			len++;
		} else {
			System.out.print(n + "  ");
			n = (3 * n + 1);
			len++;
		}
		return calculateCycleLength(n, len, maxLen);
	}
	
	public static void main(String[] args) {
		int maxLen = 0;
		for (int i = 101 ; i <= 200 ; i = i + 2) {
			System.out.println(calculateCycleLength(i, 1, maxLen));	
		}
		
	}
}
