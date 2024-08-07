package tw.hightwo.tutor;

public class hightwo37 {

//	public static void main(String[] args) {
//		hightwo371 obj = new hightwo371();
//		
//
//	}
//
//}

	public static void main(String[] args) {
		hightwo371 obj = new hightwo371();
		try {
			obj.m1();
		} catch (Exception e) {

		}
	}
}

class hightwo371 {
	void m1() throws Exception {
		System.out.println("hightwo371:m1()");
		m2();
	}

	void m2() throws Exception {
		System.out.println("hightwo371:m2()");
		m3();
	}

	void m3() throws Exception {
		System.out.println("hightwo371:m3()");
		throw new Exception();
	}
}