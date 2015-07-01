package task2.solutions;

public class ValidDirecories {
	private boolean[] visited;
	private boolean[] currentPath;
	private int length;
	
	public ValidDirecories(int length) {
		visited = new boolean[length];
		currentPath = new boolean[length];
		this.length = length;
	}
	
	public boolean validateDirectories(int[][] directories, int index) {
		if (index == length) {
			return true;
		}
		
		visited[index] = true;
		currentPath[index] = true;
		
		for (int i = 0; i < length; i++) {
			int type = directories[index][i];
			
			if (type == 1) {
				if (!visited[i]) {
					return validateDirectories(directories, i);
				} else {
					if (currentPath[i]) {
						return false;
					}
				}
			}
		}
		currentPath[index] = false;
		
		return validateDirectories(directories, index + 1);
	}
}
