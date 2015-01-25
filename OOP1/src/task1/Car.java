package task1;

public class Car {
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public static void main(String agrs[]) {
		Audi audi = new Audi();
		BMW bmw = new BMW();
		System.out.println(audi.toString());
		System.out.println(bmw.toString());
	}
}
