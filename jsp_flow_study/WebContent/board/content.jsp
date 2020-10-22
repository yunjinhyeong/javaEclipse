<%@page import="com.exam.vo.BoardVo"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
BoardDao boardDao = BoardDao.getInstance();
boardDao.updateReadcount(num); // num을 증가시키는게 아니라 num으로 어느 번호 글인지 안다음 + readCount함
BoardVo boardVo = boardDao.getBoardByNum(num);
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<h1>글 상세보기</h1>
	<hr>
	<table border="1">
		<tr>
			<th>글번호</th><td><%=boardVo.getNum() %></td>
			<th>조회수</th><td><%=boardVo.getReadcount() %></td>
		</tr>
		<tr>
			<th>작성자</th><td><%=boardVo.getName() %></td>
			<th>작성일</th><td><%=boardVo.getRegDate() %></td>
		</tr>
		<tr>
			<th>글제목</th><td colspan="3"><%=boardVo.getSubject() %></td>
		</tr>
		<th>파일</th>
		<td colspan="3">
			<%
			if(boardVo.getFile() != null) {
				// 첨부 파일이 있으면 보여달라
				String filename = boardVo.getFile();
				%>
				<a href="../upload/<%=filename %>"><%=filename %></a>
				<%
				// 그림일때 보여주는 코드
				if(filename.endsWith(".jpg") || filename.endsWith(".gif")
						|| filename.endsWith(".png") || filename.endsWith(".jpeg")) {
					%>
					<br>
					<img alt="이미지 로드 못함" src="../upload/<%=filename %>" width="100" height="100">
					<%
				}
			}
			%>
		</td>
		<tr>
			<th>글내용</th><td colspan="3"><pre><%=boardVo.getContent() %></pre></td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="글수정" onclick="location.href='update.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">
				<input type="button" value="글삭제" onclick="location.href='deleteForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">
				<input type="button" value="답글쓰기" onclick="location.href='reWriteForm.jsp?reRef=<%=boardVo.getReRef() %>&reLev=<%=boardVo.getReLev() %>&reSeq=<%=boardVo.getReSeq() %>&pageNum=<%=pageNum %>'">
				<input type="button" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
			</td>
		</tr>
	</table>
</body>
</html>