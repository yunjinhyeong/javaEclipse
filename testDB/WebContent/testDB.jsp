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
	
	QueryBean.getConnection();
	
	ArrayList resArr = new ArrayList();
	
	try {
		resArr = QueryBean.getUserInfo();	
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
		out.print(" \"PHONE\": \"" 				+ (String)resArr.get(2) + "\", ");
		out.print(" \"GRADE\": \"" 				+ (String)resArr.get(3) + "\", ");
		out.print(" \"WRITE_TIME\": \"" 	+ (String)resArr.get(4) + "\" ");
		out.print("} ");
		
		for(int i=5 ; i<resArr.size() ; i+=5 ){
			out.print(",");
			out.print("{ ");
			out.print(" \"ID\": \"" 				+ (String)resArr.get(i) + "\", ");
			out.print(" \"NAME\": \""				+ (String)resArr.get(i+1) + "\", ");
			out.print(" \"PHONE\": \"" 			+ (String)resArr.get(i+2) + "\", ");
			out.print(" \"GRADE\": \"" 			+ (String)resArr.get(i+3) + "\", ");
			out.print(" \"WRITE_TIME\": \"" + (String)resArr.get(i+4) + "\" ");
			
			out.print("} ");
		}
		out.print("]");
		out.print("}");
	}
	
%>