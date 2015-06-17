package task2.solution;

import task1.solution.VectorImpl;

public class QueueImpl<T> implements Queue<T>{
	private VectorImpl<T> vector;
	
	public QueueImpl() {
		this.vector = new VectorImpl<T>();
	}
	
	@Override
	public void push(T value) {
		vector.add(value);
	}

	@Override
	public T pop() {
		return vector.remove(0);
	}

	@Override
	public T peek() {
		return vector.get(0);
	}

	@Override
	public int size() {
		return vector.size();
	}
	
	@Override
	public String toString() {
		return vector.toString();
	}
}
