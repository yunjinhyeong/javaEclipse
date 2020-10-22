<%@page import="com.exam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardDao boardDao = BoardDao.getInstance();
int count = boardDao.getCount(); // 전체 글 갯수
int pageSize = 10; // 한페이지당 보여줄 글갯수
String strPageNum = request.getParameter("pageNum");
strPageNum = (strPageNum == null)? "1" :strPageNum;
int pageNum = Integer.parseInt(strPageNum);
int startRow = (pageNum-1)*pageSize;
List<BoardVo> boardList = null;
if(count > 0) { boardList = boardDao.getBoards(startRow, pageSize); }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<h1>글목록 전체글갯수: <%=count %></h1>
	<hr>
	<h3><a href="writeForm.jsp">글쓰기</a></h3>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>IP</th>
			</tr>
		</thead>
		<tbody>
		<%
		if(count>0) {
			for(BoardVo boardVo : boardList) {
				%>
				<tr>
					<td><%=boardVo.getNum() %></td>
					<td>
						<%
						if(boardVo.getReLev() > 0) {
							%>
							<img alt="" src="../images/level.gif" width="<%=boardVo.getReLev() * 15%>" height="10px">
							<img alt="" src="../images/icon_re.gif">
							<%
						}
						%>
						<a href="content.jsp?num=<%=boardVo.getNum() %>&pageNum=<%=pageNum%>"><%=boardVo.getSubject() %></a>
					</td>
					<td><%=boardVo.getName() %></td>
					<td><%=boardVo.getRegDate() %></td>
					<td><%=boardVo.getReadcount() %></td>
					<td><%=boardVo.getIp() %></td>
				</tr>
				<%
			}
		} else {
			%>
			<tr>
				<td colspan="6">게시판 글 없음</td>
			</tr>
			<%
		}
		%>
		</tbody>
	</table>
	<%
	if(count>0) {
		// 전체 페이지 갯수 (전체/10)+(전체%10==0?0:1)  ex) 22
		int pageCount = (count/pageSize) + (count % pageSize == 0 ? 0 : 1 );
		// 한 화면에 보여줄 페이지버튼 갯수
		int pageBlock = 5;
		// (0)*5+1=1
		int startPage = ((pageNum / pageBlock) - (pageNum % pageBlock == 0 ? 1 : 0 )) * pageBlock + 1;
		// end = 4
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		// [이전]
		if(startPage > pageBlock) {
			%>
			<a href="list.jsp?paegNum=<%=startPage - pageBlock %>">[이전]</a>
			<%
		}
		// 1~5 출력
		for(int i=startPage ; i<=endPage ; i++) {
			if(i == pageNum) {
				%>
				<a href="list.jsp?pageNum=<%=i%>" class="active">[<%=i %>]</a>
				<%
			} else {
				%>
				<a href="list.jsp?pageNum=<%=i%>">[<%=i %>]</a>
				<%
			}
		}
		// [다음]
		if(endPage < pageCount) {
			%>
			<a href="list.jsp?pageNum=<%=startPage + pageBlock%>">[다음]</a>
			<%
		}
	}
	%>
</body>
</html>