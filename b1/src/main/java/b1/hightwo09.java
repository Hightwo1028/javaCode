package b1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@MultipartConfig(location = "D:\\eclipse\\b1\\src\\main\\webapp\\upload")
public class hightwo09 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("upload");
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getSubmittedFileName());
		String filename = request.getRemoteAddr() + "_" + part.getSubmittedFileName();
		
		if(part.getSize() > 0) {
			part.write(filename);
			out.print("Upload Success");
		}else {
			out.print("Upload Failure");
		}
		
		
	}

}
