package tw.hightwo.tutor;

public class Hightwo99 {
	public static void main(String[] args) {
		final int ROWS = 10;
		final int COLS = 10;
		final int START = 1;
		
		for(int k = 0 ; k < ROWS ; k++ ) {
			for (int j = 1; j <= 9; j++) {
				for (int i = START; i < START + COLS; i++) {
					int newi = i + (k * COLS);
					int result = newi * j;
					System.out.printf("%d x %d = %d	", newi, j, result);
				}
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------");
		}
	}
}
