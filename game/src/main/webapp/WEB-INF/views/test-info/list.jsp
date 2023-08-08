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
			<option value="1">번호</option>
			<option value="2">이름</option>
		</select> 
		<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
		<button onclick="loadFunc()">검색</button>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">설명</th>
				</tr>
			</thead>
			<tbody id="tBody"></tbody>
				<tr>
					<td colspan="3" align="right">
						<button type="button" class="btn btn-primary"
							onclick="goPage('/test-info/insert')">등록</button>
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
    
    let url = '/test-info/list?';
    if (searchStr.value !== '') {
        url += 'searchType=' + searchType.value + '&searchStr=' + searchStr.value;
    }

    console.log("Fetching data from URL:", url);

    xhr.open('GET', url);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            console.log("Response status:", xhr.status);
            if (xhr.status === 200) {
                const list = JSON.parse(xhr.responseText);
                console.log("Fetched data:", list);
                let html = '';
                for (const test of list) {
                    html += '<tr>';
                    html += '<td>' + test.tiNum + '</td>';
                    html += '<td>' + test.tiName + '</td>';
                    html += '<td>' + test.tiDesc + '</td>';
                    html += '</tr>';
                }
                document.querySelector('#tBody').innerHTML = html;
            }
        }
    }
    xhr.send();
}

window.addEventListener('load', loadFunc);

		
	</script>
</body>
</html>