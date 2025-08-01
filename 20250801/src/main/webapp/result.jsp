<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   
   String str = request.getParameter("val1");
   int a = Integer.parseInt(str);
   for(int i=1; i<=9; i++){

	   %>
	    
	   <%= a%> * <%= i%> =  <%= a*i%> <br/>
	<%    
   }
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>