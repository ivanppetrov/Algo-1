package implementation;

import java.util.PriorityQueue;

public class BoundedQueue<Object> extends PriorityQueue<Object> {
	private static final long serialVersionUID = 1L;
	private int maxSize;
	
	public BoundedQueue(int size) {
		this.maxSize = size;
	}

	@Override
	public boolean offer(Object e) {
		if (this.size() == maxSize) {
			this.poll();
			super.offer(e);
			return false;
		} else {
			super.offer(e);
			return true;
		}
	}
	
	public String toString() {
		String result = "";
		
		for (Object element : this) {
			result += element + " ";
		}
		
		return result;
	}
}
