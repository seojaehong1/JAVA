<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie ck = new Cookie("userId","test");
ck.setMaxAge(30);
response.addCookie(ck);

Cookie[] list = request.getCookies();
if(list != null){
	for(Cookie cookie : list){
		out.println(cookie.getName() + "=");
		out.println(cookie.getValue() + "<br/>");
	}
}

%>
</body>
</html>