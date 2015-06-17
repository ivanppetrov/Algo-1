package task4.solutions;

import java.util.ArrayList;
import java.util.List;

import task0.solutions.BinarySearch;

public class PhoneBook {
	public static List<String> lookupNames(List<Contact> phoneBook, List<Integer> numbers) {
		List<String> result = new ArrayList<String>();
		int[] phoneBookNumbers = new int[phoneBook.size()];
		int index = 0;
		
		for (Contact contac : phoneBook) {
			phoneBookNumbers[index++] = contac.getNumber();
		}
		 
		for (Integer number : numbers) {
			int position = BinarySearch.binarySearch(phoneBookNumbers, number, 0, phoneBookNumbers.length - 1);
			
			if (position > 0) {
				result.add(phoneBook.get(position).getName());
			}
		}
		
		return result;
	}
}