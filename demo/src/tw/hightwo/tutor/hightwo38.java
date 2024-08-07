package tw.hightwo.tutor;

public class hightwo38 {

	public static void main(String[] args) {
		m1();
		System.out.println("Game Over");
	}
	
	static void m1() {
		System.out.println("1");
		int[] a = {1, 2, 3, 4};
		
		try {
			System.out.println(a[1]);
			System.out.println("hightwo");
//			return;
		}catch (Exception e) {
			System.out.println(e);
//			return;
		}finally {
			System.out.println("f"); //一定會做 在return之前			return;			
//			return;			
		}
		
		System.out.println("OK");
	}

}
