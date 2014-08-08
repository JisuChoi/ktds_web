<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
		변경내용: 이미지 파일이나 링크 URL의 상대 경로를 절대 경로로 변경
		단, 웹 애플리케이션 루트 경로는 메소드의 리턴 값을 사용한다.
--%>
<table border="1" width="100%">
	<tr>
		<td rowspan="2" style="width: 204px; height: 33px;">
			<a href="${contextRoot}/index.jsp">
				<img src="${contextRoot}/images/bit_logo.gif" style="border: 0px;"/>
			</a>
		</td>
		<td align="right">
			<a href="javascript:window.external.AddFavorite(
				'http://localhost:9999/mvc01', '첫번째나의웹')">
				즐겨찾기
			</a>
			<c:if test="${ not empty userVO }" >
				${ userVO.id }님으로 로그인 중입니다.
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${ userVO.type eq 'A' }">
			회원관리 ||
			</c:if>
			<a href="${contextRoot}/board/list.do">게시판</a> ||
			<c:choose>
				<c:when test="${empty userVO}">
					회원가입 ||
					<a href="${contextRoot}/auth/login.do">로그인</a> ||
				</c:when>
				<c:otherwise>
					마이페이지 ||
					<a href="${contextRoot}/auth/logout.do">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>