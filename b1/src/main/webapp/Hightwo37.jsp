<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:catch var="error">
	<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/iii"
	user="root"
	password="root"
	/>    
	<sql:update var="n1">
		UPDATE
	</sql:update>
 
	<sql:update>
	INSERT INTO member (account, passwd, name) VALUES ('aaa','bbb','AAA')
	</sql:update>
</c:catch>
${error }
</body>
</html>