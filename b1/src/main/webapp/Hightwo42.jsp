<%@page import="hightwo.tw.apis.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyTest obj = new MyTest();
	int lottery = obj.getLottery();
	session.setAttribute("obj2", obj);
	session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Lottery: <%= lottery %> <br />
Lottery: ${obj2.lottery } <br />
<a href="Hightwo43.jsp">Next: Hightwo43.jsp</a>
</body>
</html>
<%
	obj.setLottery(1000);
%>