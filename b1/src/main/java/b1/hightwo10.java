package b1;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(location = "D:\\eclipse\\b1\\src\\main\\webapp\\upload")
public class hightwo10 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String account = request.getParameter("account");
		
		int count = 0;
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if(part.getName().equals("upload")) {
				if(part.getSize() > 0) {
					String fname = account + "_" + part.getSubmittedFileName();
					try {
						part.write(fname);
						count++;
					} catch (Exception e) {

					}
				}
			}
		}
		response.setContentType("text/html; charset=UTF=8");
		response.getWriter().printf("%d File(s) Upload Success".formatted(count));
	}

}
