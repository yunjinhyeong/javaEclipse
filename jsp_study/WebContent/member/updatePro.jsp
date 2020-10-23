<%@page import="com.exam.dao.MemberDao"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션값 id 가져오기
String id = (String) session.getAttribute("id");
//세션값 id 없으면  loginForm.jsp 이동
if (id == null) {
	response.sendRedirect("loginForm.jsp");
	return;
}
// post 파라미터값 한글처리(post로 넘어올땐 다 꺠져서 넘어오기에..)
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberVo" class="com.exam.vo.MemberVo"/>
<%
// VO 객체준비
// MemberVo memberVo = new MemberVo();
// 파라미터값 가져와서 VO에 저장
// memberVo.setId(request.getParameter("id"));
// memberVo.setPasswd(request.getParameter("passwd"));
// memberVo.setName(request.getParameter("name"));
// memberVo.setAge(Integer.parseInt(request.getParameter("age")));
// memberVo.setGender(request.getParameter("gender"));
// memberVo.setEmail(request.getParameter("email"));
%>
<jsp:setProperty property="*" name="memberVo"/> <!-- useBean id를 name값으로 -->
<%
// DAO 객체 준비
// MemberDao memberDao = new MemberDao();
MemberDao memberDao = MemberDao.getInstance();
// 회원수정
memberDao.update(memberVo);
// 회원수정 완료되면 main.jsp로 바로 이동
// response.sendRedirect("main.jsp");
%>
<script>
	alert('회원수정 완료');
	location.href='main.jsp';
</script>
