package tw.hightwo.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.util.spi.LocaleNameProvider;

public class hightwo41 {

	public static void main(String[] args) {
		try {
			File source = new File("./dir1/file2.txt");
			FileInputStream fin = new FileInputStream(source);
			int len; byte[] buf = new byte[(int)source.length()];
			
			fin.read(buf);
			System.out.println(new String(buf));
			
			fin.close();
			System.out.println("");
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
