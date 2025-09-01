<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 id='a1'>나온다</h1>
<h1 class = 'c1'>나온다222</h1>
<div id="test">

</div>

<script>
let test = document.querySelector('#test'); //태그아이디를 기준으로 값가져오기
test.innerText = "홍길동";

let c1 = document.querySelector('.c1'); //태그아이디를 기준으로 값가져오기
c1.innerText = "김하나";


let a1 = document.querySelector('#a1'); //태그아이디를 기준으로 값가져오기
console.log(a1);
console.log(a1.innerText);
console.log(a1.innerHTML);
console.log(a1.textContent);

let a2 = document.getElementById('a1');       //태그아이디를 기준으로 값가져오기
console.log(a2);
console.log(a2.innerText);
console.log(a2.innerHTML);
console.log(a2.textContent);


</script>
</body>
</html>