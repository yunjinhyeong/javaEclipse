package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IndexController......");
		
		// DBó���� ���� Model������ Dao�� ����Ҽ� ����
		
		//return "redirect:/joinForm.do"; // �����̷�Ʈ ����
		
		//return "/WEB-INF/views/index.jsp";
		return "index";  // ������ jsp������ ����̸� ���� (����ġ ���)
		
		
	}

}
