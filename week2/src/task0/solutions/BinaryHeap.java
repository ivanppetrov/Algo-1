package task0.solutions;

public class BinaryHeap {
	private static final int SIZE = 10000;
	private int[] data;
	private int index;
	
	public BinaryHeap() {
		this.data = new int[SIZE];
		this.index = 0;
	}
	
	public void insertMin(int element) {
		this.data[++index] = element;
		
		for (int i = index; i > 1; i /= 2) {
			int parent = this.data[i/2];
			if (element < parent) {
				//swap parent and element
				this.data[i/2] = this.data[i];
				this.data[i] = parent;
			} else {
				break;
			}
		}
	}
	
	public void removeMin() {
		this.data[1] = this.data[this.index];
		int parent = 1;
		int left = 2 * parent;
		int right = 2 * parent + 1;
				
		while (this.data[parent] > this.data[left] || this.data[parent] > this.data[right]) {
			if (right <= index && this.data[right] > this.data[left]) {
					int temp = this.data[parent];
					this.data[parent] = this.data[left];
					this.data[left] = temp;
					parent = left;
			} else if (right <= index && this.data[left] >= this.data[right]) {
					int temp = this.data[parent];
					this.data[parent] = this.data[right];
					this.data[right] = temp;
					parent = right;
			} else if (left <= index){
				int temp = this.data[parent];
				this.data[parent] = this.data[left];
				this.data[left] = temp;
				parent = left;
			} else {
				break;
			}
			
			left = 2 * parent;
			right = 2 * parent + 1;
		}
		
		this.index--;
	}
	
	public void insertMax(int element) {
		this.data[++index] = element;
		
		for (int i = index; i > 1; i /= 2) {
			int parent = this.data[i/2];
			if (element > parent) {
				//swap parent and element
				this.data[i/2] = this.data[i];
				this.data[i] = parent;
			} else {
				break;
			}
		}
	}
	
	public void removeMax() {
		this.data[1] = this.data[this.index];
		int parent = 1;
		int left = 2 * parent;
		int right = 2 * parent + 1;
				
		while (this.data[parent] < this.data[left] || this.data[parent] < this.data[right]) {
			if (right <= index && this.data[right] <= this.data[left]) {
					int temp = this.data[parent];
					this.data[parent] = this.data[left];
					this.data[left] = temp;
					parent = left;
			} else if (right <= index && this.data[left] < this.data[right]) {
					int temp = this.data[parent];
					this.data[parent] = this.data[right];
					this.data[right] = temp;
					parent = right;
			} else if (left <= index){
				int temp = this.data[parent];
				this.data[parent] = this.data[left];
				this.data[left] = temp;
				parent = left;
			} else {
				break;
			}
			
			left = 2 * parent;
			right = 2 * parent + 1;
		}
		
		this.index--;
	}
	
	public int getTop() {
		return this.data[1];
	}
	
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");
		
		for (int i = 1; i < index + 1; i++) {
			result.append(this.data[i]);
			result.append(" ");
		}
		
		result.append("]");
		
		return result.toString();
	}
	
	
}
