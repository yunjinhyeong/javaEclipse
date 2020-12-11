<%@page import="com.exam.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 로그인체그를 위해 세션값 가져오기
String id = (String)session.getAttribute("id");
// 세션값 id 없으면 login.jsp로 리다이렉트 이동
if (id == null) {
// 	response.sendRedirect("../member/login.jsp"); // 상대경로
	response.sendRedirect("/member/login.jsp");			// 절대경로
	return;
}


// num pageNum 파라미터값 가져오기
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

// DAO 객체 준비
NoticeDao dao = NoticeDao.getInstance();

// 글번호에 해당하는 글 한개 삭제하기
dao.deleteNoticeByNum(num);

// 글목록 페이지로 리다이렉트 이동시키기
response.sendRedirect("notice.jsp?pageNum=" + pageNum);
%>