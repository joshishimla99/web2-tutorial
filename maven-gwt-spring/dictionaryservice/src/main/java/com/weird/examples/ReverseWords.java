package com.weird.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReverseWords {

	void getReverseWords() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"inputs/InputReverseWords.txt"));
			String noOfTestCases = br.readLine();
			int cases = getInt(noOfTestCases);
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null && i < cases) {
				String output = getLineInverter(line);
				i++;
				System.out.println("Case #" + i + ": " + output);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getLineInverter(String line) {
		String message = "";
		String word = "";
		for (int i = 0 ; i < line.length() ; i++) {
			if (line.charAt(i) == ' ') {
				message = word + " " + message;
				word = "";
			}
			else {
				word = word + "" + line.charAt(i);	
			}
		}
		message = word + " " + message;
		return message;
	}

	private int getInt(String strValue) {
		if (strValue != null && !strValue.isEmpty()) {
			return Integer.parseInt(strValue);
		}
		return -1;
	}

	public static void main(String[] args) {
		ReverseWords reverseWords = new ReverseWords();
		reverseWords.getReverseWords();
	}
}
