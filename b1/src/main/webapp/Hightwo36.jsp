<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:catch>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Properties prop = new Properties();
	prop.put("user", "root");  prop.put("password", "root");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
	String sql = "INSERT INTO member (account, passwd, name) VALUES (?, ?, ?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, "ispan");
	pstmt.setString(2, "123");
	pstmt.setString(3, "iSpan");
	int n = pstmt.executeUpdate();
	pageContext.setAttribute("n", n); // EL => n
%>
</c:catch>
Hello, Hightwo36 <br />
<c:if test="${!empty err }">Server Busy:${err }</c:if>
<c:choose>
	<c:when test="${n > 0 }">Success</c:when>
	<c:otherwise>Failure</c:otherwise>
</c:choose>


</body>
</html>