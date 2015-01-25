package implementation;

import java.util.Collection;
import java.util.Stack;

public class Problems4 {
	
	//Start task0
	public boolean checkBrackets(String brackets) {
		char[] bracketsArray = brackets.toCharArray();
		Stack<Character> result = new Stack<Character>();
		int opening = 0;
		
		for (int i = 0; i < bracketsArray.length; i++) {
			if (result.empty()) {
				if (bracketsArray[i] == ')') {
					return false;
				} else {
					result.add(bracketsArray[i]);
					opening++;
				}
			} else {
				if (result.peek() == '(' && bracketsArray[i] == ')') {
					result.pop();
					opening--;
				} else {
					if (bracketsArray[i] == '(') {
						result.add(bracketsArray[i]);
						opening++;
					} else {
						return false;
					}
				}
			}
		}
		
		if (result.empty() && opening == 0) {
			return true;
		} else {
			return false;
		}
	}
	//End task0
	
	//Start task1
	public <T> Collection<T> reverse(Collection<T> collection) {
		Object temp = null;
		Object[] array = collection.toArray();
		int size = collection.size() - 1;
		
		for (int i = 0; i < size / 2; i++) {
			temp = array[i];
			array[i] = array[size -  i];
			array[size - 1] = temp;
		}
		
		return collection;
	}
	//End task1
	
	//Start task2
	//0 - trying to add null, 1 - remove element, 2 - add element
	public int addRemoveElement(Collection<Object> collection, Object element) {
		int result = 0;
		
		if (element != null) {
			if (collection.contains(element)) {
				collection.remove(element);
				result = 1;
			} else {
				collection.add(element);
				result = 2;
			}
		}
		
		return result;
	}
	//End task2
	
	//Start task4
	public static <T> void rotate(Collection<T> collection, int rotateStep) {
		if (rotateStep < 0) {
			
		}
	}
}
