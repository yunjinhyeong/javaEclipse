package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override // @ �������̼� �����Ϸ��� ���� �ּ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ���乮���� html�̸鼭 �����ڵ�� ����
		response.setContentType("text/html; charset=UTF-8");
		// �������� ����ϴ� ��ü ���� �ޱ�
		PrintWriter out = response.getWriter();

		// ���� ��������. ������ Map �÷������� ������.
		// ����� 1��� �����ϴ� ���� ����.
		HttpSession session = request.getSession();
		
		// ��ũ��Ʋ�� ���� (�ڹ� �ڵ� ����)
		/*
		 * �ڹ� ������ �ּ�
		 */
		String str = "���ڿ�";

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String strDate = sdf.format(date);

		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head><body><h1>JSP �׽�Ʈ</h1><hr>");

		out.println(strDate);
		out.println(1+2);
		
		out.println("<br></body></html>");

	}

}
