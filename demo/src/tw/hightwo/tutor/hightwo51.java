package tw.hightwo.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class hightwo51{

	public static void main(String[] args) {
		hightwo513 obj = new hightwo513();

		try {
			ObjectOutputStream oout = new ObjectOutputStream(
					new FileOutputStream("dir1/test.ok"));
		
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("OK");
			System.out.println("---------");
			
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/test.ok"));
			oin.readObject();
			oin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class hightwo511 implements Serializable {
	hightwo511() {System.out.println("hightwo511()");}
}
class hightwo512 extends hightwo511 {
	hightwo512() {System.out.println("hightwo512()");}
}
class hightwo513 extends hightwo512 {
	hightwo513() {System.out.println("hightwo513()");}
}