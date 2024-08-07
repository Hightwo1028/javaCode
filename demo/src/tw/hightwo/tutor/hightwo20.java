package tw.hightwo.tutor;

public class hightwo20 {

	public static void main(String[] args) {
		hightwo201 obj1 = new hightwo201();
		hightwo202 obj2 = new hightwo202();
		hightwo203 obj3 = new hightwo203();
		att(obj1);
		att(obj2);
		att(obj3);
	}
	static void att(hightwo201 obj) {
		obj.m1();
	}
}

class hightwo201 {
	void m1() {
		System.out.println("hightwo201:m1()");
	}
}
class hightwo202 extends hightwo201 {
	void m1() {
		System.out.println("hightwo202:m1()");
	}
}
class hightwo203 extends hightwo201 {
	void m1() {
		System.out.println("hightwo203:m1()");
	}
}

