package tw.hightwo.js;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanelV2 extends JPanel {
	private BufferedImage[] ballImgs;
	private int ballW, ballH, viewW, viewH;
	private Timer timer;
	private LinkedList<BallTask> balls;
	
	public GamePanelV2() {
		setBackground(Color.YELLOW);
		
		//把所有變數都需要讀取的讀取，然後賦值
		try {
			ballImgs = new BufferedImage[]{
					ImageIO.read(new File("dir1/ball0.png")),
					ImageIO.read(new File("dir1/ball1.png")),
					ImageIO.read(new File("dir1/ball2.png")),
					ImageIO.read(new File("dir1/ball3.png"))};
			
			ballW = ballImgs[0].getWidth();
			ballH = ballImgs[0].getHeight();
		} catch (IOException e) {
		}
		
		balls = new LinkedList<>();
		
		addMouseListener(new MyListener());
		timer = new Timer();
		timer.scheduleAtFixedRate(new RefreshView(), 0, 16);
	}
	//MyListener 類別覆寫了 MouseAdapter 的 mouseClicked 方法
	private class MyListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			//原本的寬 - 一個球尺寸的一半 = 
			int ex = e.getX() - (int)(ballW / 2.0);
			int ey = e.getY() - (int)(ballH / 2.0);
			
			BallTask ball = new BallTask(ex, ey);
			timer.scheduleAtFixedRate(ball, 100, 30);
			balls.add(ball);
			
		}
	}	
	
	private class RefreshView extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	//BallTask 是一個內部類別，繼承了 TimerTask，這樣它就可以被 Timer 調度並定期執行。
	private class BallTask extends TimerTask {
		private int x, y, dx, dy;
		private int img;
		
		public BallTask(int x, int y) {
			this.x = x; this.y = y;
			dx = (int)(Math.random()*9) - 4;	// -4 ~ +4
			dy = (int)(Math.random()*9) - 4;	// -4 ~ +4
			img = (int)(Math.random()*4);
			System.out.printf("%d : %d", dx, dy);
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getImg() {
			return img;
		}

		@Override
		public void run() {
			if (x < 0 || x + ballW > viewW) {
				dx *= -1;
				x = x < 0 ? 1 : viewW - ballW;
			}else {
				x += dx;				
			}
			
			if (y < 0 || y + ballH > viewH) {
				dy *= -1;
				y = y < 0 ? 1 : viewH - ballH;
			}else {
				y += dy;			
			}
			
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); 
		viewH = getHeight();
		
		for (BallTask ball : balls) {
			g.drawImage(ballImgs[ball.getImg()], ball.getX(), ball.getY(), null);
		}
		
	}	

}