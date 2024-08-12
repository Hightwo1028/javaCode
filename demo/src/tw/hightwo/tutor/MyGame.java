package tw.hightwo.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.hightwo.js.GamePanel;

public class MyGame extends JFrame {
	private GamePanel panel;
	
	public MyGame() {
		setLayout(new BorderLayout());
		panel = new GamePanel();
		add(panel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyGame();
	}
}
