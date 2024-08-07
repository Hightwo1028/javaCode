package tw.hightwo.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class hightwo48 {

	public static void main(String[] args) {

		try (FileInputStream fin = new FileInputStream("dir1/ns1hosp.csv");
//				System.out.println("OK"); 不OK 因為不能有無法自動關閉的敘述句
				InputStreamReader reader = new InputStreamReader(fin);
				BufferedReader br = new BufferedReader(reader);) {

//			FileReader reader = new FileReader("dir1/ns1hosp.csv");

			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				System.out.printf("%s:%s:%s:%s\n", data[1], data[2], data[4], data[7]);
			}

			br.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
