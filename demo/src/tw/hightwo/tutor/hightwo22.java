package tw.hightwo.tutor;

public class hightwo22 {

	public static void main(String[] args) {
		hightwo221 obj1 = new hightwo222();
		hightwo223 obj2 = new hightwo222();
		hightwo222 obj3 = new hightwo222();
		obj1.m1();  //只有1,2
		obj2.m3();  //只有3.4
		obj3.m1();	//全部都有
	}

}
		//定義介面
interface hightwo221 {
	//傳回  輸入   基本介面裡面沒有實作
	void m1();
	void m2();
}
interface hightwo223 {
	//傳回  輸入   基本介面裡面沒有實作
	void m3();
	void m4();
}
class hightwo222 implements hightwo221, hightwo223 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
