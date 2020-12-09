package com.exam.controller.filenotice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;

public class FileWriteFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileWriteFormController......");
		
		// ���� ��������
		HttpSession session = request.getSession();
		
		// �α��� ���� Ȯ��
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "redirect:/fileNotice.do";
		}
		
		// �Ķ���Ͱ�  pageNum  ��������
		String pageNum = request.getParameter("pageNum");
		
		// ��(jsp)���� �ʿ��� ������ request ������ü�� ����
		request.setAttribute("pageNum", pageNum);
		
		return "center/fileWriteForm";
	}

}
