package com.exam.controller.member;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Controller;
import com.exam.dao.MemberDao;
import com.exam.vo.MemberVo;

public class MemberJoinProController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberJoinProController......");
		
		// VO ��ü �غ�
		MemberVo vo = new MemberVo();
		
		// VO��ü�� �Ķ���Ͱ� ����
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setAge(Integer.parseInt(request.getParameter("age")));
		vo.setGender(request.getParameter("gender"));
		
		// ���Գ�¥ �����ؼ� �ֱ�
		vo.setRegDate(new Timestamp(System.currentTimeMillis()));

		// DAO ��ü �غ�
		MemberDao memberDao = MemberDao.getInstance();
		// ȸ������ �޼��� ȣ��
		memberDao.addMember(vo);
		
		// �α��� ȭ�� ��û��η� �����̷�Ʈ��Ű�� ���ؼ�
		// �����̷�Ʈ ������ ������
		return "redirect:/memberLogin.do";
	}

}
