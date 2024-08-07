package tw.hightwo.js;
//建構式是在物件初始化，不是創建物件實體

//在java裡面，所有類別都一定有建構式 有 跟 定義是兩回事
public class Scooter extends Bike {
	private int gear;
	private String color;
	
	public Scooter() {    //建構式
		System.out.println("Scooter()");
		color = "Yellow";  //在這初始化
	}
	
	public Scooter(String color) {
		// super();
		System.out.println("Scooter(String)");
		this.color = color;
	}
	
	public void changeGear(int gear) {
		if(gear >= 0 && gear <= 4) {
			this.gear = gear;
		}
	}
	
	public void upSpeed() {
		if(gear > 0) {
			speed = speed < 1 ? 1 : speed * 1.8 * gear;
		}
	}
	
	public String getColor() {
		return color;
	}
}