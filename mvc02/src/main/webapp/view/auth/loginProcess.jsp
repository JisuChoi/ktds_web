<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${ userVO.type eq 'A' }">
		<c:set var="message" value="관리자님 환영합니다."/>
	</c:when>
	<c:otherwise>
		<c:set var="message" value="${ userVO.id }님 환영합니다."/>
	</c:otherwise>
</c:choose>
<html>
	<head>
		<script>
			alert('${message}');
			location.href = "${contextRoot}/";
		</script>
	</head>
	<body></body>
</html>