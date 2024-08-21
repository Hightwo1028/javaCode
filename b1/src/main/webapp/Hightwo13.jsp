<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashSet"%>
<%
   String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Hello, World<br />
	Hello, <% out.print(name); %> <br />
	Hello, <%= (int)(Math.random() * 49 + 1)  %>
	<hr />
		<%
		HashSet<Integer> set = new HashSet<>();
		while (set.size() < 6) set.add((int)(Math.random() * 49 + 1));
		out.print(set);
		%>
	</body>
</html>