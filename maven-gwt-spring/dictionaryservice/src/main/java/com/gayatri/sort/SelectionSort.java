package com.gayatri.sort;

/**
 * Invariant : numbers[1..i] are in final position and numbers[k] is smallest
 * Swaps : O(n) Comparison : O(n^2) Estimate : O(n^2)
 * 
 * Suffers from a lock step, in which it scans an array which is already sorted.
 * 
 * @author Gayatri
 * 
 */
public class SelectionSort extends Sort {

	SelectionSort(Integer[] numbers) {
		super(numbers, false);
	}

	@Override
	public void sort() {
		int k;
		for (int i = 0; i < numbers.length; i++) {
			k = i;
			// fetching "k" as the smallest element
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[k]) {
					k = j;
				}
				iterations++;
			}
			// swap kth with ith index in the array
			swap(numbers, k, i);
		}
	}

	@Override
	public int getExpectedIterations() {
		return (numbers.length^(2));
	}

}
