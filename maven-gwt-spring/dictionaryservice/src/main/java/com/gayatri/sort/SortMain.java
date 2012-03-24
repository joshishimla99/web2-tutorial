package com.gayatri.sort;

public class SortMain {
	public static void main(String[] args) {
		
		Integer[] valuesUsed = getValuesRandom();
		
		Sort sorter = new QuickSort(valuesUsed);
		sorter.sort();
		sorter.print();
		sorter.printIterations();
		
		sorter = new InsertionSort(valuesUsed, false);
		sorter.sort();
		sorter.print();
		sorter.printIterations();	
	}
	
	static void print(Integer[] values) {
		System.out.print("\nThe values are : ");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	
	static Integer[] getValuesRandom() {
		Integer[] valuesRandom = { 5, -9, 3, 0, 1 , 7, 3,9, 2, -4, -2, -1, 6};
		print(valuesRandom);
		return valuesRandom;
	}
	
	static Integer[] getValuesRevOrdered() {
		Integer[] valuesRevOrdered = {5, 4, 3, 2, 1 , 0, -1, -2};
		print(valuesRevOrdered);
		return valuesRevOrdered;
	}
	
	static Integer[] getValuesOrdered() {
		Integer[] valuesOrdered = { 1, 2, 3, 4, 5};
		print(valuesOrdered);
		return valuesOrdered;
	}

	static Integer[] getValuesAlmostSorted() {
		Integer[] valuesOrdered = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 14};
		print(valuesOrdered);
		return valuesOrdered;
	}

	static Integer[] getValuesRepeated() {
		Integer[] valuesRepeated = { 1, 2, 1, 4, 2, 1, 1, 4,3, 5, 9, 0, 0 , 1};
		print(valuesRepeated);
		return valuesRepeated;
	}
}
