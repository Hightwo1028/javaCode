package tw.hightwo.js;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.sound.sampled.LineListener;
import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyPanelV2 extends JPanel {
	private LinkedList<Line> lines, recycle;
	private Color nowColor;

	public MyPanelV2() {
		setBackground(Color.gray);

		lines = new LinkedList<>();
		recycle = new LinkedList<>();

		nowColor = Color.BLACK;
		MyListener myListener = new MyListener();

		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}

	// 內部類別
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();
			Line line = new Line(nowColor, 4);

			Point point = new Point(e.getX(), e.getY());
			line.addPoint(point);

			lines.add(line);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(point);
			;

			repaint();
		}
	}

	// 內部類別結束
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (Line line : lines) {

			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));

			for (int i = 1; i < line.size(); i++) {
				Point p0 = line.getPoint(i - 1);
				Point p1 = line.getPoint(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}
	}

	public void clear() {
		lines.clear();
		repaint();
	}

	public void undo() {
		if (lines.size() > 0) {
			recycle.add(lines.removeLast());
			repaint();
		}
	}

	public void redo() {
		if (recycle.size() > 0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}

	public Color getColor() {
		return nowColor;
	}
	
	public void setColor(Color color) {
		nowColor = color;
	}
}
