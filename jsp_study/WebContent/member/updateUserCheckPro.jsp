<%@ page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션값 가져오기
String id = (String) session.getAttribute("id");
//세션값 없으면  loginForm.jsp 이동
if(id==null) {
	%>
	<script>
	alert('잘못된 경로 입니다.');
	location.href = 'loginForm.jsp' // sendRedirect을 쓰면 뒤로가기 해도 정보가 없기에 그냥 location으로 이동한다.
	</script>
	<%
	// response.sendRedirect("main.jsp"); // 가진 정보 전부 폐기처분
	return;
}

// post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");
// 파라미터값 passwd 가져오기
String passwd = request.getParameter("passwd"); // getParameter 안의 "passwd" 이건 name의 속성임
// DAO 객체 준비
// MemberDao memberDao = new MemberDao();
MemberDao memberDao = MemberDao.getInstance();

int check = memberDao.userCheck(id, passwd);

if(check == 1) { // 패스워드 일치할때
	response.sendRedirect("updateForm.jsp");
	return;
} else { // 패스워드 일치하지 않을때
	%>
	<script>
		alert('패스워드 틀림');
		history.back();
	</script>
	<%
}

%>
