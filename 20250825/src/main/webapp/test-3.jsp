<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = "container">
<img src="images/cat.jpg" id = "cat">
</div>
	<script>
	let cat = document.query.querySelector('#cat');
    cat.onclick = () => alert("이미지를 클릭했습니다.");
    </script>
</body>
</html>