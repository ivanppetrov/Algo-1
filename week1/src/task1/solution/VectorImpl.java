package task1.solution;

public class VectorImpl<T> implements Vector<T>{
	private static final int INITIAL_SIZE = 4000;
	private int index;
	private int capacity;
	private T[] data;

	public VectorImpl() {
		this.data = (T[]) new Object[INITIAL_SIZE];
		this.capacity = INITIAL_SIZE;
		this.index = 0;
	}

	private void expend() {
		this.capacity = 2 * this.capacity;
		T[] tempData = (T[]) new Object[this.capacity];
		
		for (int i = 0; i < this.index; i++) {
			tempData[i] = this.data[i];
		}
		
		this.data =  tempData;
		
	}
	
	@Override
	public boolean insert(int index, T value) {
		if (index >= this.index || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			for (int i = this.index; i > index; i--) {
				this.data[i] = this.data[i - 1]; 
			}
			data[index] = value;
			this.index++;
			return true;
		}
		
	}

	@Override
	public boolean add(T value) {
		if (isFull()) {
			expend();
		}
		
		this.data[this.index] = value;
		this.index++;
		
		return true;
	}

	@Override
	public T get(int index) {
		if (this.index >= 0 && index < this.index) {
			return this.data[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public T remove(int index) {
		T result = this.data[index];
		for (int i = index; i < this.index - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		this.index--;
		return result;
	}

	@Override
	public T pop() {
		this.index--;
		T result = this.data[this.index];
		return result;
	}

	@Override
	public int size() {
		return this.index;
	}

	@Override
	public int capacity() {
		return this.capacity;
	}
	
	private boolean isFull() {
		return size() == capacity;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");
		for (int i = 0; i < size(); i++) {
			result.append(this.data[i]);
			result.append(" ");
		}
		
		result.append("]");
		
		return result.toString();
	}
}
