package tw.hightwo.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.hightwo.js.MyPanelV2;

public class Mysign extends JFrame{
	
	//-------------------------
	private MyPanelV2 myPanel;

	private JButton clear, undo, redo, color; 
	//lineSize;
	//-------------------------

	public Mysign() {
		super("Sign App");

		myPanel = new MyPanelV2();
		//這段代碼設定了 JFrame 的佈局管理器為 BorderLayout，並將 myPanel 添加到 JFrame 的中央區域。
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);

		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
//		lineSize = new JButton("LineSize");
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
//		top.add(lineSize);
		add(top, BorderLayout.NORTH);

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initEvent();
	}

	private void initEvent() {   
		//直接把方法弄出來
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.clear();
			}
		});
		undo.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.undo();
			}
		});
		redo.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.redo();
			}
		});
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
//		lineSize.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				changeLineSize();
//			}
//		});
		
//		clear.addActionListener(this);
//		undo.addActionListener(this);
//		redo.addActionListener(this);
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(null, "Change Color", myPanel.getColor());
		if(newColor != null) {
			myPanel.setColor(newColor);
		}
	}
	
//	private void changeLineSize() {
//		Color newSize = JColorChooser.showDialog(null, "Change Color", myPanel.getColor());
//		if(newSize != null) {
//			myPanel.setColor(newColor);
//		}
//	}

	public static void main(String[] args) {
		new Mysign();
	}
	

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		if(e.getSource() == clear) { //return一個obj
//			System.out.println("1");
//		}else if(e.getSource() == undo) {
//			System.out.println("2");
//		}else if(e.getSource() == redo) {
//			System.out.println("3");
//		}
//	}

}
