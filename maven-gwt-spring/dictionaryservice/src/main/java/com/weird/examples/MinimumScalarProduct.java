package com.weird.examples;

public class MinimumScalarProduct {

	int leastValue = 1000;

	class Vector {
		Integer[] numbers;
		Integer[] initialNumbers;
		int size;

		Vector(int size) {
			numbers = new Integer[size];
			this.size = size;
		}

		int getValue(int index) {
			return numbers[index];
		}

		int getSize() {
			return numbers.length;
		}

		void setValues(Integer[] values) {
			for (int i = 0; i < size; i++) {
				numbers[i] = values[i];
				initialNumbers[i] = values[i];
			}
		}
	}

	boolean permutate(Integer[] current, Integer[] rest, Integer[] v2, int pos)
			throws Exception {
		if (current.length == 2) {
			return true;
		}
		Integer[] local = new Integer[current.length - pos];
		Integer[] rest_merge = new Integer[pos + rest.length];
		copyAllElementsFromPosToLen(local, current, pos, current.length, 0);
		copyAllElementsFromPosToLen(rest_merge, rest, 0, rest.length, 0);
		copyAllElementsFromPosToLen(rest_merge, current, 0, pos, rest.length);
		boolean end = false;
		int depth = 0;
		while (!end && depth < local.length) {
			end = permutate(local, rest_merge, v2, 1);
			shiftByOne(local, 0);
			int value = multiply(getMainMatrix(rest_merge, local), v2);
			if (leastValue > value) {
				leastValue = value;
			}
			depth++;
		}

		return false;
	}

	private void copyAllElementsFromPosToLen(Integer[] v, Integer[] current,
			int pos, int len, int from) {
		for (int i = pos, k = from; i < len; i++, k++) {
			v[k] = current[i];
		}
	}

	private Integer[] getMainMatrix(Integer[] main, Integer[] current) {
		Integer[] combination = new Integer[main.length + current.length];
		int k = 0;
		for (int i = 0; i < main.length; i++) {
			combination[k] = main[i];
			k++;
		}
		for (int i = 0; i < current.length; i++) {
			combination[k] = current[i];
			k++;
		}
		return combination;
	}

	private void print(Integer[] main, Integer[] current) {
		System.out.println("**********************");
		for (int i = 0; i < main.length; i++) {
			System.out.print(main[i] + " ");
		}
		for (int i = 0; i < current.length; i++) {
			System.out.print(current[i] + " ");
		}
		System.out.println("");
	}

	void shiftByOne(Integer[] current, int pos) {
		int tmp = current[pos];
		int i = pos + 1;
		for (; i < current.length; i++) {
			current[i - 1] = current[i];
		}
		current[i - 1] = tmp;
	}

	int multiply(Integer[] v1, Integer[] v2) throws Exception {
		int value = 0;
		if (v1.length != v2.length) {
			throw new Exception("Cannot execute this program!!");
		}
		for (int i = 0; i < v1.length; i++) {
			value = value + (v1[i] * v2[i]);
		}
		return value;
	}

	public static void main(String[] args) {

		try {
			MinimumScalarProduct p = new MinimumScalarProduct();
			Integer[] valuesA = { 1, 2, 3, 4, 5 };
			Integer[] valuesB = { 1, 0, 1, 0, 1 };
			p.permutate(valuesA, new Integer[0], valuesB, 0);
			System.out.println(p.leastValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
