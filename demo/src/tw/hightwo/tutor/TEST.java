package tw.hightwo.tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
 
public class TEST extends JFrame{
    private static PrintWriter out;
    private static JTextArea messageArea;
    private static JTextField messageField;
 
    public static void main(String[] args) {
        try {
        	JFrame frame = new JFrame("Chat Client");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
     
            messageArea = new JTextArea();
            messageArea.setEditable(false);
            frame.add(new JScrollPane(messageArea), BorderLayout.CENTER);
     
            messageField = new JTextField();
            frame.add(messageField, BorderLayout.SOUTH);
     
            messageField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String message = messageField.getText();
                    out.println(message);
                    messageField.setText("");
                }
            });
     
            frame.setVisible(true);
     
            try {
                Socket socket = new Socket("10.0.100.136", 12345);
                out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     
                while (true) {
                    String message = in.readLine();
                    messageArea.append(message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
     
		} catch (Exception e) {
			System.out.println(e);
		}
}
}