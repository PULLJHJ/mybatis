<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<Script>
function goList(){
	const xhr = new XMLHttpRequest();
	xhr.open('GET','/form-input');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			const data = JSON.parse(xhr.responseText);
			document.body.innerHTML += `이름: ${data.name}<br>아이디: ${data.id}<br>비밀번호: ${data.pwd}<br>설명: ${data.desc}<br>성별: ${data.trans}<br>직업: ${data.job}`;
		}
	}
	xhr.send();
}
goList();
</Script>
</body>
</html>