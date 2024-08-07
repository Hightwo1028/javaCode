package tw.hightwo.tutor;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import tw.hightwo.js.Student;

public class hightwo50 {
//解序列化
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/bard.score");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Object obj = oin.readObject();
			Student s1 = (Student)obj; // 轉型
			System.out.println(s1);
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			
			oin.close();
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
