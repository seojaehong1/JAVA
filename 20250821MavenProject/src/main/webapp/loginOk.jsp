<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logout" method="post">  
            ${sessionScope.name }님 로그인
            <input type="submit" value="로그아웃">
            <input type="button" value="회원정보 수정" 
                   onclick="window.open('updateread', 'popup', 
                                        'width=400, height=200')">
        </form>
</body>
</html>