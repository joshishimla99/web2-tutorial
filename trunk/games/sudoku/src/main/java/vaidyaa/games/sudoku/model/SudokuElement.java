/**
 * Copyright 2012
 * VAN
 */
package vaidyaa.games.sudoku.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vaidyaa
 * 
 */
public class SudokuElement {

	private boolean one = true;
	private boolean two = true;
	private boolean three = true;
	private boolean four = true;
	private boolean five = true;
	private boolean six = true;
	private boolean seven = true;
	private boolean eight = true;
	private boolean nine = true;

	public void setAll() {
		this.one = true;
		this.two = true;
		this.three = true;
		this.four = true;
		this.five = true;
		this.six = true;
		this.seven = true;
		this.eight = true;
		this.nine = true;
	}

	public void unsetAll() {
		this.one = false;
		this.two = false;
		this.three = false;
		this.four = false;
		this.five = false;
		this.six = false;
		this.seven = false;
		this.eight = false;
		this.nine = false;
	}

	public void setElement(int val) {
		if (val > 0 || val < 10) {
			unsetAll();
			if (val == 1) {
				setOne(true);
			}
			if (val == 2) {
				setTwo(true);
			}
			if (val == 3) {
				setThree(true);
			}
			if (val == 4) {
				setFour(true);
			}
			if (val == 5) {
				setFive(true);
			}
			if (val == 6) {
				setSix(true);
			}
			if (val == 7) {
				setSeven(true);
			}
			if (val == 8) {
				setEight(true);
			}
			if (val == 9) {
				setNine(true);
			}
		}
	}

	public void removeProbableElement(int val) {
		if (val > 0 || val < 10) {
			if (val == 1) {
				setOne(false);
			}
			if (val == 2) {
				setTwo(false);
			}
			if (val == 3) {
				setThree(false);
			}
			if (val == 4) {
				setFour(false);
			}
			if (val == 5) {
				setFive(false);
			}
			if (val == 6) {
				setSix(false);
			}
			if (val == 7) {
				setSeven(false);
			}
			if (val == 8) {
				setEight(false);
			}
			if (val == 9) {
				setNine(false);
			}
		}
	}

	public int getNumber() {
		int number = 0;
		if (one) {
			if (number != 0) {
				return 0;
			} else {
				number = 1;
			}
		}
		if (two) {
			if (number != 0) {
				return 0;
			} else {
				number = 2;
			}
		}
		if (three) {
			if (number != 0) {
				return 0;
			} else {
				number = 3;
			}
		}
		if (four) {
			if (number != 0) {
				return 0;
			} else {
				number = 4;
			}
		}
		if (five) {
			if (number != 0) {
				return 0;
			} else {
				number = 5;
			}
		}
		if (six) {
			if (number != 0) {
				return 0;
			} else {
				number = 6;
			}
		}
		if (seven) {
			if (number != 0) {
				return 0;
			} else {
				number = 7;
			}
		}
		if (eight) {
			if (number != 0) {
				return 0;
			} else {
				number = 8;
			}
		}
		if (nine) {
			if (number != 0) {
				return 0;
			} else {
				number = 9;
			}
		}
		return number;
	}

	public List<Integer> getProbables() {
		List<Integer> result = new ArrayList<Integer>();
		if (one) {
			result.add(1);
		}
		if (two) {
			result.add(2);
		}
		if (three) {
			result.add(3);
		}
		if (four) {
			result.add(4);
		}
		if (five) {
			result.add(5);
		}
		if (six) {
			result.add(6);
		}
		if (seven) {
			result.add(7);
		}
		if (eight) {
			result.add(8);
		}
		if (nine) {
			result.add(9);
		}
		return result;
	}
	
	public String toDebugString() {
		StringBuffer buffer = new StringBuffer();
		if (one) {
			buffer.append("1");
		} else {
			buffer.append("0");
		}
		if (two) {
			buffer.append("2");
		} else {
			buffer.append("0");
		}
		if (three) {
			buffer.append("3");
		} else {
			buffer.append("0");
		}
		if (four) {
			buffer.append("4");
		} else {
			buffer.append("0");
		}
		if (five) {
			buffer.append("5");
		} else {
			buffer.append("0");
		}
		if (six) {
			buffer.append("6");
		} else {
			buffer.append("0");
		}
		if (seven) {
			buffer.append("7");
		} else {
			buffer.append("0");
		}
		if (eight) {
			buffer.append("8");
		} else {
			buffer.append("0");
		}
		if (nine) {
			buffer.append("9");
		} else {
			buffer.append("0");
		}
		return buffer.toString();
	}
	
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (one) {
			buffer.append("1");
		}
		else if (two) {
			buffer.append("2");
		}
		else if (three) {
			buffer.append("3");
		}
		else if (four) {
			buffer.append("4");
		}
		else if (five) {
			buffer.append("5");
		}
		else if (six) {
			buffer.append("6");
		}
		else if (seven) {
			buffer.append("7");
		}
		else if (eight) {
			buffer.append("8");
		}
		else if (nine) {
			buffer.append("9");
		}
		else {
			buffer.append("X");
		}
		return buffer.toString();
	}

	public boolean isOne() {
		return one;
	}

	public void setOne(boolean one) {
		this.one = one;
	}

	public boolean isTwo() {
		return two;
	}

	public void setTwo(boolean two) {
		this.two = two;
	}

	public boolean isThree() {
		return three;
	}

	public void setThree(boolean three) {
		this.three = three;
	}

	public boolean isFour() {
		return four;
	}

	public void setFour(boolean four) {
		this.four = four;
	}

	public boolean isFive() {
		return five;
	}

	public void setFive(boolean five) {
		this.five = five;
	}

	public boolean isSix() {
		return six;
	}

	public void setSix(boolean six) {
		this.six = six;
	}

	public boolean isSeven() {
		return seven;
	}

	public void setSeven(boolean seven) {
		this.seven = seven;
	}

	public boolean isEight() {
		return eight;
	}

	public void setEight(boolean eight) {
		this.eight = eight;
	}

	public boolean isNine() {
		return nine;
	}

	public void setNine(boolean nine) {
		this.nine = nine;
	}

}
