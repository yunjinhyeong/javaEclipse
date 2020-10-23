<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 위에 코드로 인해 response charset utf-8 적용됨 그러니 setCharacterEncoding로 utf-8 해줌 -->
<%
String pageNum = request.getParameter("pageNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 게시판 글쓰기</h1>
	<hr>
	<form action="writePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="passwd" required></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" required></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="filename"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="13" cols="40" name="content" required></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="파일 글쓰기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="글목록" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>