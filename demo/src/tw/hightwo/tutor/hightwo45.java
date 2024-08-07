package tw.hightwo.tutor;

import java.io.FileReader;
import java.io.FileNotFoundException;


public class hightwo45 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("./dir1/file1.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}

			fr.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
