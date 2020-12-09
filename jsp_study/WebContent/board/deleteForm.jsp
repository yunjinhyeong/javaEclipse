<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 위에 코드로 인해 response charset utf-8 적용됨 그러니 setCharacterEncoding로 utf-8 해줌 -->
<%
// 파라미터 찾기 int num, String pageNum 파라미터값 가져오기
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 삭제</h1>
	<hr>
	<form action="deletePro.jsp" method="post" id="frm">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="num" value="<%=num %>">		
		<table border="1">
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="passwd" required></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글삭제">
						<input type="reset" value="다시쓰기">
						<input type="button" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum %>'">
					</td>
				</tr>
		</table>
	</form>
<script src="../js/jquery-3.5.1.js"></script>
<script>
	$('#frm').submit(function () {
		var isRemove = confirm('정말 삭제하시겠습니까?');
		if(isRemove){
			return true;
		}
		return false;
	});
</script>
</body>
</html>