<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
</head>
<body>
	<h3>게시판</h3>
		<select name="searchType" id="searchType">
			<option value="1">이름</option>
			<option value="2">아이디</option>
		</select> 
		<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
		<button onclick="loadFunc()">검색</button>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">아이디</th>
					<th scope="col">생년월일</th>
					<th scope="col">가입일자</th>
				</tr>
			</thead>
			<tbody id="tBody"></tbody>
				<tr>
					<td colspan="5" align="right">
						<button type="button" class="btn btn-primary"
							onclick="goPage('/board-info/insert')">등록</button>
					</td>
				</tr>
		</table>
	</div>
	<script>
		function goPage(url) {
			location.href = url;
		}
		// html에 있는 ajax.html을 받아오는 과정 그러나 56라인에서 원래 html에서는 ``을 썼는데 jsp에서는 ``을 쓰면안돼고 +board.?을 사용해서 데이터를 받아와야 함.
		const loadFunc = function () {
		    const xhr = new XMLHttpRequest();
		    const searchStr = document.querySelector('#searchStr');
		    const searchType = document.querySelector('#searchType');
		    
		    let url = '/user-info/list?';
		    if(searchStr.value!==''){
		    	url += 'searchType=' + searchType.value + '&searchStr=' + searchStr.value;
		    }

		    xhr.open('GET', url);
		    xhr.onreadystatechange = function () {
		        if (xhr.readyState === 4 && xhr.status === 200) {
		            const list = JSON.parse(xhr.responseText);
		            let html ='';
		            for(const user of list){
		                console.log(user.uiNum);
		                html += '<tr>';
		                html += '<td>' + user.uiNum + '</td>';
		                html += '<td><a href="/views/user-info/view?uiNum=' + user.uiNum + '">' + user.uiName + '</a></td>';
		                html += '<td>' + user.uiId + '</td>';
		                html += '<td>' + user.uiBirth + '</td>';
		                html += '<td>' + user.credat + '</td>';
		                html += '</tr>';
		            }
		            document.querySelector('#tBody').innerHTML = html;
		        }
		    }
		xhr.send();
		}
		window.addEventListener('load',loadFunc);
		
	</script>
</body>
</html>