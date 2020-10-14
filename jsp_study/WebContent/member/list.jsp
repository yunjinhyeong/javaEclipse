<%@ page import="com.exam.dao.MemberDao"%>
<%@ page import="com.exam.vo.MemberVo"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션값 가져오기
	// 1) 로그인 안한 경우 -> null 리턴
	// 2) 로그인 했는데 관리자("admin")이(가) 아닌 경우 -> null 리턴
	// 	-> main.jsp 로 이동
String id = (String) session.getAttribute("id");	
//	!(id == null || !id.equals("admin"))
//	id != null && id.equals("admin")
if(id==null || !id.equals("admin")) {
	response.sendRedirect("main.jsp"); // main.jsp를 요청하세요 라고 서버가 클라이언트에 쪽지 보냄
	return;
}
// DAO 객체 준비
MemberDao memberDao = new MemberDao();
//전체회원정보 List로 가져오기
List<MemberVo> memberList = memberDao.getAllMembers();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>가입일자</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(MemberVo memberVo : memberList) {
				// 생략안한경우 보려면 info.jsp 볼것
				// Timestamp timestamp = memberVo.getRegDate();
				// Date date = new Date(timestamp.getTime());
			%>
			<tr>
				<td><%=memberVo.getId() %></td>
				<td><%=memberVo.getPasswd() %></td>
				<td><%=memberVo.getName() %></td>
				<td><%=memberVo.getGender() %></td>
				<td><%=memberVo.getAge() %></td>
				<td><%=(memberVo.getEmail()== null)?"":memberVo.getEmail()%></td>
				<td><%=sdf.format(memberVo.getRegDate())%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<h3><a href="main.jsp">메인화면</a></h3>
</body>
</html>