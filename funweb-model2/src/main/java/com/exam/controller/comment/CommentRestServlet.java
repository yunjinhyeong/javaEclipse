package com.exam.controller.comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import com.exam.dao.CommentDao;
import com.exam.vo.CommentVo;
import com.google.gson.Gson;

import lombok.extern.java.Log;

@Log
@WebServlet(urlPatterns = "/comment/*", loadOnStartup = 1)
public class CommentRestServlet extends HttpServlet {

	private CommentDao commentDao = CommentDao.getInstance();
	private Gson gson = new Gson();
	
	private void sendResponse(String strJson, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println(strJson);
	    //out.flush();
	    out.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet ȣ���");
		
		String category = request.getParameter("category");
		String strJson = "";
		if(category.equals("one")) {
			int cno = Integer.parseInt(request.getParameter("cno"));
			
			CommentVo commentVo = commentDao.getCommentByCno(cno);
			
			Map<String, Object> map = new HashMap<>();
			map.put("commentVo", commentVo);
			map.put("isSuccess", true);
			
			strJson = gson.toJson(map);
			
		} else if (category.equals("list")) {
			int nno = Integer.parseInt(request.getParameter("nno"));
			
			List<CommentVo> commentList = commentDao.getComments(nno);
			
			Map<String, Object> map = new HashMap<>();
			map.put("commentList", commentList);
			map.put("isSuccess", true);
			
			strJson = gson.toJson(map);
		}
		//Ŭ���̾�Ʈ���� �����ֱ�
        sendResponse(strJson, response);
	}

	
	//SQL�� INSERT�� ��û post���
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("doPostȣ���");

      request.setCharacterEncoding("utf-8");

      BufferedReader reader= request.getReader();
      
      CommentVo commentVo = gson.fromJson(reader, CommentVo.class);
      log.info("commentVo : " + commentVo);

      commentDao.addComment(commentVo);   //DB insertó�� �Ϸ�

      //Ŭ���̾�Ʈ���� ������ �� ������ �غ�
      Map<String, Object> map = new HashMap<>();
      map.put("isSuccess", true);

      String strJson= gson.toJson(map);
      log.info("strJson :  " + strJson);

      //Ŭ���̾�Ʈ���� �����ֱ�
      sendResponse(strJson, response);
   }
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doPut ȣ���");
		
	    request.setCharacterEncoding("utf-8");

        BufferedReader reader= request.getReader();
      
        CommentVo commentVo = gson.fromJson(reader, CommentVo.class);
        log.info("commentVo : " + commentVo);
  
        commentDao.update(commentVo);   //DB insertó�� �Ϸ�

        //Ŭ���̾�Ʈ���� ������ �� ������ �غ�
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", true);
  
        String strJson= gson.toJson(map);
        log.info("strJson :  " + strJson);

        //Ŭ���̾�Ʈ���� �����ֱ�
        sendResponse(strJson, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doDelete ȣ���");
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		commentDao.deleteByCno(cno);
		
		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);
		
		String strJson = gson.toJson(map);
	}

}
