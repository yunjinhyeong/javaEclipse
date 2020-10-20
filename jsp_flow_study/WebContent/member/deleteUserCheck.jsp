<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
if(id==null){
	%>
	<script>
	alert('잘못된 경로 입니다.');
	location.href = 'loginForm.jsp'
	</script>
	<%
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteUserCheck</title>
</head>
<body>
	<h1>회원정보 삭제 전 사용자 패스워드 확인</h1>
	<hr>
	<form action="delete.jsp" method="post" id="frm">
		아이디: <input type="text" value="<%=id%>" readonly><br>
		패스워드: <input type="password" name="passwd"><br>
		<input type="submit" value="패스워드 확인">
	</form>
<script src="../js/jquery-3.5.1.js"></script>
<script>
	$('form#frm').submit(function (e){
		let isDelete = confirm('정말 탈퇴하시겠습니까?');
		if(!isDeleter) {
			return false;
		}
		return true;
	});
</script>
</body>
</html>