<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
</head>
<body>
	<div>
		<table id="title"></table>
	</div>
	<button type="button" onclick="loadXMLDocs()">
		버튼
	</button>
	
<script>
function loadXMLDocs(){
	const xmlHttp = new XMLHttpRequest(); //객체생성
	const url = 'ajax';
	xmlHttp.open("GET", url, true); //요청초기화
	xmlHttp.send(); 
	//요청 끝
	
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				const response = JSON.parse(xmlHttp.responseText);
				let tb ="";
				for(let i =0; i< response.length; i++){
					tb += "<tr>";
					tb += "<td>" + response[i].id + "</td>";
					tb += "<td>" + response[i].title + "</td>";
					tb += "</tr>";
				}
				document.getElementById("title").innerHTML = tb;
				//document.getElementById("title").innerHTML = response[0].title;
			}
		}
	};
}
</script>
</body>
</html>