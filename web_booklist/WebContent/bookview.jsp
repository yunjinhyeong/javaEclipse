<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "madang";
	String pwd = "madang";
	Connection dbconn = DriverManager.getConnection(url, userid, pwd);
	Statement stmt = dbconn.createStatement();
	String bookid = request.getParameter("bookid");
	ResultSet myResultSet=stmt.executeQuery("SELECT * FROM Book WHERE bookid='"+bookid+"'");
	if(myResultSet!=null){
		myResultSet.next();
%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>** Book VIEW **</title>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">
<table border="1" cellspacing="0" width="400" bordercolor="#9AD2F7"
				bordercolordark="white" bordercolorlight="#B9E0FA">
		<tr>
			<td width="150" height="23">
				<p align="center">
				<span style="font-size: 9pt;">책 제 목</span></p>
			</td>
			<td width="513">
				<p><span style="font-size: 9pt;">
				<%=myResultSet.getString("BOOKNAME")%></span></p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
				<span style="font-size: 9pt;">출 판 사</span></p>
			</td>
			<td width="513">
				<p><span style="font-size: 9pt;">
				<%=myResultSet.getString("PUBLISHER")%></span></p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
				<span style="font-size: 9pt;">가 격</span></p>
			</td>
			<td width="513">
				<p><span style="font-size: 9pt;">
				<%=myResultSet.getString("PRICE")%></span></p>
			</td>
		</tr>
</table>
<table cellpadding="0" cellspacing="0" width="400" height="23">
	<tr>
		<td width="150">
			<p align="right"><span style="font-size:9pt;">
			<a href="booklist.jsp?">
			<font color="black">목록</font></a></span></p>
		</td>
	</tr>
</table>
<%
	}
	stmt.close();
	dbconn.close();
%>
</body>
</html>