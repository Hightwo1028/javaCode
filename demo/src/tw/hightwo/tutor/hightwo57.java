package tw.hightwo.tutor;

import java.net.ServerSocket;
import java.net.Socket;


public class hightwo57 {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(8888);
				Socket socket = server.accept();){
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
