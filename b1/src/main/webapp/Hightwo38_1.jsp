<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/iii"
	user="root"
	password="root"
	/>
<sql:query var="rs">
	SELECT * FROM gift
</sql:query>	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	 共 ${rs.rowCount } 筆資料<hr />
	 <table border="1" width="100%">
	 	<tr>
	 		<th>ID</th>
	 		<th>Name</th>
	 		<th>Address</th>
	 		<th>Pic</th>
	 	</tr>
	 	<c:forEach var="gift" items="${rs.rows }">
	 		<tr>
	 			<td>${gift.id }</td>
	 			<td>${gift.name }</td>
	 			<td>${gift.addr }</td>
	 			<td><img src="${gift.picurl }" width="160px" height="90px" /></td>
	 		</tr>
	 	</c:forEach>
	 </table>
	</body>
</html>