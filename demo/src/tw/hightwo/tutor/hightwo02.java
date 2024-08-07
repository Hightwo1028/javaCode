package tw.hightwo.tutor;

import java.util.Scanner;

public class hightwo02 {

	public static void main(String[] args) {
		//input
		Scanner scannerA = new Scanner(System.in);
		
		System.out.print("X = ");
		int a = scannerA.nextInt();
		
		System.out.print("Y = ");
		int b = scannerA.nextInt();
		// op..
		int plus = a + b;
		int minus = a - b;
		int multi = a * b;
		int divide = a / b;
		int mode = a % b;
		//output
		//System.out.println(a);
		//System.out.println(b);
		System.out.printf("%d + %d = %d\n", a, b, plus);
		System.out.printf("%d - %d = %d\n", a, b, minus);
		System.out.printf("%d * %d = %d\n", a, b, multi);
		System.out.printf("%d / %d = %d......%d", a, b, divide, mode);
	}

}
