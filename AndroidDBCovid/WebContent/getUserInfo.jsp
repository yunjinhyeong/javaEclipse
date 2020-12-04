<%@page import="db.beans.*,java.util.*,java.io.*"%>
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

	System.out.println("id: "+ id);
	
	QueryBean.getConnection();
	
	ArrayList resArr = new ArrayList();
	
	try {
		resArr = QueryBean.getUserInfo(id);
	} catch(Exception e) {
		out.print(e.toString());
	} finally {
		QueryBean.closeConnection();
	}
	
	out.println("{");
	out.println("\"datas\":[");
	
	if(resArr.size() == 0){
		out.println("]");
		out.println("}");
	} else {
		out.print("{ ");
		out.print(" \"ID\": \"" 					+ (String)resArr.get(0) + "\", ");
		out.print(" \"NAME\": \"" 				+ (String)resArr.get(1) + "\", ");
		out.print(" \"PW\": \"" 				  + (String)resArr.get(2) + "\", ");
		out.print(" \"PHONE\": \"" 				+ (String)resArr.get(3) + "\", ");
		out.print(" \"WRITE_TIME\": \"" 	+ (String)resArr.get(4) + "\", ");
		out.print(" \"FEVER\": \"" 	+ (String)resArr.get(5) + "\", ");
		out.print(" \"COUGH\": \"" 	+ (String)resArr.get(6) + "\", ");
		out.print(" \"SORETHROAT\": \"" 	+ (String)resArr.get(7) + "\", ");
		out.print(" \"SNOT\": \"" 	+ (String)resArr.get(8) + "\", ");
		out.print(" \"PHLEGM\": \"" 	+ (String)resArr.get(9) + "\", ");
		out.print(" \"BREATHING\": \"" 	+ (String)resArr.get(10) + "\", ");
		out.print(" \"CONFIRMATION\": \"" 	+ (String)resArr.get(11) + "\" ");
		
		/* out.print(" \"FEVER\": " 				+ (Boolean)resArr.get(6) + ", ");
		out.print(" \"COUGH\": " 				+ (Boolean)resArr.get(7) + ", ");
		out.print(" \"SORETHROAT\": " 	+ (Boolean)resArr.get(8) + ", ");
		out.print(" \"SNOT\": " 				+ (Boolean)resArr.get(9) + ", ");
		out.print(" \"PHLEGM\": " 			+ (Boolean)resArr.get(10) + ", ");
		out.print(" \"BREATHING\": " 		+ (Boolean)resArr.get(11) + ", ");
		out.print(" \"CONFIRMATION\": " + (Boolean)resArr.get(12) + " "); */
		
		out.print("} ");
		
		for(int i=12 ; i<resArr.size() ; i+=12 ){
			out.print(",");
			out.print("{ ");
			out.print(" \"ID\": \"" 					+ (String)resArr.get(i) + "\", ");
			out.print(" \"NAME\": \"" 					+ (String)resArr.get(i+1) + "\", ");
			out.print(" \"PW\": \"" 				+ (String)resArr.get(i+2) + "\", ");
			out.print(" \"PHONE\": \"" 				  + (String)resArr.get(i+3) + "\", ");
			out.print(" \"WRITE_TIME\": \"" 				+ (String)resArr.get(i+4) + "\", ");
			out.print(" \"FEVER\": \"" 	+ (String)resArr.get(i+5) + "\", ");
			out.print(" \"COUGH\": \"" 	+ (String)resArr.get(i+6) + "\", ");
			out.print(" \"SORETHROAT\": \"" 	+ (String)resArr.get(i+7) + "\", ");
			out.print(" \"SNOT\": \"" 	+ (String)resArr.get(i+8) + "\", ");
			out.print(" \"PHLEGM\": \"" 	+ (String)resArr.get(i+9) + "\", ");
			out.print(" \"BREATHING\": \"" 	+ (String)resArr.get(i+10) + "\", ");
			out.print(" \"CONFIRMATION\": \"" 	+ (String)resArr.get(i+11) + "\" ");
			
			
			/* out.print(" \"FEVER\": " 				+ (Boolean)resArr.get(i+6) + ", ");
			out.print(" \"COUGH\": " 				+ (Boolean)resArr.get(i+7) + ", ");
			out.print(" \"SORETHROAT\": " 	+ (Boolean)resArr.get(i+8) + ", ");
			out.print(" \"SNOT\": " 				+ (Boolean)resArr.get(i+9) + ", ");
			out.print(" \"PHLEGM\": " 			+ (Boolean)resArr.get(i+10) + ", ");
			out.print(" \"BREATHING\": " 		+ (Boolean)resArr.get(i+11) + ", ");
			out.print(" \"CONFIRMATION\": " + (Boolean)resArr.get(i+12) + " "); */
			
			out.print("} ");
		}
		out.print("]");
		out.print("}");
	}
	
%>