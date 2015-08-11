package task1.tests;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import task1.solutions.Roots;

public class TestRoots {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.println(formatter.format(Roots.squareRoot(number)));
	}
public static void main(String[] args) {
	
}
}
