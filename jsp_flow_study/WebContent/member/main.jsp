<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
if(id==null){
	%>
	<script>
		alert('로그인 후 접근 간으한 페이지 입니다.');
		location.href = 'loginForm.jsp';
	</script>
	<%
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h1>메인페이지</h1>
	<%=id %> 님이 로그인 하셨습니다.<br>
	<hr>
	<input type="button" value="로그아웃" onclick="location.href='logout.jsp'"><br>
	<a href="info.jsp">회원정보 조회</a><br>
	<a href="updateUserCheck.jsp">회원정보 수정</a><br>
	<a href="deleteUserCheck.jsp">회원정보 삭제</a><br>
<%
if(id.equals("admin")){
	%>
		<a href="list.jsp">전체 회원목록 조회</a><br>
	<%
}
%>
</body>
</html>