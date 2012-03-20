package com.weird.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MobileMessage {

	Map<Character, String> numberSequences;
	
	MobileMessage() {
		numberSequences = new HashMap<Character, String>();
		numberSequences.put(' ', "0");
		char start = 'a';
		for (int i = 2 ; i <= 9 ; i ++ ) {
			if ( i == 7 || i == 9) {
				start = getSequence(start, i, 4);
			}
			else {
				start = getSequence(start, i, 3);
			}
		}
	}

	private char getSequence(char start, int mobileNumber, int maxNoOfHits) {
		String mobileNumberStr = "";
		for (int  i = 1 ; i<= maxNoOfHits ; i++ ) {
			mobileNumberStr = mobileNumberStr + "" + mobileNumber;
			numberSequences.put(start, mobileNumberStr);
			start = (char)((int) start + 1);
		}
		return start;
	}
	
	void print () {
		for (Character c : numberSequences.keySet()) {
			System.out.println(c + " : " + numberSequences.get(c));
		}
	}
	
	void getMobileMessages() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"inputs/InputMobileMessage.txt"));
			String noOfTestCases = br.readLine();
			int cases = getInt(noOfTestCases);
			String line = null;
			int i = 0 ;
			while ((line = br.readLine()) != null && i < cases) {
				String output = getMessage(line);
				i++;
				System.out.println("Case #" + i + ": " + output);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private String getMessage(String readLine) {
		if (readLine.isEmpty()) {
			return "";
		}
		String message = "";
		ArrayList<Character> chars = getCharacters(readLine);
		message = message + getMobileMessage(chars);
		return message;
	}

	private String getMobileMessage(ArrayList<Character> chars) {
		String message = "";
		char previous = ' ';
		for (int i = 0 ;  i < chars.size() ; i++) {
			char seq = numberSequences.get(chars.get(i)).charAt(0);
			if (previous == seq ) {
				message = message + " ";
			}
			message = message + numberSequences.get(chars.get(i));
			previous = numberSequences.get(chars.get(i)).charAt(0);
		}
		return message;
	}

	private ArrayList<Character> getCharacters(String word) {
		ArrayList<Character> list = new ArrayList<Character>();
		int i = 0;
		while ( i < word.length()) {
			char c = word.charAt(i);
			list.add(c);
			i ++;
		}
		return list;
	}

	private int getInt(String strValue) {
		if (strValue != null && !strValue.isEmpty()) {
			return Integer.parseInt(strValue);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		MobileMessage msg = new MobileMessage();
		msg.getMobileMessages();
	}
}
