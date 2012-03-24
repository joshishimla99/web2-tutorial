package com.gayatri.sort;

/**
 * Invariant	: numbers[1..i] are in final position
 * Swaps		: O(n^2)
 * Comparison	: O(n^2)
 * Estimate		: O(n^2)
 * 
 * @author Gayatri
 *
 */
public class BubbleSort extends Sort {

	BubbleSort(Integer[] numbers) {
		super(numbers, false);
	}

	public void sort() {
		int n = numbers.length - 1;
		boolean swapped = false;
		for (int i = 0; i < n; i++) {
			swapped = false;
			for (int j = n; j > i; j--) {
				if (numbers[j] < numbers[j - 1]) {
					swap(numbers, j, j - 1);
					swapped = true;
				}
				iterations ++;
			}
			if (!swapped) {
				break;
			}
		}
	}

	@Override
	public int getExpectedIterations() {
		return (numbers.length^(2));
	}

}
