package tw.hightwo.tutor;

import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.nio.channels.NonWritableChannelException;

import tw.hightwo.js.Bike;

public class hightwo16 {

	public static void main(String[] args) {
		String s1 = new String();
		System.out.println(s1.length());
		byte[] b1 = {97, 98, 99, 100};
		String s2 = new String(b1);
		System.out.println(s2.length());
		System.out.println(s2);
		
		Bike b2 = new Bike();
		System.out.println(b2);
		
		int c = 12;
		System.out.println(c);
		
		Object obj1 = new Object();
		System.out.println(obj1);
		
		String s3 = "Hightwo";
		System.out.println(s3);
		String s4 = "Hightwo";
		String s5 = new String("Hightwo");
		String s6 = new String("Hightwo");
//		System.out.println(s3 == s4);
//		System.out.println(s3 == s5);
//		System.out.println(s5 == s6);
		//三個物件實體 s3 = s4, s5, s6
		
		System.out.println(s5.equals(s6));
		//雙引號本身就是一個字串物件
		System.out.println("Hightwo".charAt(0));
	}

}
