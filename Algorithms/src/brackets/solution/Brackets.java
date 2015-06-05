package brackets.solution;

import java.util.Stack;

public class Brackets {
	private static int getType(char character) {
		int charValue = 0;
		switch (character) {
		case '{': charValue = 3; break;
		case '}': charValue = -3; break;
		case '[': charValue = 2; break;
		case ']': charValue = -2; break;
		case '(': charValue = 1; break;
		case ')': charValue = -1; break;
		default: charValue = 0; break;
		}
		
		return charValue;
	}
	
	private static boolean checkBrakets(String expression) {
		Stack<Character> container = new Stack<Character>();
		boolean firstChar = true;
		for (int i = 0; i < expression.length(); i++) {
			char currentChar= expression.charAt(i);
			
			if (getType(currentChar) == 0 && firstChar == false) {
				continue;
			} else if (firstChar && getType(currentChar) > 0) {
				container.add(currentChar);
				firstChar = false;
			} else if (!container.empty() && getType(container.peek()) + getType(currentChar) == 0) {
				container.pop();
			} else if (!container.empty() && getType(container.peek()) - getType(currentChar) == 1 ){
				container.add(currentChar);
			} else if (container.empty() && firstChar == false) {
				return false;
			} else {
				break;
			}
		}
		return container.empty() && firstChar == false;
	}
	
	private static int doCalculation(String expression) {
		String temp = "";
		int sum = 0;
		int multiplier = 1;
		for (int i = expression.length() - 1; i >= 0; i--) {
			int charType = getType(expression.charAt(i));
			if (charType == 0) {
				temp = expression.charAt(i) + temp;
			} else if (charType < 0) {
				if (!temp.isEmpty()) {
					sum += multiplier * Integer.parseInt(temp);
					temp = "";
				}
				multiplier *= 2;
			} else {
				if (!temp.isEmpty()) {
					sum += multiplier * Integer.parseInt(temp);
					temp = "";
				} 
				
				multiplier /= 2;
			}
		}
		
		if (!temp.isEmpty()) {
			sum += Integer.parseInt(temp);
		}
		
		return sum;
	}
	
	public static String calculate(String expression) {
		if (checkBrakets(expression)) {
			return doCalculation(expression.substring(1, expression.length() - 1)) + "";
		} else {
			return "NO";
		}
	}
}
