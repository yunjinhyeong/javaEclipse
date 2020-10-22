<%@page import="com.exam.vo.BoardVo"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
BoardDao boardDao = BoardDao.getInstance();
BoardVo boardVo = boardDao.getBoardByNum(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Form</title>
</head>
<body>
	<h1>게시판 수정</h1>
	<hr>
	<form action="updatePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="num" value="<%=num%>">
		<table border="1">
			<tr>
				<td>작성자</td><td><input type="text" name="name" value="<%=boardVo.getName()%>" required></td>
			</tr>
			<tr>
				<td>패스워드</td><td><input type="password" name="passwd" required></td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="subject" value="<%=boardVo.getSubject()%>" required></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea rows="13" cols="40" name="content" required><%=boardVo.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>