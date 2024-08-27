<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (request.getMethod().equals("GET")){
		try{
			int max = Integer.parseInt(request.getParameter("max"));
			out.print((int)(Math.random()*max+1));
		}catch(Exception e){
			out.print("input a number, pls");
		}
	}else{
		out.print("what r u doing");
	}
%>