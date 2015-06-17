package task4.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import task4.solutions.Contact;
import task4.solutions.PhoneBook;

public class ContactTests {
	static List<Contact> phoneBook;
	static List<Integer> numbers;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		phoneBook = new ArrayList<Contact>();
		numbers = new ArrayList<Integer>();
		
		Contact contact;
		
		int number= 0;
		for (int i = 0; i < 10; i++) {
			contact = new Contact(String.valueOf(i), i);
			phoneBook.add(contact);
			
			numbers.add(number+=2);
		}
	}

	@Test
	public void test() {
		List<String> names = PhoneBook.lookupNames(phoneBook, numbers);
		
		for (String name : names) {
			System.out.println(name);
		}
		
		assertArrayEquals(new String[]{"2", "4", "6", "8"}, names.toArray());
	}

}
