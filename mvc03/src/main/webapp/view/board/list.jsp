<%@page import="java.util.List"%>
<%@page import="kt.c.dao.*"%>
<%@page import="kt.c.vo.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="../css/layout.css" />
<link rel="stylesheet" href="../css/board.css" />
<script>
	function goWriteForm() {
		location.href = "write.do";
	}
	
	function doAction(boardNo) {
		<c:choose>
			<c:when test="${not empty userVO}">
				location.href = "detail.do?type=list&no=" + boardNo;
			</c:when>
			<c:otherwise>
				if(confirm("로그인 후 사용가능합니다.\n로그인 페이지로 이동하시겠습니까?"))
					location.href = "../auth/login.do";
			</c:otherwise>
		</c:choose>
	}
</script>

</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</div>
	<div id="content">
		<div align="center">
			<hr width="80%" />
			<h2>게시판 목록(by MVC)</h2>
			<hr width="80%" />
			<br />

			<table width="100%" class="list">
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width="16%">글쓴이</th>
					<th width="20%">등록일</th>
				</tr>

				<c:forEach var="board" items="${ list }" varStatus="loop">
					<tr <c:if test="${loop.count mod 2 == 0 }">class="even"</c:if>>
						<td>${ board.no }</td>
						<td>
							<a href="javascript:doAction('${board.no}')">
						 		<c:out	value="${ board.title }" />
						 	</a>
						 </td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>

			<br />
			<c:if test="${not empty userVO}" >
			<!-- <a href="writeForm.jsp">새글등록</a> -->
			<input type="button" value="새글등록" onclick="goWriteForm()" />
			</c:if>
		</div>
	</div>
	<div id="bottom">
		<%@ include file="/jsp/include/bottom.jsp"%>
	</div>

</body>
</html>