package b1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class hightwo17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String source = "D:\\eclipse\\b1\\src\\main\\webapp\\upload\\OK.jpg";
		BufferedImage img = ImageIO.read(new File(source));
		Graphics2D g2d = img.createGraphics();
		
		Font font1 = new Font(null, Font.BOLD, 72);
		AffineTransform af = new AffineTransform();
		af.rotate(Math.toRadians(30));
		Font font2 = font1.deriveFont(af);
		
		g2d.setColor(Color.red);
		g2d.setFont(font2);
		
		g2d.drawString("Hightwo", 100, 400);
		
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
		ImageIO.write(img, "JPEG", new File("d:/hightwo/practice.jpg"));
	}


}
