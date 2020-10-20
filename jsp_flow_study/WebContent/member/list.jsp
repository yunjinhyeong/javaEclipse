<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
if(id==null || !id.equals("admin")){
	response.sendRedirect("main.jsp");
	return;
}
MemberDao memberDao = MemberDao.getInstance();
List<MemberVo> memberList = memberDao.getAllMembers();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h1>전체리스트</h1>
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
			for(MemberVo memberVo : memberList){
				%>
				<tr>
					<td><%=memberVo.getId() %></td>
					<td><%=memberVo.getPasswd() %></td>
					<td><%=memberVo.getName() %></td>
					<td><%=memberVo.getGender() %></td>
					<td><%=memberVo.getAge() %></td>
					<td><%=(memberVo.getEmail()==null)?"":memberVo.getEmail() %></td>
					<td><%=sdf.format(memberVo.getRegDate()) %></td>
				</tr>
				<%
			}
			%>
		</tbody>
	</table>
	<h3><a href="main.jsp"></a></h3>
</body>
</html>