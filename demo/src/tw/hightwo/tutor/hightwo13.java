package tw.hightwo.tutor;

import tw.hightwo.js.Scooter;


public class hightwo13 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter(); //new創建物件實體
		s1.changeGear(2);
		s1.upSpeed();
		s1.upSpeed();
		s1.upSpeed();
		s1.upSpeed();
		System.out.println(s1.getspeed());
		s1.changeGear(1);
		s1.upSpeed();
		System.out.println(s1.getspeed());
		System.out.println(s1.getColor());
	}

}
