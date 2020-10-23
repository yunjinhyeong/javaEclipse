<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 넘겨받은것중 VO에 답겨져 있는건 안받아와도 되고 pageNum만 받아와도됨 + 파라미터값 받아오기 여기선 받아오는코드
String reRef = request.getParameter("reRef"); // 답글을 쓰는 대상글에 대한 정보
String reLev = request.getParameter("reLev"); // 
String reSeq = request.getParameter("reSeq"); // 
String pageNum = request.getParameter("pageNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 답글쓰기</h1>
	<hr>
	<form action="reWritePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="reRef" value="<%=reRef %>">
		<input type="hidden" name="reLev" value="<%=reLev %>">
		<input type="hidden" name="reSeq" value="<%=reSeq %>">
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
				<td><input type="text" name="subject" value="[답글]" required></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="13" cols="40" name="content" required></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답글쓰기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>