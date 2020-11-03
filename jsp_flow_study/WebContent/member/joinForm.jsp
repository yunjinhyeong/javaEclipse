<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span.positive {
	color: green;
	font-style: italic;
}
span.negative {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="joinProcess.jsp" method="post">
		아이디: <input type="text" name="id">
					<span id="msgIdDup"></span>
		<br>
		패스워드: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		나이: <input type="number" name="age"><br>
		성별: <input type="radio" name="gender" value="남"> 남성
				 <input type="radio" name="gender" value="여"> 여성<br>
		이메일: <input type="email" name="email"><br>
		<input type="submit" value="회원가입">
	</form>
<script src="../js/jquery-3.5.1.js"></script>
<script>
	function process(item) {
		let	$spanMsg = $('#msgIdDup');
		if(item.count == 0) {
			$spanMsg.html('사용가능한 아이디 입니다.').addClass('positive').removeClass('negative');
		} else {
			$spanMsg.html('이미 사용중인 아이디 입니다.').addClass('negative').removeClass('positive');
		}
	}
	$('input[name="id"]').keyup(function() {
		let str = $(this).serialize();
		$.ajax({
			url: 'ajaxInDupCheck.jsp',
			data: str,
			success: function(data){
					process(data);
				}
		});
	});
</script>	
</body>
</html>