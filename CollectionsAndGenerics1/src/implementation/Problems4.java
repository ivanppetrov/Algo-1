package implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> rotate(Collection<T> collection, int rotateStep) {
		
		if (rotateStep > 0) {
			for (int i = 0; i < rotateStep; i++) {
				collection = setLastFirst(collection);
			}
		} else {
			for (int i = rotateStep; i < 0; i++) {
				collection = setFirstLast(collection);
			}
		}
		
		return collection;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> Collection setLastFirst(Collection<T> list) {
		int size = list.size();
		Collection rotatedList = new ArrayList<T>();
		T[] array = (T[]) list.toArray();
		rotatedList.add(array[size - 1]);
		for (int i = 0; i < size - 1 ; i++) {
			rotatedList.add(array[i]);
		}
		
		return rotatedList;
	}
	
	@SuppressWarnings("unchecked")
	private static <T> Collection<T> setFirstLast(Collection<T> list) {
		int size = list.size();
		Collection<T> rotatedList = new ArrayList<T>();
		T[] array = (T[]) list.toArray();
		for (int i = 1; i < size; i++) {
			rotatedList.add(array[i]);
		}
		rotatedList.add(array[0]);
		
		return rotatedList;
	}
	//End task4
	
	//Start task5
	public static int findUnique(Collection<Integer> collection) {
		Collections.sort((List<Integer>)collection);
		List<Integer> list = new ArrayList<Integer>(collection);
		int serchedElement = collection.iterator().next();
		List<Integer> subList = list.subList(1, list.size());
		
		if (subList.contains(serchedElement)) {
			return findUnique(subList.subList(subList.lastIndexOf(serchedElement) + 1, subList.size()));
		} else {
			return serchedElement;
		}
	}
	//End task5
	
	//Start task6
	public static <T> Set<T> findIntersSection(Set<T>... sets) {
		Set<T> result = sets[0];
		
		for (int i = 1; i < sets.length; i++) {
			result = intersection(result, sets[i]);
		}
		
		
		return result;
	}
	
	private static <T> Set<T> intersection(Set<T> first, Set<T> second) {
		Set<T> result = new HashSet<T>();
		
		for (T t : first) {
			if (second.contains(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
	//End task6
}
