package tw.hightwo.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class hightwo52 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("192.168.3.4");
			System.out.println(ip);
		}catch (UnknownHostException e) {
			System.out.println(e);
		}

	}

}
