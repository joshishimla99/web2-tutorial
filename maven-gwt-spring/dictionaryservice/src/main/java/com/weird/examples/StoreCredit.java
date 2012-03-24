package com.weird.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class StoreCredit {

	static class Items {
		Integer[] item_prices;

		void setItems(Integer[] list) {
			this.item_prices = list;
		}

		Integer[] getNumbersFromSum(int sum) {
			Integer[] positions = new Integer[2];
			for (int i = 0; i < item_prices.length; i++) {
				int required = (sum - item_prices[i]);
				int requiredIndex = getIndex(item_prices, required, i);
				if (requiredIndex != -1) {
					positions[0] = i; 
					positions[1] = requiredIndex;
					return positions;
				}
			}
			return positions;
		}
		
//		Integer[] getNumbersFromSumWithMergeSort(int sum) {
//			Integer[] positions = new Integer[2];
//			MergeSort sort = new MergeSort();
//			sort.merge_sort(item_prices, 0, item_prices.length - 1);
//			int left = 0;
//			int right = item_prices.length - 1;
//			while (left <= right) {
//				if (sum < (item_prices[right] + item_prices[left])) {
//					right--;
//				}
//				else if (sum > (item_prices[right] + item_prices[left])) {
//					left++;
//				}
//				else {
//					break;
//				}
//			}
//			positions[0] = left;
//			positions[1] = right;
//			return positions;
//		}		

		private int getIndex(Integer[] item_prices2, int required, int previous) {
			for (int i = 0; i < item_prices2.length; i++) {
				if (item_prices2[i] == required && i != previous) {
					return i;
				}
			}
			return -1;
		}

		void getItems() {
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						"inputs/InputStoreCredit.txt"));
				String testcases = br.readLine();
				int total_test_cases = getInt(testcases);
				int no_of_test_cases = 0;
				String str = null;
				while (no_of_test_cases < total_test_cases
						&& ((str = br.readLine()) != null)) {
					Integer[] indexes = operateTestCases(str, br);
					no_of_test_cases++;
					System.out.println("Case #" + no_of_test_cases + ": "
							+ (indexes[0] + 1) + " " + (indexes[1] + 1));
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Integer[] operateTestCases(String str, BufferedReader br)
				throws IOException {
			int sumRequired = getInt(str.trim());
			br.readLine().trim();
			String[] tokens = br.readLine().split(" ");
			Integer[] prices = getPriceValues(tokens);
			setItems(prices);
			return getNumbersFromSum(sumRequired);
		}

		private Integer[] getPriceValues(String[] tokens) {
			Integer[] prices = new Integer[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				prices[i] = getInt(tokens[i]);
			}
			return prices;
		}

		private int getInt(String strValue) {
			if (strValue != null && !strValue.isEmpty()) {
				return Integer.parseInt(strValue);
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		Items i = new Items();
		i.getItems();
	}
}
