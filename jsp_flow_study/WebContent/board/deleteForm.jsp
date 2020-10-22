<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete Form</title>
</head>
<body>
	<h1>게시판 삭제</h1>
	<hr>
	<form action="deletePro.jsp" method="post" id="frm">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="num" value="<%=num%>">
		<table border="1">
			<tr>
				<th>패스워드</th><td><input type="password" name="passwd" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글삭제">
					<input type="reset" value="다시쓰기">
					<input type="button" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
<script src="../js/jquery-3.5.1.js"></script>
<script>
$('#frm').submit(() => {
	var isRemove = confirm('정말 삭제할껀가?');
	if(isRemove) {
		return true;
	}
	return false;
});	 
</script>
</body>
</html>