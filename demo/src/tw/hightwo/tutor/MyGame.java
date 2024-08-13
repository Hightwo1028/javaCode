package tw.hightwo.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.hightwo.js.GamePanelV2;



public class MyGame extends JFrame {
	private GamePanelV2 panel;
	
	public MyGame() {
	
		setLayout(new BorderLayout());
		panel = new GamePanelV2();
		add(panel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyGame();
	}

}
