package task3;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

import task1.MyScanner;

public class VitoshaRun {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	static class Node {
		int x;
		int y;
		int price;
		
		public Node(int x, int y, int price) {
			this.x = x;
			this.y = y;
			this.price = price;
		}
		
		@Override
		public String toString() {
			return x + ":" + y + "->" + price;
		}
	}
	static int size;
	static PriorityQueue<Node> availableVertex;
	static int[][] mountain;
	static int[][] dist;
	static boolean[][] visited;
	static int roadLength = 0;
	
	//update dist for each row col with new value
	static void findMinTime(int row, int col) {
		if (!visited[row][col]) {
			visited[row][col] = true;
			
			int currentValue = mountain[row][col];
			int currentDist = dist[row][col];
			
			if (isInBorder(row - 1, col - 1)) {
				if (!visited[row - 1][col - 1]) {
					int value = mountain[row - 1][col - 1];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row - 1][col - 1] > updated) {
						dist[row - 1][col - 1] = updated;
					}
					availableVertex.add(new Node(row - 1, col - 1, updated));
				}
			}
			if (isInBorder(row, col - 1)) {
				if (!visited[row][col - 1]) {
					int value = mountain[row][col - 1];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row][col - 1] > updated) {
						dist[row][col - 1] = updated;
					}
					availableVertex.add(new Node(row, col - 1, updated));
				}
			}
			if (isInBorder(row + 1, col - 1)) {
				if (!visited[row + 1][col - 1]) {
					int value = mountain[row + 1][col - 1];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row + 1][col - 1] > updated) {
						dist[row + 1][col - 1] = updated;
					}
					availableVertex.add(new Node(row + 1, col - 1, updated));
				}
			}
			if (isInBorder(row - 1, col)) {
				if (!visited[row - 1][col]) {
					int value = mountain[row - 1][col];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row - 1][col] > updated) {
						dist[row - 1][col] = updated;
					}
					availableVertex.add(new Node(row - 1, col, updated));
				}
			}
			if (isInBorder(row + 1, col)) {
				if (!visited[row + 1][col]) { 
					int value = mountain[row + 1][col];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row + 1][col] > updated) {
						dist[row + 1][col] = updated;
					}
					availableVertex.add(new Node(row + 1, col, updated));
				}
			}
			if (isInBorder(row - 1, col + 1)) {
				if (!visited[row - 1][col + 1]) {
					int value = mountain[row - 1][col + 1];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row - 1][col + 1] > updated) {
						dist[row - 1][col + 1] = updated;
					}
					availableVertex.add(new Node(row - 1, col + 1, updated));
				}
			}
			if (isInBorder(row, col + 1)) {
				if (!visited[row][col + 1]) {
					int value = mountain[row][col + 1];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row][col + 1] > updated) {
						dist[row][col + 1] = updated;
					}
					availableVertex.add(new Node(row, col + 1, updated));
				}
			}
			if (isInBorder(row + 1, col + 1)) {
				if (!visited[row + 1][col + 1]) {
					int value = mountain[row + 1][col + 1];
					int updated = 1 + Math.abs(currentValue - value) + currentDist;
					
					if (dist[row + 1][col + 1] > updated) {
						dist[row + 1][col + 1] = updated;
					}
					availableVertex.add(new Node(row + 1, col + 1, updated));
				}
			}
		}
		
		if (availableVertex.isEmpty()) {
			return;
		}
		
		Node next = availableVertex.poll();
		
		if (!visited[next.x][next.y]) {
//			int price = dist[row][col] + next.price;
//			if (dist[next.x][next.y] > price) {
//				dist[next.x][next.y] = price;
//				
//				availableVertex.add(new Node(next.x, next.y, price));
//			}
			
			findMinTime(next.x, next.y);
		} else {
			findMinTime(row, col);
		}
	}
	
	private static boolean isInBorder(int x, int y) {
		if (x < 0 || x >= size || y < 0 || y >= size) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
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
		
		size = sc.nextInt();
		int startRow = sc.nextInt();
		int startCol = sc.nextInt();
		int endRow = sc.nextInt();
		int endCol = sc.nextInt();
		
		visited = new boolean[size][size];
		mountain = new int[size][size];
		dist = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				mountain[i][j] = sc.nextInt();
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dist[startRow][startCol] = 0;
		
		findMinTime(startRow, startCol);
		
		out.print(dist[endRow][endCol]);
		
		out.flush();
		out.close();
	}

}
