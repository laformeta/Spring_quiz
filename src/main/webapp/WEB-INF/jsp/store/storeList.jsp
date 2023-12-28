<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족</title>
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
	<link rel="stylesheet" type="text/css" href="/css/store/style.css">
</head>
<body>
	<div id="wrap" class="">
		<header class="bg-info d-flex align-items-center">
			<div class="text-white h1 ml-4 font-weight-bold">배탈의 민족</div>
		</header>
		<section>
			<h1>우리동네 가게</h1>
			<c:forEach items="${storeList}" var="storeInfo">
				<a href="#">
					<div class="border border-info" >
						<div class="p-3">
							<div class="h3">${storeInfo.name}</div>
							<div>
							전화 번호 : ${storeInfo.phoneNumber} <br>
							주소 : ${storeInfo.address}
							</div>
						</div>
					</div>
				</a>
			</c:forEach>
		</section>
		<hr>
		<footer>
			<div class="h2 font-weight-bold">우와한 형제</div>
			<div>고객센터 : 000-0000</div>
		</footer>
	</div>
</body>
</html>