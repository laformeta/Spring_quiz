<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1) -문제1</title>
</head>
<body>
	<h1>JSTL Core 변수</h1>
	<c:set var="num1" value="36" />
	<c:set var="num2">3</c:set>
	
	<h3>첫번째 숫자: ${num1}</h3>
	<h3>두번째 숫자: ${num2}</h3>
	
	<h1>JSTL Core 연산</h1>
	<h3>더하기: ${num1 + num2}</h3>
	<h3>빼기: ${num1 - num2}</h3>
	<h3>곱하기: ${num1 * num2}</h3>
	<h3>나누기: ${num1 / num2}</h3>
	
	<h1>3. JSTL core out</h1>
	<c:out value="<title>core out</title>" escapeXml="true" />
	
	<h1>4. core if</h1>
	<c:if test="${(num1 + num2) / 2 >= 10}">
		<h1>${(num1 + num2) / 2}</h1>
	</c:if>
	<c:if test="${(num1 + num2) / 2 < 10 }">
		<h3>${(num1 + num2) / 2}</h3>
	</c:if>
	
	<h1>5. core if</h1>
	<c:if test="${num1 * num2 > 100}">
		<c:out value="<script>alert('너무 큰 수 입니다.')</script>" escapeXml="false" />
	</c:if>
</body>
</html>