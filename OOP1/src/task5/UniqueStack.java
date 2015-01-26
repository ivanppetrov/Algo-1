package task5;

import task4.StackImpl;

public class UniqueStack extends StackImpl {

	public UniqueStack(int size) {
		super(size);
	}
	
	@Override
	public void push(Object element) {
		if (!isExists(element)) {
			super.push(element);
		} else {
			System.out.printf("\'%s\' already exists in the stack\n", element);
		}
	}
	
	private boolean isExists(Object element) {
		Object[] elements = getElements();
		for (int i = 0; i < size(); i++) {
			if (elements[i] == element){
				return true;
			}
		}
		
		return false;
	}
}
