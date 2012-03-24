package com.gayatri.sort;

/**
 * Invariant : numbers[1..i] are sorted position Swaps : O(n^2) Comparison :
 * O(n^2) Estimate : O(n^2)
 * 
 * @author Gayatri
 * 
 */
public class InsertionSort extends Sort {

	InsertionSort(Integer[] numbers, boolean byRef) {
		super(numbers, byRef);
	}

	@Override
	public void sort() {
		for (int i = 1; i < numbers.length; i++) {
			for (int j = i; j > 0 && numbers[j] < numbers[j - 1]; j--) {
				iterations++;
				swap(numbers, j, j - 1);
			}
			iterations++;
		}
	}

	@Override
	public int getExpectedIterations() {
		return (int) Math.pow(numbers.length, 2);
	}

}
