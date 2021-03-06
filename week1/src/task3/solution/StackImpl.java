package task3.solution;

import task2.solution.QueueImpl;

public class StackImpl<T> implements Stack<T>{
	private QueueImpl<T> queue;
	
	public StackImpl() {
		queue = new QueueImpl<T>();
	}
	
	@Override
	public void push(T value) {
		queue.push(value);
	}

	@Override
	public T pop() {
		QueueImpl<T> newQueue = new QueueImpl<T>();
		T removedElement;
		for (int i = 0; i < size() - 1; i++) {
			newQueue.push(this.queue.pop());
		}
		
		removedElement = this.queue.pop();
		this.queue = newQueue;
		
		return removedElement;
	}

	@Override
	public T peek() {
		QueueImpl<T> newQueue = new QueueImpl<T>();
		T lastElement;
		for (int i = 0; i < size(); i++) {
			T elem = this.queue.pop();
			newQueue.push(elem);
		}
		
		lastElement = this.queue.pop();
		newQueue.push(lastElement);
		this.queue = newQueue;
		
		return lastElement;
	}

	@Override
	public int size() {
		return queue.size();
	}
	
	@Override
	public String toString() {
		return queue.toString();
	}

}
