package tw.hightwo.tutor;

public class hightwo19 {

	public static void main(String[] args) {
		hightwo191 obj1 = new hightwo191();
		obj1.m1();
		obj1.m2();
		hightwo192 obj2 = new hightwo192();
		obj2.m1();
		obj2.m2();
		obj2.m3();

		hightwo191 obj3 = new hightwo192(); // 只是要車，不在乎他是什麼車會
		// 有你前面宣告的功能(可能被改寫，不會有物件實體的額外功能)
		obj3.m1();
		obj3.m2();

		// 把obj3強制轉型成hightwo192(法拉利)
		hightwo192 obj4 = (hightwo192) obj3;
		obj4.m1();
		obj4.m2();
		obj4.m3();

		// 只認直系血親 連強制轉型都不行
//		hightwo192 obj5 = new hightwo193();
//		hightwo193 obj6 = new hightwo192();

		hightwo191 obj7 = new hightwo192();
//		hightwo193 obj8 = (hightwo193)obj7;

		if (obj7 instanceof Object) {
			System.out.println("Yes1");
		} else {
			System.out.println("No1");
		}
		if (obj7 instanceof hightwo191) {
			System.out.println("Yes2");
		} else {
			System.out.println("No2");
		}
		if (obj7 instanceof hightwo192) {
			System.out.println("Yes3");
		} else {
			System.out.println("No3");
		}
		if (obj7 instanceof hightwo193) {
			System.out.println("Yes4");
		} else {
			System.out.println("No4");
		}
//		if (obj7 instanceof String) {
//			System.out.println("Yes5");
//		} else {
//			System.out.println("No5");
//		}
	}

}

class hightwo191 {
	void m1() {
		System.out.println("hightwo191:m1()");
	}

	void m2() {
		System.out.println("hightwo191:m2()");
	}
}

class hightwo192 extends hightwo191 {
	void m2() {
		System.out.println("hightwo192:m2()");
	}

	void m3() {
		System.out.println("hightwo192:m3()");
	}
}

class hightwo193 extends hightwo191 {
	void m2() {
		System.out.println("hightwo193:m2()");
	}

	void m3() {
		System.out.println("hightwo193:m3()");
	}
}
