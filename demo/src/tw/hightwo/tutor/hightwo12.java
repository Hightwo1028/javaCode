package tw.hightwo.tutor;

import tw.hightwo.js.Bike;

public class hightwo12 {

	public static void main(String[] args) {
		Bike myBike = new Bike();
		Bike urBike = new Bike();
		System.out.println(myBike.getspeed());
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.downSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		
		System.out.println("-------");
		System.out.println(urBike.getspeed());
		urBike.upSpeed();
		urBike.upSpeed();
		urBike.upSpeed();
		urBike.upSpeed();
		urBike.upSpeed();
		urBike.upSpeed();
		urBike.upSpeed();
		System.out.println(urBike.getspeed());
		
		if(myBike.getspeed() > 10) {
			System.out.println(myBike.getspeed());
			System.out.println("速度超過10囉");
		}
	}

}
