package tw.hightwo.tutor;

import java.io.File;
import java.security.spec.ECFieldF2m;

public class hightwo33 {

	public static void main(String[] args) {
		File f1 = new File("D:\\dir2");
		File f2 = new File("D:/test1");
		if(f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			f1.mkdir();
		}
		
		File nowDir	= new File(".");
		System.out.println(nowDir.getAbsolutePath());
	}

}
