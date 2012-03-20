package com.weird.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MovingPiling {

	Map<Integer, ArrayList<Integer>> blocks;

	MovingPiling(int size) {
		blocks = new HashMap<Integer, ArrayList<Integer>>();
	}

	private void initialize(int size) {
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			blocks.put(i, list);
		}

	}

	void moveAontoB(int a, int b) {
		Index a_i = getIndexOf(a);
		Index b_i = getIndexOf(b);
		if (a_i.row != b_i.row) {
			ArrayList<Integer> allblocksAboveA = allBlocksAbove(a_i);
			ArrayList<Integer> allblocksAboveB = allBlocksAbove(b_i);
			rearrangeToOriginalPositions(allblocksAboveA);
			rearrangeToOriginalPositions(allblocksAboveB);
			moveAtoB(a, b, a_i, b_i);
		}

	}

	void moveAoverB(int a, int b) {
		Index a_i = getIndexOf(a);
		Index b_i = getIndexOf(b);
		if (a_i.row != b_i.row) {
			ArrayList<Integer> allblocksAboveA = allBlocksAbove(a_i);
			rearrangeToOriginalPositions(allblocksAboveA);
			moveAtoB(a, b, a_i, b_i);
		}

	}

	void pileAontoB(int a, int b) {
		Index a_i = getIndexOf(a);
		Index b_i = getIndexOf(b);
		if (a_i.row != b_i.row) {
			ArrayList<Integer> allblocksAboveA = allBlocksAbove(a_i);
			ArrayList<Integer> allblocksAboveB = allBlocksAbove(b_i);
			rearrangeToOriginalPositions(allblocksAboveB);
			movePileAtoB(a, allblocksAboveA, b, a_i, b_i);
		}

	}

	void pileAoverB(int a, int b) {
		Index a_i = getIndexOf(a);
		Index b_i = getIndexOf(b);
		if (a_i.row != b_i.row) {
			ArrayList<Integer> allblocksAboveA = allBlocksAbove(a_i);
			movePileAtoB(a, allblocksAboveA, b, a_i, b_i);
		}

	}

	private void movePileAtoB(int a, ArrayList<Integer> allblocksAboveA, int b,
			Index a_i, Index b_i) {
		ArrayList<Integer> list = blocks.get(b_i.row);
		list.add(a);
		for (Integer i : allblocksAboveA) {
			list.add(i);
		}
		list = blocks.get(a_i.row);
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			if (iter.next() == a) {
				iter.remove();
			}
		}
	}

	private void moveAtoB(int a, int b, Index a_i, Index b_i) {
		ArrayList<Integer> list = blocks.get(b_i.row);
		list.add(a);
		list = blocks.get(a_i.row);
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			if (iter.next() == a) {
				iter.remove();
			}
		}
	}

	private void readBlocks() {
		for (Integer blockNum : blocks.keySet()) {
			System.out.print(blockNum + " : ");
			ArrayList<Integer> stack = blocks.get(blockNum);
			for (Integer stackValue : stack) {
				System.out.print(stackValue + " ");
			}
			System.out.println();
		}
	}

	private void rearrangeToOriginalPositions(ArrayList<Integer> allblocksAboveA) {
		for (Integer row : allblocksAboveA) {
			ArrayList<Integer> list = blocks.get(row);
			list.add(row);
		}
	}

	private ArrayList<Integer> allBlocksAbove(Index a_i) {
		ArrayList<Integer> list = blocks.get(a_i.row);
		if (list.size() == 0) {
			return new ArrayList<Integer>();
		}
		if (a_i.column == (list.size() - 1)) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> block = new ArrayList<Integer>(list.subList(
				(a_i.column + 1), list.size()));
		list.removeAll(block);
		return block;
	}

	private Index getIndexOf(int a) {
		for (Integer blockNum : blocks.keySet()) {
			ArrayList<Integer> stack = blocks.get(blockNum);
			int counter = 0;
			for (Integer stackValue : stack) {
				if (stackValue == a) {
					Index index = new Index();
					index.column = counter;
					index.row = blockNum;
					return index;
				}
				counter = counter + 1;
			}
		}
		return null;
	}

	class Index {
		int row;
		int column;
	}

	public void getCommands() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("inputs/Input.txt"));
			String pileSize = br.readLine();
			int size = getInt(pileSize);
			initialize(size);
			String str;
			while ((str = br.readLine()) != null) {
				String[] tokens = str.split(" ");
				if (tokens[0] != null && tokens[0].equals("move")) {
					if (tokens[2] != null && tokens[2].equals("onto")) {
						int a = getInt(tokens[1]);
						int b = getInt(tokens[3]);
						if (a != -1 && b != -1) {
							moveAontoB(a, b);
						}
					} else if (tokens[2] != null && tokens[2].equals("over")) {
						int a = getInt(tokens[1]);
						int b = getInt(tokens[3]);
						if (a != -1 && b != -1) {
							moveAoverB(a, b);
						}
					}
				}
				if (tokens[0] != null && tokens[0].equals("pile")) {
					if (tokens[2] != null && tokens[2].equals("onto")) {
						int a = getInt(tokens[1]);
						int b = getInt(tokens[3]);
						if (a != -1 && b != -1) {
							pileAontoB(a, b);
						}
					} else if (tokens[2] != null && tokens[2].equals("over")) {
						int a = getInt(tokens[1]);
						int b = getInt(tokens[3]);
						if (a != -1 && b != -1) {
							pileAoverB(a, b);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getInt(String strValue) {
		if (strValue != null && !strValue.isEmpty()) {
			return Integer.parseInt(strValue);
		}
		return -1;
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		MovingPiling pile = new MovingPiling(10);
		pile.getCommands();
		pile.readBlocks();
		long end = System.currentTimeMillis();
		System.out.println("Time taken " + (end - start) + " ms");
	}
}
