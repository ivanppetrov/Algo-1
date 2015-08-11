package task6.solutions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class KLists {
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
		private static final int SIZE = 10000;
		private Pair[] data;
		private int index;
		
		public BinaryHeap() {
			this.data = new Pair[SIZE];
			
			for (int i = 0; i < SIZE; i++) {
				this.data[i] = new Pair(-1, 0);
			}
			
			this.index = 0;
		}
		
		public void insertMin(Pair element) {
			this.data[++index] = element;
			
			for (int i = index; i > 1; i /= 2) {
				Pair parent = this.data[i/2];
				if (element.value < parent.value) {
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
					
			while (this.data[parent].value > this.data[left].value || this.data[parent].value > this.data[right].value) {
				if (right <= index && this.data[right].value > this.data[left].value) {
						Pair temp = this.data[parent];
						this.data[parent] = this.data[left];
						this.data[left] = temp;
						parent = left;
				} else if (right <= index && this.data[left].value >= this.data[right].value) {
						Pair temp = this.data[parent];
						this.data[parent] = this.data[right];
						this.data[right] = temp;
						parent = right;
				} else if (left <= index){
					Pair temp = this.data[parent];
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
		
		public void insertMax(Pair element) {
			this.data[++index] = element;
			
			for (int i = index; i > 1; i /= 2) {
				Pair parent = this.data[i/2];
				if (element.value > parent.value) {
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
					
			while (this.data[parent].value < this.data[left].value || this.data[parent].value < this.data[right].value) {
				if (right <= index && this.data[right].value <= this.data[left].value) {
						Pair temp = this.data[parent];
						this.data[parent] = this.data[left];
						this.data[left] = temp;
						parent = left;
				} else if (right <= index && this.data[left].value < this.data[right].value) {
						Pair temp = this.data[parent];
						this.data[parent] = this.data[right];
						this.data[right] = temp;
						parent = right;
				} else if (left <= index){
					Pair temp = this.data[parent];
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
		
		public Pair getTop() {
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

	
	static class Pair {
		int list;
		int value;
		
		public Pair(int list, int value) {
			this.list = list;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return list + ":" + value;
		}
	}
	
	private static List<Integer> mergeLists(List<List<Pair>> lists) { 
		List<Integer> result = new ArrayList<Integer>();
		BinaryHeap heap = new BinaryHeap();
		
		for (int i = 0; i < lists.size(); i++) {
			heap.insertMin(lists.get(i).get(0));
		}
		
		while (!heap.isEmpty()) {
			Pair temp = heap.getTop();
			heap.removeMin();
			result.add(temp.value);
			
			List<Pair> currentList = lists.get(temp.list);
			int currentIndex = currentList.indexOf(temp);
			if (currentIndex != currentList.size() - 1) {
				heap.insertMin(currentList.get(currentIndex + 1));
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		List<List<Pair>> lists = new ArrayList<List<Pair>>();
		
		for (int i = 0; i < size; i++) {
			List<Pair> list = new ArrayList<Pair>();
			int value = sc.nextInt();
			
			while (value != -1) {
				list.add(new Pair(i, value));
				value = sc.nextInt();
			}
			
			lists.add(list);
		}
		
		List<Integer> result = mergeLists(lists);
		
		for (int i = 0; i < result.size(); i++) {
			out.printf("%d ", result.get(i));
		}
		
		out.flush();
		out.close();
	}
}
