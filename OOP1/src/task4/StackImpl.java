package task4;

public class StackImpl implements Stack {
	private final Object[] elements;
	private final int size;
	
	public StackImpl(int size) {
		this.size = size;
		this.elements = new Object[size];
	}
	
	public Object[] getElements() {
		return elements;
	}

	@Override
	public void push(Object element) {
		int currentSize = size();
		if (currentSize < size) {
			elements[currentSize] = element;
		} else {
			System.out.println("The stack is full!\nIf you want to add elements in it, please detele some.");
		}

	}

	@Override
	public Object pop() {
		if (!isEmpty()) {
			Object last = get();
			elements[size() - 1] = null;
			
			return last;
		} else {
			return "The stack is empty";
		}
	}

	@Override
	public Object get() {
		if (isEmpty()) {
			return "The stack is empty";
		} else {
			return elements[size() - 1];
		}
		
	}

	@Override
	public int size() {
		int actualSize = 0;
		for (int i = 0; i < elements.length; i++) {
			if (!isElementNull(i)) {
				actualSize++;
			}
		}
		
		return actualSize;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clean() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
	}

	@Override
	public void printElements(Object stack) {
		System.out.println("Stack elemensts: ");
		for (int i = 0; i < elements.length; i++) {
			System.out.printf("%d - [%s] ", i+1, elements[i] == null ? "" : elements[i]);
		}
		System.out.println();
	}
	
	private boolean isElementNull(int index) {
		return elements[index] == null;
	}
}
