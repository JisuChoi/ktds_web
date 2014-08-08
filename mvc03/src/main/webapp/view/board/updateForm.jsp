<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/layout.css" />
<link rel="stylesheet" href="../css/board.css" />

<script>
	function doAction() {
		location.href = "list.do";
	}
</script>
</head>
<body>
<div id="header" >
	<jsp:include page="/jsp/include/topMenu.jsp" />
</div>
<div id="content" align="center">
	<hr width="80%" />
	<h2>게시물 수정(by MVC)</h2>
	<hr width="80%" />
	<br>
	
	<form action="update.do" method="post">
	<input type="hidden" name="no" value="${ param.no }" />
	<table width="80%">
		<tr>
			<th width="25%">번호</th>
			<td>${ board.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="title" size="50" value="<c:out value="${board.title }" />" />
			</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${ board.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" rows="7" cols="50">${board.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${ board.viewCnt }</td>
		</tr>
	</table>
		<br/>
		<input type="submit" value=" 수정 " />&nbsp;
		<input type="button" value=" 목록 " onclick="doAction()" />
	</form>
</div>
<div id="bottom">
	<%@ include file="/jsp/include/bottom.jsp" %>
</div>
</body>
</html>