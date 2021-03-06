package task3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OnlineMedian {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      public String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      public int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      public long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      public double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      public String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }
	}
	
	static class BinaryHeap {
		private static final int SIZE = 500000;
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
	
	static BinaryHeap minHeap = new BinaryHeap();
	static BinaryHeap maxHeap = new BinaryHeap();
	static int minCounter = 0;
	static int maxCounter = 0;
	
	public static int getMedian(int element) {
		if (minCounter > maxCounter) {
			int temp = minHeap.getTop();
			if (element > temp) {
				minHeap.removeMin();
				minHeap.insertMin(element);
				maxHeap.insertMax(temp);
				maxCounter++;
			} else {
				maxHeap.insertMax(element);
				maxCounter++;
			}
		} else {
			if (minCounter == 0) {
				minHeap.insertMin(element);
				minCounter++;
			} else {
				if(element < maxHeap.getTop() ) {
					int temp = maxHeap.getTop();
					maxHeap.removeMax();
					maxHeap.insertMax(element);
					minHeap.insertMin(temp);
					minCounter++;
				} else {
					minHeap.insertMin(element);
					minCounter++;
				}
			}
			
		}
		
		return minHeap.getTop();
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		
		for (int i = 0; i < size; i++) {
			int next = sc.nextInt();
			
			out.println(getMedian(next));
		}
		
		out.flush();
		out.close();
	}

}
