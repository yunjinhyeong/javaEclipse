package com.exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;
import com.exam.dao.MemberDao;

public class MemberLoginProController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginProController......");
		
		// �Ķ���� id  passwd   keepLogin  ��������
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String strKeepLogin = request.getParameter("keepLogin");

		// DAO ��ü �غ�
		MemberDao memberDao = MemberDao.getInstance();

		// �α��� Ȯ��.
		// check -1  ���� ���̵�
		// check  0  �н����� Ʋ��
		// check  1  ���̵�, �н����� ��� ��ġ
		int check = memberDao.userCheck(id, passwd);

		// �α����� �������� ���
		if (check != 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("	alert('���̵� �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.');");
			out.println("	history.back();");
			out.println("</script>");
			//out.flush();
			out.close(); // ���� ���۵� �����(Ŭ���̾�Ʈ�� ����)
			return null;
		}

		//�α��� �������� ���� Ȯ���ϱ�
		boolean keepLogin = false;
		if (strKeepLogin != null) { // "true"
			keepLogin = Boolean.parseBoolean(strKeepLogin); // "true" -> true
		}

		// �α����� �������� ���
		
		// ���� ���� ��������
		HttpSession session = request.getSession();
		
		// ���ǿ� �α��� ���̵� ���� (�α��� ó��)
		session.setAttribute("id", id);

		// �α��� ���������� ���ϸ� ��Ű ���� �� �����ֱ�
		if (keepLogin) { // keepLogin == true
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60 * 10);  // �ʴ��� ����  10��
			cookie.setPath("/");

			response.addCookie(cookie);
		}

		// index.do�� �����̷�Ʈ
		return "redirect:/index.do";
	}

}
