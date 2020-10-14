<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션값 가져오기
String id = (String) session.getAttribute("id");
//세션값 없으면  loginForm.jsp 이동
if(id == null) {
	%>
	<script>
	alert('잘못된 경로 입니다.');
	location.href = 'loginForm.jsp' // sendRedirect을 쓰면 뒤로가기 해도 정보가 없기에 그냥 location으로 이동한다.
	</script>
	<%
	// response.sendRedirect("main.jsp"); // 가진 정보 전부 폐기처분
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
		패스워드: <input type="password" name="passwd"><br>
		<input type="submit" value="패스워드 확인">
	</form>
</body>
</html>