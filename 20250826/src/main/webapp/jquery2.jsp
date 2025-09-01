<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p id="demo">원래텍스트입니다.</p>
<button id = "changeBtn">텍스트변경</button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$('#changeBtn').click(function(){
		//alert("나온다");
		$('#demo').text("변경되었어");
	});
});
</script>
</body>
</html>