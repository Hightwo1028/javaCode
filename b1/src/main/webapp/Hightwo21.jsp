<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	
    	int max = Integer.parseInt(request.getParameter("max"));
   		String name = request.getParameter("name");
    	request.setAttribute("name", "Hightwo");
    	request.setAttribute("max", max);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	I am Hightwo21 <br/>
 	<jsp:forward page="Hightwo22.jsp"></jsp:forward>
</body>
</html>