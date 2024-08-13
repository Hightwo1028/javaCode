package tw.hightwo.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private int rank;
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;

	public Racing() {
		super("Racing");
		
		
		//視窗排版建置，建好之後依序塞入
		setLayout((new GridLayout(9, 1)));
		go = new JButton("Go!");
		add(go);
		lanes = new JLabel[8];
		for (int i = 0; i < lanes.length; i++) {//format無法使用中文
			lanes[i] = new JLabel(String.format("Number%d. ", (i + 1)));
			add(lanes[i]);
		}

		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initGame();
	}

	private void initGame() {
	//這是go按鈕	
		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			//這是go方法
				gamestart();
			}
		});
	}

	private void gamestart() {
		rank = 0;
		for(int i = 0; i < lanes.length; i++) {
									//format無法使用中文
			lanes[i].setText(String.format("%d.", (i+1)));
		}
		//全部初始化
		cars = new Car[8];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(i);
		}
		//再一次start   //且會並行運行
		for (int i = 0; i < cars.length; i++) {
			cars[i].start();
		}
	}

	private class Car extends Thread {
		private int lane;
		private StringBuffer path;

		Car(int lane) {
			this.lane = lane;
			path = new StringBuffer(String.format("%d. ", (lane + 1)));
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				path.append(">");
				if(i == 99) {
//					path.append("  第" + (++rank) + "名");
					path.append("    WINNER");
				}
				lanes[lane].setText(path.toString());
				if(i == 99) {
					//大家不要跑
					stopGame();
				}
				try {
					Thread.sleep(10 + (int)(Math.random() * 100));
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	void stopGame() {
		for(int i = 0; i < lanes.length; i++) {
			cars[i].interrupt();
		}
	}
	
	public static void main(String[] args) {
		new Racing();
	}
}
