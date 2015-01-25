package task3;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Pair {
	private final Object obj1;
	private final Object obj2;
	
	
	
	public Pair(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public Object getObj1() {
		return obj1;
	}

	public Object getObj2() {
		return obj2;
	}
	
	public String toString() {
		return String.format("Object1 %s\nObject2 %s", obj1, obj2);
	}

	public boolean equals(Pair pair) {
		if (pair instanceof Pair) {
			if (this.getObj1().equals(pair.getObj1()) && this.getObj2().equals(pair.getObj2())) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int obj1 = 1;
		int obj2 = 2;
		int obj3 = 1;
		int obj4 = 2;
		int obj5 = 3;
		int obj6 = 4;
		String obj8 = "1";
		String obj9 = "2";
		Pair pair = new Pair(obj1, obj2);
		Pair secondPair = new Pair(obj3, obj4);
		Pair thirdPair = new Pair(obj5, obj6);
		Pair forthPair = new Pair(obj8, obj9);
		
		System.out.println(pair.toString());
		System.out.println(pair.equals(secondPair));
		System.out.println(pair.equals(pair));
		System.out.println(pair.equals(thirdPair));
		System.out.println(forthPair.toString());
		System.out.println(pair.equals(forthPair));
	}

}
