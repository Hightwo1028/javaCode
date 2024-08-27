<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="H" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="iii% %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<H:tag2 />
		<hr />
		<H:tag1 />
		Lottery: <H:lottery /> <br/> <hr/>
		
		<table width="100%" border="1">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>	
			<H:item name="iPhone" price="3,000"/>
			<H:item name="Mouse" price="100"/>
			<H:item name="Mic" price="2,000"/>
			<H:item name="NB" price="40,000"/>
			<hr />
			<iii:hello name="Hightwo" />
		</table>
	</body>
</html>