package task1.solutions;

import task2.solution.QueueImpl;

public class ClosestCoffeeStore {
	public static int closestCoffeeStore(int[][] graph, byte[] coffeStore, int startingPoint) {
		QueueImpl<Integer> queue = new QueueImpl<Integer>();
		int length = graph[0].length;
		int[] distance = new int[length];
		int dist = 0;
		int[] parents = new int[length];
		boolean[] visited = new boolean[length];
		int store = -1;
		
		queue.push(startingPoint);
		parents[startingPoint] = -1;
		distance[startingPoint] = dist;
		
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
						distance[i] = dist++;
						
						if (isCoffeeShop(coffeStore, i)) {
							store = i;
							break;
						}
					}
				}
			}
			
			if (store != -1) {
				System.out.println("Distance: " + distance[store]);
				int parent = parents[store];
				String path = "" + store;
				
				while (parent != -1) {
					path = parent + "->" + path;
					int temp = parent;
					parent = parents[temp];
				}
				System.out.println("Path: " + path);
				break;
			}
		}
		
		return store;
	}
	
	private static boolean isCoffeeShop(byte[] coffeStore, int storeIndex) {
		return coffeStore[storeIndex] == 1;
	}
}
