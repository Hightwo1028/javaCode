package b1;

import java.io.IOException;

import hightwo.tw.apis.MemberDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private MemberDB memberDB = null;// 宣告完成初始化

	public Register() {
		try {
			memberDB = new MemberDB();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (memberDB == null) {
			return;
		}

		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");

		if (!memberDB.isAccountExist(account)) {
			try {
				if (memberDB.addMember(account, passwd, name)) {
					response.sendRedirect("Hightwo17.jsp");
				} else {
					response.sendRedirect("Hightwo16.jsp?errType=3");
				}
			} catch (Exception e) {
				response.sendRedirect("Hightwo16.jsp?errType=2");
			}
		} else { // 帶參數回去，因為我們是動態網頁jsp
			response.sendRedirect("Hightwo16.jsp?errType=2");
		}
	}

}
