package com.gayatri.sort;

public class QuickSort extends Sort {

	public QuickSort(Integer[] numbers) {
		super(numbers, false);
	}

	@Override
	public void sort() {
		quicksort(numbers, 0, (numbers.length - 1));
	}

	public void quicksort(Integer[] numbers, int p, int r) {
		if (p < r) {
			int q = partition(numbers, p, r);
			quicksort(numbers, p, q - 1);
			quicksort(numbers, q + 1, r);			
		}
	}

	private int partition(Integer[] numbers, int p, int r) {
		System.out.println("Partition : " + p + " , " + r);
		int i = p - 1;
		int x = numbers[r];

		for (int j = p; j <= r - 1; j++) {
			if (numbers[j] <= x) {
				i = i + 1;
				swap(numbers, i, j);
			}
			iterations++;
		}
		swap(numbers, i+1, r);
		return i+1;
	}

	@Override
	public int getExpectedIterations() {
		int n = numbers.length;
		return (int) (n * (Math.log(n) / Math.log(2)));
	}

}
