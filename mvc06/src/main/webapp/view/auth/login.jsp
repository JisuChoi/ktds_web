<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인폼</title>

<script>
	function isNull(obj, msg) {
		if(obj.value == "") {
			alert(msg);
			obj.focus();
			return true;
		}	
		return false;
	}

	function chkForm() {
		
		var f = document.lForm;
		
		if(isNull(f.id, '아이디를 입력하세요')) {
			return false;
		}
		if(isNull(f.password, '패스워드를 입력하세요')) {
			return false;
		}
		return true;
	}
</script>


<link rel="stylesheet" href="../css/layout.css" />
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</div>
	<div id="content" align="center">
		<hr width="80%" />
		<h2>로그인(by MVC)</h2>
		<hr width="80%" />
		<br/>
		
		<form name="lForm" action="login.do" method="post" onSubmit="return chkForm()">
		<table width="40%">
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="id" size="30" />
				</td>
			</tr>
			<tr>
				<th>PASS</th>
				<td>
					<input type="password" name="password" size="30" />
				</td>
			</tr>
		</table>
		<br/>
		<input type="submit" value=" 로그인 " />
		</form>
	</div>
	<div id="bottom">
		<%@ include file="/jsp/include/bottom.jsp" %>
	</div>

</body>
</html>