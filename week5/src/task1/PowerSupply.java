package task1;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PowerSupply {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	public static class Pair {
		int next;
		int weight;
		
		public Pair(int next, int weight) {
			super();
			this.next = next;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return next + " " + weight;
		}
	}
	
	PriorityQueue<Pair> availableVertex;
	Map<Integer, List<Pair>> connectionsList;
	boolean[] addedInTree;
	
	public PowerSupply(int size) {
		availableVertex = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if (p1.weight < p2.weight) {
					return -1;
				} else {
					return 1;
				}
				
			}
		});
		
		connectionsList = new HashMap<Integer, List<Pair>>();
		addedInTree = new boolean[size];
	}
	
	public int connectStreets(Pair current, int length) {
		if (!addedInTree[current.next]) {
		
			List<Pair> connections = connectionsList.get(current.next);
			addedInTree[current.next] = true;
			length += current.weight;
			
			for (Pair pair : connections) {
				if (!addedInTree[pair.next]) {
					availableVertex.add(pair);
				}
			}
		}
		
		if (availableVertex.isEmpty()) {
			return length;
		}
		
		Pair cheapest = availableVertex.poll();
		return connectStreets(cheapest, length);
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int number = sc.nextInt();
		PowerSupply ps = new PowerSupply(number);
		
		for (int i = 0; i < number; i++) {
			List<Pair> list;
			
			int first = sc.nextInt();
			int second = sc.nextInt();
			int weight = sc.nextInt();
			
			if (ps.connectionsList.get(first) != null) {
				list = ps.connectionsList.get(first);
			} else {
				list = new ArrayList<Pair>();
			}
			
			list.add(new Pair(second, weight));
			ps.connectionsList.put(first, list);
			
			if (ps.connectionsList.get(second) != null) {
				list = ps.connectionsList.get(second);
			} else {
				list = new ArrayList<Pair>();
			}
			
			list.add(new Pair(first, weight));
			ps.connectionsList.put(second, list);
			
		}
		
		int length = ps.connectStreets(new Pair(1, 0), 0);
		out.println(length);
		out.flush();
		out.close();
	}

}
