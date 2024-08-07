package tw.hightwo.tutor;

import java.util.LinkedList;
import java.util.List;

public class hightwo31 {

	public static void main(String[] args) {
		List<String> times = new LinkedList<String>();
		times.add(0, "10:20:30"); // 新的插前面，剩的擠下去>
		times.add(0, "10:20:34"); // 就可以把這個List倒敘
		times.add(0, "10:20:37");
		times.add(0, "10:20:47");
		times.add(0, "10:20:51");
		times.add(0, "10:20:59");
		System.out.println("----");

		for (String time : times) {
			System.out.println(time);
		}
	}

}
