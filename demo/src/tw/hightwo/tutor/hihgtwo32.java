package tw.hightwo.tutor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;

public class hihgtwo32 {
//Set<K> 鍵不重複
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Hightwo");
		map.put("age", 25);
		map.put("gender", true);
		map.put("weight", 80.2);
		
		System.out.println(map.get("age"));
		System.out.println("---");
		Set<String> keys = map.keySet();
		for(String key: keys) {
			System.out.printf("%s => %s\n", key, map.get(key));		
		}
        String pathSeparator = File.separator;
        System.out.println(pathSeparator);
	}

}
