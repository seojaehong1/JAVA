<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button id = "addItemBtn">항목 추가</button>
<ul id ="List">
</ul>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$('#addItemBtn').click(function(){
		$('#List').append('<li>새항목</li>');
	});
});
</script>
</body>
</html>