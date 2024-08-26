<%@page import="java.rmi.Remote"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	System.out.println(request.getMethod());
//	if(!request.getMethod().equals("POST")){
//		response.sendError(405);
//	}

	String account = request.getParameter("account");
	String[] hoobies = request.getParameterValues("hobby");
	System.out.println(hoobies.length);
	request.getRemoteAddr();
	Locale loc = request.getLocale();
	loc.getDisplayLanguage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Method: ${pageContent.request.method }
	1. ${paramValues.hobby[0] } <br />
	2. ${paramValues.hobby[1] } <br />
	3. ${paramValues.hobby[2] } <br />
	4. ${paramValues.hobby[3] } <br />
	5. ${paramValues.hobby[4] } <br />
	6. ${paramValues.hobby[5] } <br />
	7. ${paramValues.hobby[6] } <br />
	<hr />
	${page.Context.request.remoteAddr }<br />
	${page.Context.request.locale }<br />
	${page.Context.request.locale.diplayLanguage }<br />
</body>
</html>