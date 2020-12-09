package com.exam.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Controller;
import com.exam.dao.MemberDao;

public class JoinIdDupCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("JoinIdDupCheckController......");
		
		// �Ķ���Ͱ� id ��������
		String id = request.getParameter("id");

		// DAO ��ü �غ�
		MemberDao memberDao = MemberDao.getInstance();

		// �ߺ����̵� ���� Ȯ��
		int count = memberDao.getCountById(id);
		
		// * ������ü 4���� (��Ĺ�� �����ϴ� Map �÷���)
		//  application : �����α׷� 1���� �����Ǵ� ������ü
		//  session : ����� 1��� �����Ǵ� ������ü
		//  request : ��û �ѹ����� �����Ǵ� ������ü
		//  page : jsp ������ �ѹ� ���ට�� �����Ǵ� ������ü
		
		// request ������ü�� View ȭ�鿡�� �ʿ��� �����͸� ����
		request.setAttribute("id", id);
		request.setAttribute("count", count);
		
		// ����ġ ������� jsp�� �ٷν����ϸ�
		// �տ��� ����� request��ü�� jsp���� ���޵ǹǷ�
		// jspȭ�鿡�� �����͸� ����� �� ����
		return "member/joinIdDupCheck";
	}

}
