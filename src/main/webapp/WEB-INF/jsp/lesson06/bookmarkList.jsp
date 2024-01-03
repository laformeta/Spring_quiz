<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>

		<table class="table text-center">
			<thead>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookmarkList}" var="bookmark">
					<tr>
						<td>${bookmark.id}</td>
						<td>${bookmark.name}</td>
						<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td>
						<td>
							<%-- 1) 버튼에 value로 값 넣기 --%> <%-- <button type="button" class="del-btn btn btn-danger" value="${bookmark.id}">삭제</button> --%>
							<%-- 2) data로 값 넣기 --%>
							<button type="button" class="del-btn btn btn-danger"data-bookmark-id<%-- data뒤에는 항상 하이픈으로 이름을 짓는다(대문자 x) --%>="${bookmark.id}">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		$(document).ready(function() {
			$('.del-btn').on('click', function(e) {
				// 1) 버튼에 담긴 value 값 가져오기
				// let id = $(this).val(); 
				// let id = $(this).attr("value");
				// let id = e.target.value;

				// 2) data로 값 가져오기
				// 태그 영역 : data-bookmark-id
				// script 영억 : data('bookmark-id')
				let id = $(this).data('bookmark-id');
				// 			alert(id);

				$.ajax({
					// 요청
					type : 'delete',
					url : "/lesson06/delete-bookmark",
					data : {
						"id" : id
					}

					// 응답
					,
					success : function(data) {
						if (data.code == 200) {
							// 성공
							location.reload(/*true*/); // 새로고침
						} else if (data.code == 500) {
							// 실패
							alert(error_message);
						}
					},
					error : function(request, status, error) {
						alert("삭제 실패(ajax error).");
					}

				});
			});
		});
	</script>
</body>
</html>