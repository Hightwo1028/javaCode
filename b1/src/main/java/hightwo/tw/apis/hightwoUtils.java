package hightwo.tw.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class hightwoUtils {
	public static String loadView(String view) throws Exception {
		String source = String.format("D:\\eclipse\\b1\\src\\main\\webapp\\view\\view1.html", view);
		File viewFile = new File(source);
		int len = (int)viewFile.length();
		byte[] buf = new byte[len];
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(viewFile));
		bin.read(buf);
		bin.close();
		
		return new String(buf);
	}
				//網頁傳回來的參數永遠都是字串
	public static String calc(String x, String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return intX + intY + "";
		} catch (Exception e) {
			return "";
		}
	}
}
