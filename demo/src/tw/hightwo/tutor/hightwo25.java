package tw.hightwo.tutor;


public class hightwo25 {

	public static void main(String[] args) {

	}

}

class hightwo251 {
	void m1() {
	}

	void m1(int a) {
	}

	public int m1(double a) {
		return 1;
	}

	Object m2() {
		return new Object();
	}
}

//	override 基本型別(包含void) 名稱都要一樣
//	String is a Object 下面可以改是因為物件型別不一樣
class hightwo252 extends hightwo251 {
	public String m2() {
		return "";
	}

}