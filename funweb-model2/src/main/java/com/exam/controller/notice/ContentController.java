package com.exam.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Controller;
import com.exam.dao.NoticeDao;
import com.exam.vo.NoticeVo;

public class ContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ContentController......");
		
		// �Ķ���Ͱ�  num  pageNum  ��������
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		// DAO ��ü �غ�
		NoticeDao noticeDao = NoticeDao.getInstance();

		// ��ȸ�� 1 ����
		noticeDao.updateReadcount(num);

		// �� �Ѱ� ��������
		NoticeVo noticeVo = noticeDao.getNoticeByNum(num);
		
		// �� ���뿡�� "\n" �ٹٲ� ���ڿ��� "<br>"�� ��ü�ϱ�
		String content = "";
		if (noticeVo.getContent() != null) {
			content = noticeVo.getContent().replace("\n", "<br>");
			noticeVo.setContent(content);
		}
		
		// ��(jsp)���� ����� �����͸� request ������ü�� ����
		request.setAttribute("noticeVo", noticeVo);
		request.setAttribute("pageNum", pageNum);
		
		// ������ jsp ����̸� ������ ����
		return "center/content";
	}

}
