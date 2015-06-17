package task2.solution;

import java.util.LinkedList;
import java.util.List;

public class QueueList<T> implements Queue<T>{
	LinkedList<T> data;
	
	public QueueList() {
		this.data = new LinkedList<T>();
	}	
	
	@Override
	public void push(T value) {
		this.data.addLast(value);;
	}

	@Override
	public T pop() {
		return this.data.getFirst();
	}

	@Override
	public T peek() {
		return this.data.removeFirst();
	}

	@Override
	public int size() {
		return this.data.size();
	}

}
