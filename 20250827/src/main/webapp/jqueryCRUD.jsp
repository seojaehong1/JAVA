<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>아이템 입력</h2>
<input type="text" id="itemName"  />
<button id = "createItem">Add</button>

<h2>아이템 목록</h2>
<ul id="itemList"></ul>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
$(document).ready(function (){
	loadItems2();
});
$('#createItem').on('click', function(){
	let item = $('#itemName').val();
	$('#itemName').val('');
	$.ajax({url:'http://localhost:3000/todos',
		type:'POST',
		data:JSON.stringify({title : item}),
		contentType:'application/json',
		success:function(){
		alert('데이터입력');
		loadItems2();
	}
	});
	
});
function loadItems2(){
	$.ajax({
		url: 'http://localhost:3000/todos',
		type: 'GET',
		success: function(data){
			$('#itemList').empty();
			for (let i=0; i< data.length; i++){
				let item = data[i];
				
				let listItem = '<li data-id="' + item.id+'">' +
								item.title+
								' <button class="editBtn">Edit</button>' +
								' <button class="deleteBtn">Delete</button>'+
								'</li>';
				$('#itemList').append(listItem);
			}
		}
	});
}
</script>
</body>
</html>