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
    <div class ="container">
    <h1 onclick="method()" id = "test">안녕</h1>
    	<h1 id = "heading">에피오디아 게뎁</h1>
    	<img src="images/coffee-pink.jpg" alt="커피잔" id="cup" width="200" height="200">
    </div>
    <script type= "text/javascript">
        let heading = document.querySelector('#heading');
        console.log(heading);
        
        let cup = document.querySelector('#cup');
        console.log(cup);
        heading.onclick = () => heading.innerText = "추천! 오늘의 커피";
       	cup.onclick = () => cup.src="images/coffee-blue.jpg";
    
       	let test = document.querySelector('#test');
    	function method(){
    		test.innerText = '나온다!';
    		
    	}   	
    	
    
    	
    </script>
</body>
</html>