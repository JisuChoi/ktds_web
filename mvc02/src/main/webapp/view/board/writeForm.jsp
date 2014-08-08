<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글등록</title>
<link rel="stylesheet" href="../css/layout.css" />
<link rel="stylesheet" href="../css/board.css" />
<script>
	function doList() {
		location.href = "list.do";
	}
	
	function doWrite() {
		var f = document.wForm;
		if(f.title.value == "") {
			alert('제목을 입력하세요');
			f.title.focus();
			return false;
		}
		if(f.content.value == "") {
			alert('내용을 입력하세요');
			f.content.focus();
			return false;
		}
		
		// 금지 파일 확장자 체크
		var forbidName = ['exe', 'java', 'bat', 'jsp', 'js'];
		var fileName = f.attachFile1.value;	// test.java
		
		if(fileName != "") {
			var ext = fileName.substr(fileName.lastIndexOf(".") + 1);

			for(var i = 0; i < forbidName.length; i++) {
				if(forbidName[i] == ext) {
					alert(ext + '확장자는 파일업로드 정책에 위배됩니다.');
					return false;
				}
			}
		}
		
		return true;
	}
	
</script>
</head>
<body>
<div id="header">
		<jsp:include page="/jsp/include/topMenu.jsp" />
</div>
<div id="content" align="center">
	<hr width="80%" />
	<h2>게시판 등록(by MVC)</h2>
	<hr width="80%" />
	<br/>
	
	<form name="wForm" action="write.do" 
					   method="post"
					   enctype="multipart/form-data"
					   onsubmit="return doWrite()">

	<table width="80%" border="1">
		<tr>
			<th width="23%">제목</th>
			<td align="left">
				<input type="text" name="title" size="40" />
			</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td align="left">
				${ userVO.id }
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td align="left">
				<textarea name="content" rows="7" cols="40"></textarea>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td align="left">
				<input type="file" name="attachFile1" size="40" /><br/>
				<input type="file" name="attachFile2" size="40" />
			</td>
		</tr>
	</table>
	<br/>
	
	<input type="submit" value="새글 등록" />
	<input type="button" value="목록으로 이동" onclick="doList()"/>
	
	</form>
	
	
</div>
	<div id="bottom">
		<%@ include file="/jsp/include/bottom.jsp" %>
	</div>
</body>
</html>