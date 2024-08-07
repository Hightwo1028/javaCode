package tw.hightwo.tutor;

public class hightwo06 {

	public static void main(String[] args) {
		int i = 0;
		for ( printHightwo() ; i < 10 ; printLine()) {
			System.out.println(i++);
		}
		System.out.println(i);
	}
	static void printHightwo() {
		System.out.println("Hightwo");
		printLine();
	}
	static void printLine() {
		System.out.println("---");
	}
}
