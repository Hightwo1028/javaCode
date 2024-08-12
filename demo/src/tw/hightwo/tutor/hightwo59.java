package tw.hightwo.tutor;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class hightwo59 {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("dir2/chiikawaNet.jpg");
			
			URL url = new URL("https://img.shoplineapp.com/media/image_clips/663c4f083bac74001d4b9bf6/original.jpg?1715228423");
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());

			byte[] buf = new byte[4 * 1024]; int len;
			while((len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			bin.close();
			
			fout.flush();
			fout.close();
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
