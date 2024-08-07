package tw.hightwo.tutor;

public class hightwo05 {

	public static void main(String[] args) {
		int year = 2024;
		boolean isLeap;
		
		if (year % 4 == 0 ) {
			if (year % 100 == 0 && year % 400 != 0) {
				isLeap = false;
			}
			else {
				isLeap = true;
			}
		}
		else {
			isLeap = false;
		}
		System.out.printf("%d年為%s年", year, isLeap ? "閏":"平");
	}
}
