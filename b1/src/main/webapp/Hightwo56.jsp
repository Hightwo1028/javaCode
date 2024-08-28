<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="hello" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<hello:hello name="Hightwo" /> <br/>
		<hello:hello name="${param.x }" /> <br/>
		<hello:hello>
			<br />
			My test
			<br />
			<%
				out.print("I am JSP");
			%>
		</hello:hello>
	</body>
</html>