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
	<hr>
	<form>
		start : <input type="number" name="start">
		Row x Column = 
		<input type="number" name="rows" /> x
		<input type="number" name="cols" />
		<input type="submit" name="Change" />
	</form>

	<table border="1" width="100%">

			<%
			for(int k = 0; k < 1 ; k++){
				out.println("<tr>");
				for (int n = 2; n <= 5; n++) {
					out.println("<td>");
					for (int i = 1; i <= 9; i++) {
						int r = n * i;
						out.println(String.format("%d x %d = %d<br />", n, i, r));
					}
					out.println("</td>");
				}
				out.println("</tr>");
				for (int n = 6; n <= 9; n++) {
					out.println("<td>");
					for (int i = 1; i <= 9; i++) {
						int r = n * i;
						out.println(String.format("%d x %d = %d<br />", n, i, r));
					}
					out.println("</td>");
				}

			}


			%>
	</table>
</body>			
</html>