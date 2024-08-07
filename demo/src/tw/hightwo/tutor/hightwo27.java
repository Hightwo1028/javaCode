package tw.hightwo.tutor;

import java.util.HashSet;

import tw.hightwo.js.Bike;

public class hightwo27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet();
		set.add("hightwo");
		set.add(12); // 12 => new Integer(12) auto-boxing 自動封箱
		set.add(12.3); // 12.3 => new double(12.3)
		set.add("hightwo");
		set.add(new Bike());
		System.out.println(set.size());
		System.out.println(set);
	}

}
