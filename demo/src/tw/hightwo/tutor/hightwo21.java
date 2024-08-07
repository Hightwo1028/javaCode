package tw.hightwo.tutor;

public class hightwo21 {
	public static void main(String[] args) {
		Brad211 obj1 = new Brad211() {
			@Override
			void m2() {
				System.out.println("Brad211:m2()");
			}
		};
		obj1.m1(); obj1.m2();
		
		Brad211 obj2 = new Brad212();
		obj2.m1(); obj2.m2();
		
	}
}

abstract class Brad211 {
	void m1() {System.out.println("Brad211:m1()");}
	abstract void m2();
}
class Brad212 extends Brad211 {
	void m2() {System.out.println("Brad212:m2()");}
}
class Brad213 extends Brad211 {
	void m2() {System.out.println("Brad213:m2()");}
}
abstract class Brad214{
	void m1() {}
	void m2() {}
	void m3() {}
	void m4() {}
	void m5() {}
	void m6() {}
}