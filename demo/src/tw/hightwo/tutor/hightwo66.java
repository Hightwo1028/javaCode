package tw.hightwo.tutor;

import org.mindrot.BCrypt;

public class hightwo66 {

	public static void main(String[] args) {
		String passwd = "123456";
		String newpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		String newpasswd1 = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(newpasswd);
		System.out.println(newpasswd1);
		System.out.println(newpasswd.length());
		
		if(BCrypt.checkpw("123456", newpasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
