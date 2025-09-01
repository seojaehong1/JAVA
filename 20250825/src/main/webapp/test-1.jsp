<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div id ="detail">
        <ul>
            <li>원산지 : 에디오피아</li>
            <li style="display: none;">지 역 : 이르가제프 코체레</li>
            <li style="display: none;">농 장 : 게뎁</li>
        </ul>
    </div>
    <script>
        let detail = document.querySelector('#detail > ul');
        console.log(detail.innerText);
        console.log(detail.innerHTML);
        console.log(detail.textContent);
    </script>
</body>
</html>