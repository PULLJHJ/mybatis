<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
번호 : ${param.num}<br>
이름: <input type="text" id="name"><br>
나이: <input type="text" id="age"><br>
주소: <input type="text" id="address"><br>
<button onclick="sendObj()">수정</button>

<script>
function sendObj(){
    const updateData = {
        num: ${param.num},
        name: document.querySelector('#name').value,
        age: document.querySelector('#age').value,
        address: document.querySelector('#address').value
    }

    const json = JSON.stringify(updateData);
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/list/update');
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200){
                if(xhr.responseText === '1'){
                    alert('수정완료');
                    location.href = '/views/list';
                } else {
                    alert('수정 실패');
                }
            } 
        }
    }
    xhr.send(json);
}

function goPage(url){
    location.href = url;
}

window.addEventListener('load', function(){
    const xhr = new XMLHttpRequest();

    xhr.open('GET', '/list/one?num=' + ${param.num});
    xhr.onreadystatechange = function(){
    	if(xhr.readyState===4){
			if(xhr.status===200){
				const obj = JSON.parse(xhr.responseText);
				for(const key in obj){
					if(document.querySelector('#' + key)){
						document.querySelector('#' + key).value = obj[key];
                }
            }
        }
    }
    xhr.send();
})
</script>
</body>
</html>
