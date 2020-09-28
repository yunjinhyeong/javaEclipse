<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- http://localhost:80/jsp_study/jsp1/examForm1.jsp -->
	<h1>examForm1.jsp 페이지</h1>
	<hr>
	<!-- action="examProcess.jsp"은 examProcess.jsp요청한다라는 듯  -->
	<form action="examProcess.jsp" method="post"><!-- method의 post는 값이 안보이게 함 get은 보임 -->
		숫자를 입력:
		<input type="number" name="num" min="0" max="100"><!-- name은 key다 -->
		<input type="submit" value="전송">
	</form>
</body>
</html>