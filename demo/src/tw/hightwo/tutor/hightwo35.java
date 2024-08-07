package tw.hightwo.tutor;

public class hightwo35 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		int[] d = { 0, 1, 2, 3 };

		try {
			int c = a / b;
			System.out.println(c);
			System.out.println(d[12]);
		} catch (ArithmeticException e) {
			System.out.println("Err2");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Err1");// 處理完
		} catch (RuntimeException e) {
			System.out.println("Err3");// 處理完
		}
		System.out.println("OK");// 繼續跑程式
	
	}

}



//Exception > RuntimeException
//		  > Checked Exception  (檢查)
