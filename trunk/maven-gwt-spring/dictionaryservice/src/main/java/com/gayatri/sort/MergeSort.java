package com.gayatri.sort;

public class MergeSort extends Sort {

	MergeSort(Integer[] numbers) {
		super(numbers, false);
	}

	@Override
	public void sort() {
		partition(numbers, 0, numbers.length - 1);
	}

	public void partition(Integer[] numbers, int p, int r) {

		if (p < r) {
			int q = ((p + r) / 2);
			partition(numbers, p, q);
			partition(numbers, q + 1, r);
			mergeAndSort(numbers, p, q, r);
		}
	}

	public void mergeAndSort(Integer[] numbers, int p, int q, int r) {
		int n1 = (q - p) + 1;
		int n2 = (r - q);
		Integer[] left = new Integer[n1 + 1];
		Integer[] right = new Integer[n2 + 1];
		int k = p;
		int l = 0;
		for (; l < n1; l++, k++) {
			left[l] = numbers[k];
		}
		left[l] = Integer.MAX_VALUE;
		int ri = 0;
		for (; ri < n2; ri++, k++) {
			right[ri] = numbers[k];
		}
		right[ri] = Integer.MAX_VALUE;
		k = p;
		l = 0;
		ri = 0;
		while (k <= r) {
			if (left[l] <= right[ri]) {
				numbers[k] = left[l];
				l++;
			} else {
				numbers[k] = right[ri];
				ri++;
			}
			k++;
			iterations++;
		}
	}

	@Override
	public int getExpectedIterations() {
		int n = numbers.length;
		return (int) (n * (Math.log(n) / Math.log(2)));
	}

}
