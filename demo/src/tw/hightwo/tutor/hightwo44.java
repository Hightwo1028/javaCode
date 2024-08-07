package tw.hightwo.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class hightwo44 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			byte[] buf = new byte[4*1024];
			
			FileInputStream fin = new FileInputStream("dir1/test1.pdf");
			FileOutputStream fout = new FileOutputStream("dir2/test2.pdf");
			
			int len;
			while ((len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}

			fin.close();
			fout.flush();
			fout.close();
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
