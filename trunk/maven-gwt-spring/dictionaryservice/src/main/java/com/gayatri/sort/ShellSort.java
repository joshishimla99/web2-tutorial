package com.gayatri.sort;

/**
 * Shell Sort only compares the numbers in a particular shell.
 * 
 * We are going to consider the shell / gap size by dividing the previous size
 * by 2.
 * 
 * @author Gayatri
 * 
 */
public class ShellSort extends Sort {

	ShellSort(Integer[] numbers) {
		super(numbers, false);
	}

	@Override
	public void sort() {
		// The gaps are l/2, l/4, .. .
		int gap = numbers.length;
		while ((gap / 2) > 0) {
			gap = gap / 2;
			for (int i = gap; i < numbers.length; i++) {
				int temp = numbers[i];
				int j = i;
				for (; j >= gap && numbers[j - gap] > temp; j = j - gap) {
					numbers[j] = numbers[j - gap];
					iterations++;
				}
				numbers[j] = temp;
			}
		}
	}

	@Override
	public int getExpectedIterations() {
		return (numbers.length ^ (3 / 2));
	}

}
