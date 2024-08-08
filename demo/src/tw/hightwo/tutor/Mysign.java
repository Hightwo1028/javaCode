package tw.hightwo.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLockInterruptionException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.hightwo.js.MyPanelV2;

public class Mysign extends JFrame {

	// -------------------------
	private MyPanelV2 myPanel;

	private JButton clear, undo, redo, color, saveObj, loadObj, saveJPEG;
	private JComboBox<Float> strokeSizeComboBox;
	// lineSize;
	// -------------------------

	public Mysign() {
		super("Sign App");

		myPanel = new MyPanelV2();
		// 這段代碼設定了 JFrame 的佈局管理器為 BorderLayout，並將 myPanel 添加到 JFrame 的中央區域。
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);

		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		saveObj = new JButton("Save Object");
		loadObj = new JButton("load Object");
		saveJPEG = new JButton("Save JPEG");
		
		Float[] strokeSizes = {1.0f, 2.0f, 4.0f, 6.0f};
		strokeSizeComboBox = new JComboBox<>(strokeSizes);
		strokeSizeComboBox.setSelectedItem(4.0f);
//		lineSize = new JButton("LineSize");
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
		top.add(saveObj);
		top.add(loadObj);
		top.add(saveJPEG);
		top.add(strokeSizeComboBox);
//		top.add(lineSize);
		add(top, BorderLayout.NORTH);

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initEvent();
	}

	private void initEvent() {
		// 直接把方法弄出來
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
		saveObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
        saveJPEG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveJPEG();
            }
        });
        strokeSizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float selectedWidth = (float) strokeSizeComboBox.getSelectedItem();
                myPanel.setStroke(selectedWidth); // 更新線條寬度
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
		if (newColor != null) {
			myPanel.setColor(newColor);
		}
	}

//	不是static 要有物件才能用
	private void saveObject() {
		JFileChooser jfc = new JFileChooser();
		// null
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			if(file.exists()) {
				int responce = JOptionPane.showConfirmDialog(this, "File exists. Do you want to overwrite it?",
						"Confirm", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if(responce != JOptionPane.YES_OPTION) {
					return;
				}
			}
			
			
			
			try {
				myPanel.saveLines(file);
				JOptionPane.showMessageDialog(null, "Save Success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Save Failure");
			}
		}
	}

	private void loadObject() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				myPanel.loadLines(file);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Load Failure");
			}
		}
	}
	
    public void saveJPEG() {
        JFileChooser jfc = new JFileChooser();
        if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            
			if(file.exists()) {
				int responce = JOptionPane.showConfirmDialog(this, "File exists. Do you want to overwrite it?",
						"Confirm", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if(responce != JOptionPane.YES_OPTION) {
					return;
				}
			}
            
            try {
                BufferedImage image = myPanel.getImage();
                ImageIO.write(image, "JPEG", file);
                JOptionPane.showMessageDialog(null, "Save JPEG Success");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Save JPEG Failure");
            }
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
