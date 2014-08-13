<%@page import="java.util.List"%>
<%@page import="kt.c.dao.*"%>
<%@page import="kt.c.vo.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세화면(by MVC)</title>
<link rel="stylesheet" href="../css/layout.css" />
<link rel="stylesheet" href="../css/board.css" />
<script>
	function doAction(type) {
		switch(type) {
		case 'U' : 
			location.href = "update.do?no=${param.no}";
			break;
		case 'D' :
			if(!confirm('삭제하시겠습니까?')) {
				return false;
			}
			location.href = "delete.do?no=${param.no}";
			break;
		case 'L' :
			location.href = "list.do";
			break;
		}
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
	<h2>게시판 상세(by MVC)</h2>
	<hr width="80%" />
	<br/>
	
	<table width="80%" border="1">
		<tr>
			<th width="25%">번호</th>
			<td>${ board.no }</td>
		</tr>
		<tr>
			<th width="25%">제목</th>
			<td><c:out value="${ board.title }" /></td>
		</tr>
		<tr>
			<th width="25%">글쓴이</th>
			<td>${ board.writer }</td>
		</tr>
		<tr>
			<th width="25%">내용</th>
			<td>${ board.content }</td>
		</tr>
		<tr>
			<th width="25%">조회수</th>
			<td>${ board.viewCnt }</td>
		</tr>
		<tr>
			<th width="25%">등록일</th>
			<td>${ board.regDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td align="left">
				<c:forEach var="file" items="${ fileList }" >
					<a href="${contextRoot}/upload/${file.fileSaveName }"
						 target="blink" >
						<c:out value="${ file.fileOriName }" />
					</a>&nbsp;
					(${ file.fileSize }byte) <br/>
				</c:forEach>
			</td>
		</tr>
	</table>
	<br/>
	<input type="button" value="수정폼" onclick="doAction('U')" />&nbsp;
	<input type="button" value=" 삭제  " onclick="doAction('D')" />&nbsp;
	<input type="button" value=" 목록  " onclick="doAction('L')" />
</div>
	</div>
	<div id="bottom">
		<%@ include file="/jsp/include/bottom.jsp" %>
	</div>

</body>
</html>