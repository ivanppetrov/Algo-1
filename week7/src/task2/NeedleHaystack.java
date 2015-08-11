package task2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NeedleHaystack {
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
	
	private static final int BASE = 29;
	private static final int MOD = 100007;
	private static final int A = 'a';
	static StringBuffer result = new StringBuffer();
	
	private static void getNeedlePosition(String haystack, String needle) {
		int needleHash = getHash(needle);
		int needleLen = needle.length();
		int tempHash = getHash(haystack.substring(0, needleLen));
		int basePow = getBasePow(needleLen);
		
		for (int i = 1; i < haystack.length() - needle.length(); i++) {
			int ch = haystack.charAt(i - 1) - A + 1;
			int nextCh = haystack.charAt(i + needleLen - 1) - A + 1;
			
			String temp = haystack.substring(i, i + needleLen);
			tempHash = (((MOD + tempHash - basePow * ch) % MOD) * BASE  + nextCh) % MOD;
			
			if (tempHash == needleHash) {
				if (needle.equals(temp)) {
					result.append(i);
					result.append(",");
				}
			}
		}
		
	}
	
	private static int getHash(String word) {
		int hash = 0;
		for (int i = 0; i < word.length(); i++) {
			int ch = word.charAt(i) - A + 1;
			hash = ((hash * BASE)  + ch)  % MOD;
		}
		
		return hash;
	}
	
	private static int getBasePow(int len) {
		int basePow = 1;
		for (int i = 0; i < len - 1; i++) {
			basePow *= BASE;
			basePow = basePow % MOD;
		} 
		
		return basePow;
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		String haystack = sc.nextLine();
		String needle = sc.nextLine();
		
		getNeedlePosition(haystack, needle);
		
		out.print(result.toString());
		
		out.flush();
		out.close();
	}

}
