/**
 * Copyright 2012
 * VAN
 */
package vaidyaa.games.sudoku;

import vaidyaa.games.sudoku.model.SudokuElement;
import junit.framework.TestCase;

/**
 * @author vaidyaa
 *
 */
public class SudokuElementTest extends TestCase {

	public void testGetNumber() {
		SudokuElement element = new SudokuElement();
		element.unsetAll();
		element.setFive(true);
		element.setSix(true);
		element.setNine(true);
		int val = element.getNumber();
		System.out.println(val);
	}
}
