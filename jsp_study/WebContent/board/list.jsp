<%@page import="com.exam.vo.NoticeVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// DAO 객체준비
NoticeDao boardDao = NoticeDao.getInstance();
// 전체 글갯수 가져오기
int count = boardDao.getCount();
// 한페이지당 보여줄 글갯수 설정
int pageSize = 10;
// 사용자가 요청하는 페이지번호 파라미터값 가져오기
String strPageNum = request.getParameter("pageNum"); // 파라미터로 넘어온값은 무조건 String
// 사용자 요청 페이지 번호 정보가 없을때(null 일때)
// 기본 요청 페이지 번호를 1페이지로 설정하기
strPageNum = (strPageNum == null) ? "1" : strPageNum;
// 사용자 요청 페이지를 정수로 변환
int pageNum = Integer.parseInt(strPageNum);
// 가져올 첫행번호 구하기
int startRow = (pageNum - 1)*pageSize;
// 글목록 가져오기
List<NoticeVo> boardList = null;
if(count>0) {
	boardList = boardDao.getBoards(startRow, pageSize);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 600px;
}
th.subject {
	width: 250px;
}
a.active {
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>글목록(전체글갯수: <%=count%>)</h1>
	<hr>
	<h3><a href="writeForm.jsp">글쓰기</a></h3>
	<h3><a href="fileWriteForm.jsp">파일 글쓰기</a></h3>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th><th>IP</th>
			</tr>
		</thead>
		<tbody>
		<%
			if (count > 0) {
			for (NoticeVo boardVo : boardList) {
		%>
				<tr>
					<td><%=boardVo.getNum() %></td>
					<td>
						<%
						if(boardVo.getReLev() > 0) { // 답글이면
							%>
							<img alt="들여쓰기 아이콘" src="../images/level.gif" width="<%=boardVo.getReLev() * 15 %>" height="10px">
							<img alt="대댓글 아이콘" src="../images/icon_re.gif">
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
		} else { // count == 0
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
	// 글갯수가 0보다 크면 페이지블록 계산해서 출력하기
	if (count > 0) {
		// 필요한 전체 페이지 갯수
		// 글50개, 한화면에 보여줄글 10개 => 50/10 = 5
		// 글55개, 한화면에 보여줄글 10개 => 50/10 = 5 + 나머지존재(1페이지 취급) => 총 6		
		int pageCount = (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
// 		int pageCount = (int)Math.ceil((double)count / pageSize);
		// 한 화면에 보여줄 페이지 갯수
		int pageBlock = 5;
		// 화면에 보여줄 시작페이지번호 구하기
		// 1~5 다음누르면 6~10 ...
		// 1~5 => 1		6~10 => 2 ...
		int startPage = ((pageNum / pageBlock) - (pageNum % pageBlock == 0 ? 1 : 0 )) * pageBlock + 1;
		// 화면에 보여줄 끝페이지번호 구하기
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		// [이전]
		if(startPage > pageBlock) {
			%>
			<a href="list.jsp?pageNum=<%=startPage - pageBlock%>">[이전]</a>
			<%
		}
		
		// 1~5 출력
		for (int i=startPage ; i<=endPage ; i++) {
			if(i == pageNum) {
				%>
				<a href="list.jsp?pageNum=<%=i%>" class="active">[<%=i %>]</a>
				<%
			} else {
				%>
				<a href="list.jsp?pageNum=<%=i%>">[<%=i %>]</a>
				<%
			}			
		} // for
		
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