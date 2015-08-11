package task2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import task1.MyScanner;

public class Navigation {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	static class Node {
		int elem;
		int price;
		
		Node(int elem, int price) {
			this.elem = elem;
			this.price = price;
		}
	}
	static Map<Integer, List<Node>> roads;
	static PriorityQueue<Node> availableVertex;
	static int[] dist;
	static int[] prev;
	static boolean[] visited;
	static int roadLength = 0;
	
	static void findMinRoad(int start) {
		if (!visited[start]) {
			visited[start] = true;
			
			List<Node> list = roads.get(start);
			
			for (Node node : list) {
				if (!visited[node.elem]) {
					availableVertex.add(node);
				}
			}
		}
		
		if (availableVertex.isEmpty()) {
			return;
		}
		
		Node min = availableVertex.poll();
		
		if (!visited[min.elem]) {
			int length = min.price + dist[start];
			if (dist[min.elem] > length)  {
				dist[min.elem] = length;
				prev[min.elem] = start;
			}
			
			findMinRoad(min.elem);
		} else {
			findMinRoad(start);
		}
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		roads = new HashMap<Integer, List<Node>>();
		availableVertex = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node p1, Node p2) {
				if (p1.price < p2.price) {
					return -1;
				} else {
					return 1;
				}
				
			}
		});
		
		int n = sc.nextInt() + 1;
		dist = new int[n];
		prev = new int[n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		
		dist[1] = 0;
		
		int streets = sc.nextInt();
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		for (int i = 0; i < streets; i++) {
			List<Node> list;
			
			int first = sc.nextInt();
			int second = sc.nextInt();
			int weight = sc.nextInt();
			
			if (roads.get(first) != null) {
				list = roads.get(first);
			} else {
				list = new ArrayList<Node>();
			}
			
			list.add(new Node(second, weight));
			roads.put(first, list);
			
			if (roads.get(second) != null) {
				list = roads.get(second);
			} else {
				list = new ArrayList<Node>();
			}
			
			list.add(new Node(first, weight));
			roads.put(second, list);
			
		}
		
		findMinRoad(start);
		
		out.println(dist[end]);
		
		StringBuilder path = new StringBuilder();
		
		while (end >= start) {
			path.append(" ");
			path.append(end);
			
			end = prev[end];
		}
		
		out.print(path.reverse().toString());
		
		out.flush();
		out.close();
	}

}
