package tw.hightwo.tutor;

import java.awt.desktop.AboutEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ServerCloneException;

import javax.lang.model.element.NestingKind;

public class hightwo56 {

	public static void main(String[] args) {

		try (ServerSocket server = new ServerSocket(9999); Socket socket = server.accept();) {
			String urIP = socket.getInetAddress().getHostAddress();
			
			String fname = String.format("dir2/%s.jpg", urIP);
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fname));
			
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
			byte[] buf = new byte[4 * 1024];
			int len;
			
			while((len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
			System.out.println(urIP + " => OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
