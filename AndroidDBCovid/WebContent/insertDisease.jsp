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

Boolean fever = request.getParameter("fever") == null ? null : Boolean.parseBoolean(request.getParameter("fever"));
Boolean cough = request.getParameter("cough") == null ? null : Boolean.parseBoolean(request.getParameter("cough"));
Boolean soreThroat = request.getParameter("soreThroat") == null ? null : Boolean.parseBoolean(request.getParameter("soreThroat"));
Boolean snot = request.getParameter("snot") == null ? null : Boolean.parseBoolean(request.getParameter("snot"));
Boolean phlegm = request.getParameter("phlegm") == null ? null : Boolean.parseBoolean(request.getParameter("phlegm"));
Boolean breathing	 = request.getParameter("breathing	") == null ? null : Boolean.parseBoolean(request.getParameter("breathing"));
Boolean confirmation = request.getParameter("confirmation") == null ? null : Boolean.parseBoolean(request.getParameter("confirmation"));

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
	res = QueryBean.setDiseaseInfo(id, fever, cough, soreThroat, snot, phlegm, breathing, confirmation);
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