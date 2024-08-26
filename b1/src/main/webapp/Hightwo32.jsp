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
	
	<c:set var="x" value="124" />
	<c:set var="x" value="3211" scope="request" />
	<c:set var="y">777</c:set>
	x = ${x }<br />
	x = ${pageScope.x }<br />
	x = ${requestScope.x }<br />
	y = ${y }<br />
	<hr />
	Hello, World<br />
	<c:out value="Hello, World" /><br />
	<c:out value="${x }" /><br />
	param.x = <c:out value="${param.x }" default="no param" /><br />
	param.x = ${param.x }<br />
	<hr />
	<jsp:useBean id="member" class="hightwo.tw.apis.Member"></jsp:useBean>
	<c:set target="${member }" property="id">1</c:set>
	<c:set target="${member }" property="account"></c:set>
	<c:set target="${member }" property="name"></c:set>
	${member.id } : ${member.account } : ${member.name }<br />
	${member }
	<hr />
	<c:remove var="member"/>
	${member }
	
	
	
	</body>
</html>