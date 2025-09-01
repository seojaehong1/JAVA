<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="">
		<label for="subject" class="hidden">주제</label>
		<input type="text" id = "subject" autofocus/>
		<button>추가</button>
	</form>
	<hr>
	<ul id="itemList"></ul>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		
			
			
		
		
		$(document).ready(function(){
			$('button').click(function(e){
				e.preventDefault();
				$('#itemList').append('<li>' + $('#subject').val()+'</li>')
			});
			
			
		});
		
		
		
	</script>
</body>
</html>