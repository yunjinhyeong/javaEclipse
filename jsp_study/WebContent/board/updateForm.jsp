<%@page import="com.exam.vo.BoardVo"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 위에 코드로 인해 response charset utf-8 적용됨 그러니 setCharacterEncoding로 utf-8 해줌 -->
<%
	// 파라미터 찾기 int num, String pageNum 파라미터값 가져오기
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
// DAO 객체준비
BoardDao boardDao = BoardDao.getInstance();
// 글번호에 해당하는 글한개 가져오기
BoardVo boardVo = boardDao.getBoardByNum(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 글수정</h1>
	<hr>
	<form action="updatePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="num" value="<%=num %>">		
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" value="<%=boardVo.getName() %>" required></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="passwd" required></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="<%=boardVo.getSubject() %>" required></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="13" cols="40" name="content" required><%=boardVo.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>