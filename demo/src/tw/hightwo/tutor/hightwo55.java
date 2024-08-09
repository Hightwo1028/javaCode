package tw.hightwo.tutor;

import java.awt.desktop.AboutEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.net.InetAddress;
import java.net.Socket;

public class hightwo55 {

	public static void main(String[] args) {
		File source = new File("dir1/chiikawa.jpg");
		//BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source))：
		//建立了一個 BufferedInputStream 來讀取檔案的內容，
		//使用 FileInputStream 作為底層輸入流。
		
		//Socket client = new Socket(InetAddress.getByName("10.0.100.136"), 9999)：
		//建立了一個 Socket 物件，並連接到位於 IP 地址 10.0.100.136 的伺服器，使用埠號 9999。
				
		//BufferedOutputStream bout = new BufferedOutputStream
		//(client.getOutputStream())：使用 Socket 的輸出流建立了一個 BufferedOutputStream，
		//用於將資料發送到伺服器。
		try (	BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
				Socket client = new Socket(InetAddress.getByName("10.0.100.136"), 9999);
				BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());) {

			byte[] buf = new byte[(int)source.length()];
			bin.read(buf);
			bout.write(buf);
			

			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
