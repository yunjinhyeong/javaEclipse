<%@page import="java.util.Enumeration"%>
<%@page import="com.exam.vo.AttachVo"%>
<%@page import="com.exam.dao.NoticeDao"%>
<%@page import="com.exam.dao.AttachDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그인체그를 위해 세션값 가져오기
String id = (String)session.getAttribute("id");
//세션값 id 없으면 login.jsp로 리다이렉트 이동
if (id == null) {
//	response.sendRedirect("../member/login.jsp"); // 상대경로
	response.sendRedirect("/member/fileNotice.jsp");			// 절대경로
	return;
}
%>

<%
//업로드 할 실제 물리적 경로 구하기
String realPath = application.getRealPath("/upload");

//오늘날짜 년월일 폴더가 존재하는지 확인해서 없으면 생성하기
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
String strDate = sdf.format(date); // "2020/11/11"

File dir = new File(realPath, strDate);
System.out.println("dir : " + dir.getPath());

if (!dir.exists()) {
	dir.mkdirs();
}

//파일 업로드 하기, (신규 첨부파일을 업로드)
MultipartRequest multi = new MultipartRequest(
		request,
		dir.getPath(),
		1024 * 1024 * 100, // 최대 업로드 100MB로 제한
		"utf-8",
		new DefaultFileRenamePolicy());

// DAO 객체 준비
NoticeDao noticeDao = NoticeDao.getInstance();
AttachDao attachDao = AttachDao.getInstance();

// 게시판 글번호
int noNum = Integer.parseInt(multi.getParameter("num"));
// 신규 첨부파일 정보를 테이블에 insert하기
Enumeration<String> enu = multi.getFileNames();
while(enu.hasMoreElements()) {
	String fname = enu.nextElement();
	// 실제 업로드된 파일이름 가져온다.
	String filename = multi.getFilesystemName(fname);
	
	// insert를 위한 VO 객체 준비
	AttachVo attachVo = new AttachVo();
	attachVo.setFilename(filename);
	attachVo.setUploadpath(strDate);
	if(filename != null) {
		attachVo.setImage( isImage(filename) ? "I" : "O" );	
	}
	
	attachVo.setNoNum(noNum);
	
	// 첨부파일정보 insert하기
	attachDao.insertAttach(attachVo);
} // while

// 삭제해야 할 첨부파일들 번호 가져오기
String[] delFileNums = multi.getParameterValues("delfile");

for (String delFileNum : delFileNums) {
	// 삭제할 첨부파일 번호를 숫자로 변환
	int num = Integer.parseInt(delFileNum);
	// 첨부파일 번호에 해당하는 첨부파일 정보 한개를 VO로 가져오기
	AttachVo attachVo = attachDao.getAttachByNum(num);
	
	// 파일정보로 실제파일 존재여부 확인해서 삭제하기
	File delFile = new File(realPath + "/" + attachVo.getUploadpath(), attachVo.getFilename());
	if (delFile.exists()){
		delFile.delete();
	}
	
	// 첨부파일 테이블 첨부파일번호에 해당하는 레코드 한개 삭제하기
	attachDao.deleteAttachByNum(num);
	
} // for

// noticeDao.updateBoard(noticeVo);

// 상세보기 화면으로 가기
%>




<%!
boolean isImage(String filename) {
	boolean result = false;
	// 파일 확장자 문자열 추출하기
	// aaaa.bbb.ccc.ddd
	int index = filename.lastIndexOf(".");
	String ext = filename.substring(index + 1); // 파일 확장자 문자열
	
	if (ext.equalsIgnoreCase("jpg") 
			|| ext.equalsIgnoreCase("jpeg")
			|| ext.equalsIgnoreCase("gif")
			|| ext.equalsIgnoreCase("png")) {
		result = true;
	}
	return result;
}
%>
