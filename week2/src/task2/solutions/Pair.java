package task2.solutions;

public class Pair {
	private int start;
	private int end;
	
	public Pair(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		if (start >= 0 && start <= 365) {
			this.start = start;
		} else {
			start = -1;
		}
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		if (end >= 0 && end <= 365) {
			this.end = end;
		} else {
			end = -1;
		}
	}
	
	
}
