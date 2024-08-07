package tw.hightwo.tutor;

public class hightwo18 {

	public static void main(String[] args) {
		hightwo183 obj = new hightwo183(); // 通通都會做，會一直往回初始化
	}
}

class hightwo181 {
	hightwo181() {
		System.out.println("hightwo181()");
	}
}

class hightwo182 extends hightwo181 {
	hightwo182() {
		System.out.println("hightwo182()");
	}
}

class hightwo183 extends hightwo182 {
	hightwo183() {
		this(2);
		System.out.println("hightwo183()");
	}

	hightwo183(int a) {
		this("");
		System.out.println("hightwo183(int)");
	}

	hightwo183(String a) {
		System.out.println("hightwo183(String)");
	}
}