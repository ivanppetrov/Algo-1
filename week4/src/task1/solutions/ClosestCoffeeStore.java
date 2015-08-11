package task1.solutions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ClosestCoffeeStore {
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

	static public class VectorImpl<T>{
		private static final int INITIAL_SIZE = 10000;
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
	
		
		public boolean add(T value) {
			if (isFull()) {
				expend();
			}
			
			this.data[this.index] = value;
			this.index++;
			
			return true;
		}
	
		
		public T get(int index) {
			if (this.index >= 0 && index < this.index) {
				return this.data[index];
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
	
		
		public T remove(int index) {
			T result = this.data[index];
			for (int i = index; i < this.index - 1; i++) {
				this.data[i] = this.data[i + 1];
			}
			this.index--;
			return result;
		}
	
		
		public T pop() {
			this.index--;
			T result = this.data[this.index];
			return result;
		}
	
		
		public int size() {
			return this.index;
		}
	
		
		public int capacity() {
			return this.capacity;
		}
		
		private boolean isFull() {
			return size() == capacity;
		}
		
		
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

	static public class QueueImpl<T>{
		private VectorImpl<T> vector;
		
		public QueueImpl() {
			this.vector = new VectorImpl<T>();
		}
		
		
		public void push(T value) {
			vector.add(value);
		}
	
		
		public T pop() {
			return vector.remove(0);
		}
	
		
		public T peek() {
			return vector.get(0);
		}
	
		
		public int size() {
			return vector.size();
		}
		
		
		public String toString() {
			return vector.toString();
		}
	}

	public static int closestCoffeeStore(byte[][] graph, byte[] coffeStore, int startingPoint) {
		QueueImpl<Integer> queue = new QueueImpl<Integer>();
		int length = graph.length;
		int[] distance = new int[length];
		int[] parents = new int[length];
		boolean[] visited = new boolean[length];
		int store = -1;
		
		queue.push(startingPoint);
		parents[startingPoint] = -1;
		distance[startingPoint] = 0;
		
		if (isCoffeeShop(coffeStore, startingPoint)){
			store = startingPoint;
		} else {
		
			while (queue.size() !=0) {
				int current = queue.pop();
				visited[current] = true;
				
				for (int i = 0; i < length; i++) {
					int temp = graph[current][i];
					if (temp == 1) {
						if (!visited[i]) {
							visited[i] = true;
							queue.push(i);
							parents[i] = current;
							distance[i] = distance[current] + 1;
							
							if (isCoffeeShop(coffeStore, i)) {
								store = i;
								break;
							}
						}
					}
				}
				
				if (store != -1) {
	//				System.out.println("Distance: " + distance[store]);
	//				int parent = parents[store];
	//				String path = "" + store;
	//				
	//				while (parent != -1) {
	//					path = parent + "->" + path;
	//					int temp = parent;
	//					parent = parents[temp];
	//				}
	//				System.out.println("Path: " + path);
					break;
				}
			}
		}
		
		return store != -1 ? distance[store] : store;
	}
	
	private static boolean isCoffeeShop(byte[] coffeStore, int storeIndex) {
		return coffeStore[storeIndex] == 1;
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int size = sc.nextInt();
		byte[][] graph = new byte[size][size];
		byte[] coffeStore = new byte[size];
		int startingPoint;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				graph[i][j] = (byte) sc.nextInt();
			}
		}
		
		startingPoint = sc.nextInt();
		
		for (int i = 0; i < size; i++) {
			coffeStore[i] = (byte) sc.nextInt();
		}
		
		out.print(closestCoffeeStore(graph, coffeStore, startingPoint));
		
		out.flush();
		out.close();
	}
}
