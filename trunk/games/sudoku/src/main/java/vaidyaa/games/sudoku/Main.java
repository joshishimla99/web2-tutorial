/**
 * Copyright 2012
 * VAN
 */
package vaidyaa.games.sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import vaidyaa.games.sudoku.model.SudokuElement;

/**
 * @author vaidyaa
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] inputMatrix = new int[][] { 
				{ 7, 8, 0, 0, 0, 0, 0, 5, 6 },
				{ 0, 0, 9, 0, 8, 0, 1, 0, 0 }, 
				{ 0, 4, 6, 0, 0, 0, 0, 7, 0 },
				{ 6, 5, 0, 0, 0, 4, 7, 9, 2 }, 
				{ 0, 0, 0, 9, 0, 1, 0, 0, 0 },
				{ 3, 9, 7, 6, 0, 0, 0, 1, 8 }, 
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 },
				{ 0, 0, 5, 0, 4, 0, 6, 0, 0 }, 
				{ 2, 1, 0, 0, 0, 0, 0, 4, 5 } };
		
		SudokuElement[][] sudokuMatrix = new SudokuElement[9][9];
		initializeSudokuMatrix(sudokuMatrix);
		eliminateNumbersFromRowAndColumn(inputMatrix, sudokuMatrix);
		boolean isSomethingChanged = true;
		while (isSomethingChanged == true) {
			isSomethingChanged = eliminateNumbersFromRowAndColumn(sudokuMatrix);
			isSomethingChanged = eliminateNumbersFromSubMatrix(sudokuMatrix) ? true
					: isSomethingChanged;
		}
		isSomethingChanged = true;
		//printDebugMatrix(sudokuMatrix);
		while (isSomethingChanged == true) {
			for (int i = 0; i < 9; i++) {
				isSomethingChanged = findSingletonInRow(i, sudokuMatrix);
				isSomethingChanged = findSingletonInCol(i, sudokuMatrix) ? true
						: isSomethingChanged;
				//printDebugMatrix(sudokuMatrix);
				isSomethingChanged = eliminateNumbersFromRowAndColumn(sudokuMatrix) ? true
						: isSomethingChanged;
				//printDebugMatrix(sudokuMatrix);
				isSomethingChanged = eliminateNumbersFromSubMatrix(sudokuMatrix) ? true
						: isSomethingChanged;
				
			}
			isSomethingChanged = false;
		}
		printMatrix(sudokuMatrix);
		printDebugMatrix(sudokuMatrix);
	}

	private static void initializeSudokuMatrix(SudokuElement[][] matrix) {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				matrix[x][y] = new SudokuElement();
			}
		}
	}

	private static boolean eliminateNumbersFromRowAndColumn(
			int[][] inputMatrix, SudokuElement[][] sudokuMatrix) {
		boolean isChanged = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int inputValue = inputMatrix[i][j];
				isChanged = eliminateNumbersFromRowAndColumn(i, j, inputValue,
						sudokuMatrix) ? true : isChanged;
			}
		}
		return isChanged;
	}

	private static boolean eliminateNumbersFromRowAndColumn(
			SudokuElement[][] sudokuMatrix) {
		boolean isChanged = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int inputValue = sudokuMatrix[i][j].getNumber();
				isChanged = eliminateNumbersFromRowAndColumn(i, j, inputValue,
						sudokuMatrix) ? true : isChanged;
			}
		}
		return isChanged;
	}

	private static boolean eliminateNumbersFromRowAndColumn(int row_pos,
			int col_pos, int value, SudokuElement[][] matrix) {
		boolean isChanged = false;
		if (value != 0) {
			for (int k = 0; k < 9; k++) {
				SudokuElement element = matrix[k][col_pos];
				if (k == row_pos) {
					String olderState = element.toString();
					element.setElement(value);
					if (!olderState.equals(element.toString())) {
						isChanged = true;
					}
				} else {
					String olderState = element.toString();
					element.removeProbableElement(value);
					if (!olderState.equals(element.toString())) {
						isChanged = true;
					}
				}
			}
			for (int k = 0; k < 9; k++) {
				SudokuElement element = matrix[row_pos][k];
				if (k == col_pos) {
					String olderState = element.toString();
					element.setElement(value);
					if (!olderState.equals(element.toString())) {
						isChanged = true;
					}
				} else {
					String olderState = element.toString();
					element.removeProbableElement(value);
					if (!olderState.equals(element.toString())) {
						isChanged = true;
					}
				}
			}
		}
		return isChanged;
	}

	private static boolean eliminateNumbersFromSubMatrix(
			SudokuElement[][] sudokuMatrix) {
		boolean isChanged = false;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				isChanged = removeProbableElementFromSubmatix(3 * x, 3 * y,
						sudokuMatrix) ? true : isChanged;
			}
		}
		return isChanged;
	}

	private static boolean removeProbableElementFromSubmatix(int x_pos,
			int y_pos, SudokuElement[][] matrix) {
		boolean isChanged = false;
		for (int x = x_pos; x < 3 + x_pos; x++) {
			for (int y = y_pos; y < 3 + y_pos; y++) {
				SudokuElement element = matrix[x][y];
				int val = element.getNumber();
				if (val != 0) {
					for (int i = x_pos; i < 3 + x_pos; i++) {
						for (int j = y_pos; j < 3 + y_pos; j++) {
							if (i != x || j != y) {
								SudokuElement temp = matrix[i][j];
								String olderState = temp.toString();
								temp.removeProbableElement(val);
								if (!olderState.equals(temp.toString())) {
									isChanged = true;
								}
							}
						}
					}
				}
			}
		}
		return isChanged;
	}

	private static boolean findSingletonInRow(int row, SudokuElement[][] matrix) {
		boolean isSomethingChanged = false;
		List<Integer> list = new ArrayList<Integer>();
		for (int y = 0; y < 9; y++) {
			SudokuElement element = matrix[row][y];
			if (element.getNumber() == 0) {
				list.addAll(element.getProbables());
			}
		}
		Map<Integer, Integer> resultMap = getNumberStatistics(list);
		for (Entry<Integer, Integer> entry : resultMap.entrySet()) {
			Integer key = entry.getKey();
			Integer freq = entry.getValue();
			if (freq.equals(1)) {
				for (int i = 0; i < 9; i++) {
					SudokuElement element = matrix[row][i];
					if (element.getProbables().contains(key)) {
						//System.out.println("Key_ROW=>"+key+",X=>"+row+",Y=>"+i);
						element.setElement(key);
						isSomethingChanged = true;
						while(isSomethingChanged) {
							isSomethingChanged = eliminateNumbersFromRowAndColumn(matrix);							
						}
					}
				}
			}
		}
		return isSomethingChanged;
	}

	private static boolean findSingletonInCol(int col, SudokuElement[][] matrix) {
		boolean isSomethingChanged = false;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			SudokuElement element = matrix[i][col];
			if (element.getNumber() == 0) {
				list.addAll(element.getProbables());
			}
		}
		Map<Integer, Integer> resultMap = getNumberStatistics(list);
		for (Entry<Integer, Integer> entry : resultMap.entrySet()) {
			Integer key = entry.getKey();
			Integer freq = entry.getValue();
			if (freq.equals(1)) {
				for (int j = 0; j < 9; j++) {
					SudokuElement element = matrix[j][col];
					if (element.getProbables().contains(key)) {
						//System.out.println("Key_COL=>"+key+",X=>"+j+",Y=>"+col);
						element.setElement(key);
						isSomethingChanged = true;
						while(isSomethingChanged) {
							isSomethingChanged = eliminateNumbersFromRowAndColumn(matrix);
						}
					}
				}
			}
		}
		return isSomethingChanged;
	}

	private static Map<Integer, Integer> getNumberStatistics(List<Integer> list) {
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		for (Integer i : list) {
			if (resultMap.containsKey(i)) {
				Integer stat = resultMap.get(i);
				stat++;
				resultMap.put(i, stat);
			} else {
				resultMap.put(i, Integer.valueOf(1));
			}
		}
		return resultMap;
	}

	private static void printDebugMatrix(SudokuElement[][] array) {
		System.out.println("+++");
		for (int x = 0; x < 9; x++) {
			StringBuffer buffer = new StringBuffer();
			for (int y = 0; y < 9; y++) {
				SudokuElement element = array[x][y];
				buffer.append("," + element.toDebugString());
			}
			System.out.println(buffer.toString().replaceFirst(",", ""));
		}
		System.out.println("+++");
	}
	
	private static void printMatrix(SudokuElement[][] array) {
		System.out.println("+++");
		for (int x = 0; x < 9; x++) {
			StringBuffer buffer = new StringBuffer();
			for (int y = 0; y < 9; y++) {
				SudokuElement element = array[x][y];
				buffer.append("," + element.toString());
			}
			System.out.println(buffer.toString().replaceFirst(",", ""));
		}
		System.out.println("+++");
	}

}
