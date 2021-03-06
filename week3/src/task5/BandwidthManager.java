package task5;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BandwidthManager {
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
	static public class BinaryHeap {
		private static final int SIZE = 100000;
		private Command[] data;
		private int index;
		
		public BinaryHeap() {
			this.data = new Command[SIZE];
			for (int i = 0; i < SIZE; i++) {
				this.data[i] = new Command("", "", 0);
			}
			this.index = 0;
		}
		
		public void insertMin(Command element) {
			this.data[++index] = element;
			
			for (int i = index; i > 1; i /= 2) {
				Command parent = this.data[i/2];
				if (element.priority < parent.priority) {
					//swap parent and element
					this.data[i/2] = this.data[i];
					this.data[i] = parent;
				} else if (element.priority == parent.priority) {
					if (element.time < parent.time) {
						//swap parent and element
						this.data[i/2] = this.data[i];
						this.data[i] = parent;
					}
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
			
			while (this.data[parent].priority >= this.data[left].priority || this.data[parent].priority >= this.data[right].priority) {
				if (right <= index && this.data[right].priority > this.data[left].priority) {
						Command temp = this.data[parent];
						this.data[parent] = this.data[left];
						this.data[left] = temp;
						parent = left;
				} else if (right <= index && this.data[left].priority > this.data[right].priority) {
						Command temp = this.data[parent];
						this.data[parent] = this.data[right];
						this.data[right] = temp;
						parent = right;
				} else if (right <= index && this.data[left].priority == this.data[right].priority){
					if (this.data[left].time < this.data[right].time) {
						Command temp = this.data[parent];
						this.data[parent] = this.data[left];
						this.data[left] = temp;
						parent = left;
					} else {
						Command temp = this.data[parent];
						this.data[parent] = this.data[right];
						this.data[right] = temp;
						parent = right;
					}
				} else if (left <= index){
					Command temp = this.data[parent];
					this.data[parent] = this.data[left];
					this.data[left] = temp;
					parent = left;
				} else {
					break;
				}
				
				left = 2 * parent;
				right = 2 * parent + 1;
			}
			if (this.index > 0) {
				this.index--;
			}
		}
		
		public Command getTop() {
			if (index == 0) {
				return null;
			} else {
				return this.data[1];
			}
		}
		
		public boolean isEmpty() {
			return index == 0;
		}

		@Override
		public String toString() {
			StringBuffer result = new StringBuffer();
			result.append("[");
			
			for (int i = 1; i < index + 1; i++) {
				result.append(this.data[i].priority + ":");
				result.append(this.data[i].value);
				result.append(" ");
			}
			
			result.append("]");
			
			return result.toString();
		}
		
		
	}
	static class Command {
		int priority;
		int time;
		String value;
		
		public Command(String protocol, String value, int time) {
			this.priority = getPriority(protocol);
			this.time = time;
			this.value = value;
		}
		
		private int getPriority(String protocol) {
			switch (protocol) {
			case "ICMP": return 1;
			case "UDP": return 2;
			case "RTM": return 3;
			case "IGMP": return 4;
			case "DNS": return 5;
			case "TCP": return 6;
			default:
				return Integer.MAX_VALUE;
			}
		}
	}
	static BinaryHeap heap;
	
	public static String send() {
		Command result = heap.getTop();
		heap.removeMin();
		
		return result != null ? result.value : "Nothing to send!";
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		heap = new BinaryHeap();
		
		int size = sc.nextInt();
		int time = 0;
		for (int i = 0; i < size; i++) {
			String[] command = sc.nextLine().split("\\s+");
			
			if (command[0].equals("rcv")) {
				heap.insertMin(new Command(command[1], command[2], time++));
			} else {
				out.println(send());
			}
		}
		
		out.flush();
		out.close();
	}

}
