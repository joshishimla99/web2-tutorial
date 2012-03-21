package com.weird.examples;

public class MergeSort {
	void merge_sort(Integer[] arr, int p, int r) {
		if (p < r) {
			int q = ((p + r) / 2);
			merge_sort(arr, p, q);
			merge_sort(arr, q + 1, r);
			merge(arr, p, q, r);
			System.out.println("p:" + p + ",q:" + q + ",r:" + r);
			print(arr);
		}
	}

	void merge(Integer[] arr, int p, int q, int r) {
		Integer[] left = new Integer[q - p + 1 + 1];
		Integer[] right = new Integer[r - q + 1];
		int k = p;
		int i = 0;
		while (i < (q - p) + 1) {
			left[i] = arr[k];
			k++;
			i++;
		}
		left[i] = Integer.MAX_VALUE;
		i = 0;
		while (i < (r - q)) {
			right[i] = arr[k];
			k++;
			i++;
		}
		right[i] = Integer.MAX_VALUE;
		k = p;
		int left_index = 0;
		int right_index = 0;
		while (k <= r) {
			if (left[left_index] <= right[right_index]) {
				arr[k] = left[left_index];
				left_index++;
			} else {
				arr[k] = right[right_index];
				right_index++;
			}
			k++;
		}

	}

	void print(Integer[] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i] + " ");
		}
	}

	public static void main(String[] args) {
		Integer[] values = { 3, -8, 1, -9, 2 };
		MergeSort sort = new MergeSort();
		sort.merge_sort(values, 0, values.length - 1);

	}
}
