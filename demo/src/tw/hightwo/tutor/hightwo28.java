package tw.hightwo.tutor;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;
public class hightwo28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> power = new TreeSet<Integer>();
		while(power.size() < 6) {
			power.add(new Random().nextInt(1, 39));
			
		}
		
		System.out.println(power);
	}

}
