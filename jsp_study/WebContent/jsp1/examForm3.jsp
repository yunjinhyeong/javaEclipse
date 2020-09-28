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
	<h1>examForm3.jsp 페이지</h1>
	<hr>
	<!-- action="examProcess.jsp"은 examProcess.jsp요청한다라는 듯  -->
	<form action="examProcess3.jsp" method="get"><!-- method의 post는 값이 안보이게 함 get은 보임 -->
		이름 : <input type="text" name="name"><br><!-- name은 key다 -->
		성별 : <input type="radio" name="gender" value="남">남성
					<input type="radio" name="gender" value="여">여성
		<br>
		직업 : 
		<select name="job">
			<option value="학생">학생</option>
			<option value="회사원">회사원</option>
			<option value="기타">기타</option>
		</select>
		<br>
		취미 :
		<input type="checkbox" name="hobby" value="여행">여행
		<input type="checkbox" name="hobby" value="게임">게임
		<input type="checkbox" name="hobby" value="야구">야구
		<br>
		<input type="submit" value="전송">
		
	</form>
</body>
</html>