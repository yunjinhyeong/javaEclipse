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
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정 전 사용자 패스워드 확인</h1>
	<hr>
	<form action="updateUserCheckPro.jsp" method="post">
		아이디: <input type="text" value="<%=id %>" readonly><br>
		패스워드 : <input type="password" name="passwd"><br>
		<input type="submit" value="패스워드 확인">
	</form>
</body>
</html>