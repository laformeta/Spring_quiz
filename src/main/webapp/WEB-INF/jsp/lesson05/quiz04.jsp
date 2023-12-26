<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz04</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 리스트</h1>
			<table class="table">
				<thead>
					<tr>
						<th>No</th>
						<th>이름</th>
						<th>전화 번호</th>
						<th>국적</th>
						<th>이메일</th>
						<th>자기소개</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${members}" var="eachmember" varStatus="status">
					<c:set var="eachPhoneNumber" value="${eachmember.phoneNumber}"/>
					<tr>
						<td>${status.count}</td>
						<td>${eachmember.name}</td>
						<td>
						<c:choose>
							<c:when test="${fn:startsWith(eachPhoneNumber, '010')}">
								${eachmember.phoneNumber}
							</c:when>
							<c:otherwise>
								유효하지 않은 전화번호
							</c:otherwise>
						</c:choose>
						</td>
						<td>
						<c:set var="nationality" value="${eachmember.nationality}"/>
							${fn:replace(nationality, '시대 ', '-')}
						</td>
						<td>
							<b>${fn:split(eachmember.email, '@')[0]}</b>@${fn:split(eachmember.email, '@')[1]}
						</td>
						<td>
						<c:set var="introduce" value="${eachmember.introduce}" />
						<c:choose>
							<c:when test="${fn:length(introduce)<= 15}">
								${eachmember.introduce}
							</c:when>
							<c:otherwise>
								${fn:substring(introduce, 0, 15)}...
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>