<%@ page import="db.beans.*, java.sql.*, java.util.*, java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty property="*" name="QueryBean"/>
<%
// 캐쉬 제거?
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim();
String name = request.getParameter("name") == null ? "" : request.getParameter("name").trim();
String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw").trim();
String phone = request.getParameter("phone") == null ? "" : request.getParameter("phone").trim();

System.out.println("id: "+ id);
System.out.println("name: "+ name);
System.out.println("pw: "+ pw);
System.out.println("phone: "+ phone);

QueryBean.getConnection();

int res = 0;

try {
	res = QueryBean.setUserInfo(id, name, pw, phone);
} catch(Exception e) {
	out.print(e.toString());
} finally {
	QueryBean.closeConnection();
}

out.println("[");
out.println("{");
out.println("\"RESULT_OK\": \"" + res + "\" ");
out.println("} ");
out.println("]");

System.out.println("res: "+ res);
%>