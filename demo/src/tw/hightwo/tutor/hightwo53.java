package tw.hightwo.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class hightwo53 {

	public static void main(String[] args) {
		String mesg = "Hello, Hightwo";
		byte[] mesgBuf = mesg.getBytes();
		
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(mesgBuf, mesgBuf.length, InetAddress.getByName("10.0.100.101"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
