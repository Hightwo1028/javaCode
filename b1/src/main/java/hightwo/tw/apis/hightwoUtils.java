package hightwo.tw.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

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
	public static String calc(String x, String y, String op) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			StringBuffer sb = new StringBuffer();
			switch(op) {
			case "1": sb.append(intX + intY); break;
			case "2": sb.append(intX - intY); break;
			case "3": sb.append(intX * intY); break;
			case "4": 
				sb.append(intX / intY).append(" ...... ").append(intX % intY);
				break;
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}
	public static LinkedList<HashMap<String, String>> parseFood(String json) {
		LinkedList<HashMap<String, String>> items = new LinkedList<>();
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			HashMap<String, String> item = new HashMap<>();
			item.put("aid", row.getString("ID"));
			item.put("aname", row.getString("Name"));
			item.put("acity", row.getString("City"));
			item.put("atown", row.getString("Town"));
			item.put("apicurl", row.getString("PicURL"));
			item.put("alat", row.getString("Latitude"));
			item.put("alng", row.getString("Longitude"));
			items.add(item);
		}
		
		return items;
	}
	
}
