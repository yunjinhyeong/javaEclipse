<%@page import="com.exam.vo.BoardVo"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//post 방식 파라미터값 한글처리
request.setCharacterEncoding("utf-8");
//파라미터값   pageNum  num  passwd   가져오기
String pageNum = request.getParameter("pageNum");
int num = Integer.parseInt(request.getParameter("num"));
String passwd = request.getParameter("passwd");
// DAO 객체 준비
BoardDao boardDao = BoardDao.getInstance();
// 본인확인용 글 패스워드 비교
boolean isPasswdOK = boardDao.isPasswdOk(num, passwd);
// 글 패스워드 일치하면 글삭제하고 글목록으로 이동
if (isPasswdOK) {
	// 글번호에 해당하는 글내용 가져오기(첨부파일 정보 확인 위해서)
	BoardVo boardVo = boardDao.getBoardByNum(num);
	String filename = boardVo.getFile();
	if (boardVo.getFile() != null) { // 첨부파일 있으면
		String realPath = application.getRealPath("/upload");
		File file = new File(realPath, filename);
		if(file.exists()) {
	file.delete();
		}
	}
	boardDao.deleteBoardByNum(num);
	response.sendRedirect("list.jsp?pageNum="+pageNum);
} else {
%>
	<script>
		alert('글 패스워드 틀림');
		history.back();
	</script>
	<%	
}
%>