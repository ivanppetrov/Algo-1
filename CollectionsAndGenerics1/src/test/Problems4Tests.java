package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import implementation.BoundedQueue;
import implementation.Problems4;
import implementation.Student;

import org.junit.Test;
import org.w3c.dom.ls.LSInput;

public class Problems4Tests {
	private final Problems4 problems4 = new Problems4();
	
	@Test
	public void testCheckStack() {
//		assertTrue(problems4.checkBrackets("()()()"));
//		assertTrue(problems4.checkBrackets("(())()()"));
//		assertFalse(problems4.checkBrackets("())("));
//		
//		Collection<Object> collection = new ArrayList<Object>();
//		collection.add("");
//		collection.add(1);
//		collection.add("2");
//		assertEquals(0, problems4.addRemoveElement(collection, null));
//		assertEquals(1, problems4.addRemoveElement(collection, 1));
//		assertEquals(2, problems4.addRemoveElement(collection, 2));
//		
//		BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(3);
//		assertTrue(boundedQueue.offer(1));
//		assertTrue(boundedQueue.offer(2));
//		assertTrue(boundedQueue.offer(3));
//		assertFalse(boundedQueue.offer(4));
//		assertFalse(boundedQueue.offer(5));
//		System.out.println(boundedQueue.toString());
//		
//		//Test task4
//		Collection<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		
//		System.out.println(Problems4.rotate(list, 2));
//		System.out.println(Problems4.rotate(list, -2));
//		
//		//test task5
//		System.out.println(Problems4.findUnique(Arrays.asList(1,1,2,3,3,2,11,11,2,12,3123,12312,3,123,123,12312312,112)));
//		
//		//Test task6
//		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6));
//		Set<Integer> b = new HashSet<Integer>(Arrays.asList(4,5,6));
//		Set<Integer> c = new HashSet<Integer>(Arrays.asList(5,6,7,8));
//
//		System.out.println(Problems4.findIntersSection(a, b, c));
		
		//Test task7
		Student s1 = new Student("Ivan", 6);
		Student s2 = new Student("Vesi", 6);
		Student s3 = new Student("Pesho", 3);
		
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		problems4.sort(students);
		
		System.out.println(students.toString());
	}
}
