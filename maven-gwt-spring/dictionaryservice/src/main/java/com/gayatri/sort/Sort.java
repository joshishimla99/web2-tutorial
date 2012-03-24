package com.gayatri.sort;

public abstract class Sort {
	Integer[] numbers;
	int iterations;

	Sort(Integer[] numbers, boolean byRef) {
		if (byRef){
			this.numbers = numbers;
		}
		else {
			this.numbers = new Integer[numbers.length];
			for (int i = 0; i < numbers.length; i++) {
				this.numbers[i] = numbers[i];
			}			
		}
	}
	
	public abstract void sort();

	public void print() {
		System.out.print("\nSorted list : ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

	protected void swap(Integer[] numbers, int a, int b) {
		Integer tmp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = tmp;
	}
	
	public int getIterations() {
		return iterations;
	}
	
	public abstract int getExpectedIterations();
	
	public void printIterations() {
		System.out.println("The number of iterations = " + iterations);
		System.out.println("The number of iterations expected = " + getExpectedIterations());
	}
}
