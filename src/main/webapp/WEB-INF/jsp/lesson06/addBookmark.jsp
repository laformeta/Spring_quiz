<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<%-- AJAX 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="form-group p-3">
		<h1>즐겨 찾기 추가하기</h1>
			<div class="form-group">
				<label for="name">제목</label> 
				<input type="text" class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="url">주소</label> 
				<input type="text" class="form-control" id="url">
			</div>
			<button type="button" id="addBtn" class="btn btn-success form-control" value="추가">추가</button>
	</div>
	
	<script>
		$(document).ready(function () {
			$("#addBtn").on('click', function () {
// 				alert("연결 성공");
				
				// validation check
				let name = $("#name").val();
				if (!name
					// bookmarkName == ""
					// bookmarkName.length < 1
				) {
					alert("추가할 페이지의 즐겨 찾기 이름을 입력하세요");
					return;
				}
				
				let url = $("#url").val();
				if (url == "" ) {
					alert("즐겨 찾기 추가할 페이지 주소를 입력하세요");
					
					return;
				}
				if ((url.startsWith('http://') == false) && (url.startsWith('https://') == false)) {
						alert("즐겨 찾기 추가할 페이지의 url이 잘못되었습니다. 다시 입력해주세요.");
						return;
				}
				
				console.log(name);
				console.log(url);
				
				// AJAX : 비동기로 서버에 요청
				
				$.ajax({
					// request
					type:'post'
					, url:'/lesson06/add-bookmark'
					, data:{"name":name, "url":url}
				
					// response
					, success:function(data) { // call back 함수, data param : 응답값
						
						if (data.code == 200) {
							// 목록 화면으로 이동
							location.href = "/lesson06/bookmark-list-view"; // get 방식 이동
						}
					}
					, error:function(request, status, error) {
						alert(request);
						alert(status);
						alert(error);
					}
					
				}); // AJAX 끝
			}) // click 이벤트 끝
		}); // ready function 끝
	</script>
</body>
</html>