package com.exam.controller.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;

public class MemberLogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLogoutController......");
		
		// ���� ��ü ���� ��������
		HttpSession session = request.getSession();
		// ���ǰ� �ʱ�ȭ. �α׾ƿ� �۾�
		session.invalidate();
		
		// �α��� ���������� ��Ű�� �����ϸ� �����ϱ�
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					cookie.setMaxAge(0); // ��ȿ�Ⱓ 0���� ���� -> ��Ű ����ó��
					cookie.setPath("/"); // ��� ����
					
					response.addCookie(cookie); // ��Ű���� ������
				}
			}
		}
		
		// index.do�� �����̷�Ʈ
		return "redirect:/index.do";
	}

}
