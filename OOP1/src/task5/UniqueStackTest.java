package task5;

import task4.Stack;

public class UniqueStackTest {

	public static void main(String[] args) {
		Stack stack = new UniqueStack(4);
		
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.printElements(stack);
	}

}
