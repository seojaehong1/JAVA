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
	
	<script>
		function newRegister(){
			const newItem = document.createElement("li");
			const subject = document.querySelector("#subject");
			const newText = document.createTextNode(subject.value);
			
			newItem.appendChild(newText);
			
			const itemList = document.querySelector("#itemList");
			itemList.appendChild(newItem);
			
			subject.value ="";
			
			
		}
		
		document.addEventListener("DOMContentLoaded", function(){
			const button = document.querySelector("button");
			button.addEventListener("click", function(e){
				e.preventDefault();
				newRegister();
			});
		
			const itemList = document.querySelector('#itemList');
			itemList.addEventListener('click', (e) => {
				if(event.target.tagName == "LI"){
					if(confirm("삭제하시겠습니까?")){
						e.target.remove();
				}
			}
		});
});		
	</script>
</body>
</html>