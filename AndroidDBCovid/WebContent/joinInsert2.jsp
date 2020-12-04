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

String fever = request.getParameter("fever") == null ? "" : request.getParameter("fever").trim();
String cough = request.getParameter("cough") == null ? "" : request.getParameter("cough").trim();
String soreThroat = request.getParameter("soreThroat") == null ? "" : request.getParameter("soreThroat").trim();
String snot = request.getParameter("snot") == null ? "" : request.getParameter("snot").trim();
String phlegm = request.getParameter("phlegm") == null ? "" : request.getParameter("phlegm").trim();
String breathing = request.getParameter("breathing") == null ? "" : request.getParameter("breathing").trim();
String confirmation = request.getParameter("confirmation") == null ? "" : request.getParameter("confirmation").trim();

System.out.println("id: "+ id);

System.out.println("fever: "+ fever);
System.out.println("cough: "+ cough);
System.out.println("soreThroat: "+ soreThroat);
System.out.println("snot: "+ snot);
System.out.println("phlegm: "+ phlegm);
System.out.println("breathing: "+ breathing);
System.out.println("confirmation: "+ confirmation);

QueryBean.getConnection();

int res = 0;

try {
	res = QueryBean.setUserInfo2(id, fever, cough, soreThroat, snot, phlegm, breathing, confirmation);
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