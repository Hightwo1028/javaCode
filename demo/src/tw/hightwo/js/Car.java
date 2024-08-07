package tw.hightwo.js;
//沒有定義建構式 會把父親沒傳參數的建構式給子使用

//1.所有類別一定有建構式
//2.建構式 (1) 祖宗全部完成初始化 (2) 自己初始化
public class Car extends Scooter {
	public Car(int a) {
		//super();
		super("");
		System.out.println("Car(int)");
	}
}
