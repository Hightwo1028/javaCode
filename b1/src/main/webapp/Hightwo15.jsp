<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Hightwo Big Company</h1>
		<hr />
		<form>
			Start : <input type="number" name="start">
			Row x Column = 
			<input type="number" name="rows" /> x
			<input type="number" name="cols" />
			<input type="submit" value="Change" />
		</form>
		<hr />
		
		<table border="1" width="100%">
		<%
			for (int k=0; k<2; k++){
				out.println("<tr>");
				for (int j=2; j<6; j++){
					int newj = j + k * 4;
					out.println("<td>");
					for (int i=1; i<=9; i++){
						int r = newj * i;
						out.println(String.format("%d x %d = %d<br />", newj, i, r));
					}
					out.println("</td>");
				}
				out.println("</tr>");
			}
		%>
		</table>
	
	</body>
</html>