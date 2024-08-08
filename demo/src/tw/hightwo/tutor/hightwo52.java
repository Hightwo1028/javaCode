package tw.hightwo.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class hightwo52 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("www.iii.org.tw");
			System.out.println(ip);
		}catch (UnknownHostException e) {
			System.out.println(e);
		}

	}

}
