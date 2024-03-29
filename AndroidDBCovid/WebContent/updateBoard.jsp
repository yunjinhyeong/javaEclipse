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
String subject = request.getParameter("subject") == null ? "" : request.getParameter("subject").trim();
String content = request.getParameter("content") == null ? "" : request.getParameter("content").trim();

System.out.println("id: "+ id);
System.out.println("name: "+ subject);
System.out.println("pw: "+ content);

QueryBean.getConnection();

int res = 0;

try {
	res = QueryBean.updateBoard(id, subject, content);
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