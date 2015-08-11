package task6;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import task1.MyScanner;

public class KIntersect {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		Map<String, Integer> current = new HashMap<String, Integer>();
		Map<String, Integer> temp = new HashMap<String, Integer>();
		
		int number = sc.nextInt();
		
		String[] tempArr = sc.nextLine().split("\\s+");
		for (int i = 0; i < tempArr.length; i++) {
			current.put(tempArr[i], i);
		}
		
		for (int i = 0; i < number - 1; i++) {
			tempArr = sc.nextLine().split("\\s+");
			for (int j = 0; j < tempArr.length; j++) {
				String next = tempArr[j];
				if (current.containsKey(next)) {
					temp.put(next, Integer.parseInt(next));
				}
			}
			current = temp;
			temp = new HashMap<String, Integer>();
		}
		
		
		for (String key : current.keySet()) {
			out.println(key);
		}
		
		out.flush();
		out.close();
	}

}
