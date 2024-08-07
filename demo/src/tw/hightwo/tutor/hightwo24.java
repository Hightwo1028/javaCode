package tw.hightwo.tutor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class hightwo24 extends JFrame {

	public hightwo24() {

		MyMouseListenerV2 mouseListener = new MyMouseListenerV2();
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);

		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new hightwo24();
	}

}

class MyMouseListenerV2 extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Press");

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(String.format("%d x %d", e.getX(), e.getY()));

	}
}

class MyMouseListener implements MouseListener, MouseMotionListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Press");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Drag");

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
