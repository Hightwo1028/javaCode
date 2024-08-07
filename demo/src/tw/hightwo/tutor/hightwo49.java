package tw.hightwo.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import tw.hightwo.js.Student;

public class hightwo49 {

	public static void main(String[] args) {
		Student s1 = new Student("Hightwo", 40, 72, 53);
		System.out.println(s1);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		s1.getBike().upSpeed();
		System.out.println(s1.getBike().getspeed());
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/bard.score");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(s1);
			
			oout.flush();
			oout.close();
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
