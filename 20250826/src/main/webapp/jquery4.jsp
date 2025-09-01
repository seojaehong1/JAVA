<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p id="text">색상을 바꿔보세요</p>
<button id = "colorBtn">색상변경</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$('#colorBtn').click(function(){
		$('#text').css('color', 'blue');
	});
});
</script>
</body>
</html>