package com.exam.controller.filenotice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Controller;
import com.exam.dao.AttachDao;
import com.exam.dao.NoticeDao;
import com.exam.vo.AttachVo;
import com.exam.vo.NoticeVo;

public class FileContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileContentController......");
		
		// �Ķ���Ͱ�  num  pageNum  ��������
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// DAO ��ü �غ�
		NoticeDao noticeDao = NoticeDao.getInstance();
		AttachDao attachDao = AttachDao.getInstance();

		// ��ȸ�� 1 ����
		noticeDao.updateReadcount(num);

		// �� �Ѱ� ��������
		NoticeVo noticeVo = noticeDao.getNoticeByNum(num);
		// ÷������ ����Ʈ ���� ��������
		List<AttachVo> attachList = attachDao.getAttachesByNoNum(num);


		// �� ���뿡�� "\n" �ٹٲ� ���ڿ��� "<br>"�� ��ü�ϱ�
		String content = "";
		if (noticeVo.getContent() != null) {
			content = noticeVo.getContent().replace("\n", "<br>");
			noticeVo.setContent(content);
		}
		
		// ��(jsp)���� �ʿ��� �����͸� request ������ü�� ����
		request.setAttribute("noticeVo", noticeVo);
		request.setAttribute("attachList", attachList);
		request.setAttribute("pageNum", pageNum);
		
		return "center/fileContent";
	}

}
