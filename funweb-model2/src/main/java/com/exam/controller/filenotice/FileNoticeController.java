package com.exam.controller.filenotice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Controller;
import com.exam.dao.NoticeDao;
import com.exam.vo.NoticeVo;
import com.exam.vo.PageDto;

public class FileNoticeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileNoticeController......");
		
		// �˻��� ���� �Ķ���Ͱ� ��������. ������ null ����
		String category = request.getParameter("category"); // �˻�����
		String search = request.getParameter("search"); // �˻���

		// �˻��� ���� �Ķ���Ͱ��� null�̸� ���ڿ�("")�� ��ü
		category = (category == null) ? "" : category;
		search = (search == null) ? "" : search;

		System.out.println("category = " + category);
		System.out.println("search = " + search);

		// DAO ��ü �غ�
		NoticeDao noticeDao = NoticeDao.getInstance();

		// ��ü �۰��� ��������
		//int count = noticeDao.getCountAll();
		int count = noticeDao.getCountBySearch(category, search); // �˻��� �������� �۰��� ��������

		
		// ==================================================
		// �� �������� �ش��ϴ� �۸�� ���ϱ� �۾�
		// ==================================================
		
		// ���������� ������ �۰��� ����
		int pageSize = 10;

		// ����ڰ� ��û�ϴ� ��������ȣ �Ķ���Ͱ� ��������
		String strPageNum = request.getParameter("pageNum");
		// ����� ��û ��������ȣ ������ ������(null �϶�)
		// �⺻ ��û ��������ȣ�� 1�������� �����ϱ�
		strPageNum = (strPageNum == null) ? "1" : strPageNum;
		// ����� ��û �������� ������ ��ȯ
		int pageNum = Integer.parseInt(strPageNum);

		// ������ ù���ȣ ���ϱ�
		int startRow = (pageNum - 1) * pageSize;

		// �۸�� ��������
		List<NoticeVo> noticeList = null;
		if (count > 0) {
			//noticeList = noticeDao.getNotices(startRow, pageSize);
			noticeList = noticeDao.getNoticesBySearch(startRow, pageSize, category, search);
		}
		
		
		
		
		// ==================================================
		// ��������� �������� ���ϱ� �۾�
		// ==================================================
		
		PageDto pageDto = new PageDto();
		
		// �۰����� 0���� ũ�� ��������� ����ؼ� ����ϱ�
		if (count > 0) {
			// �� �ʿ��� ������ ���� ���ϱ�
			// ��50��. ��ȭ�鿡�����ٱ� 10�� => 50/10 = 5 
			// ��55��. ��ȭ�鿡�����ٱ� 10�� => 55/10 = 5 + 1������(����������) => 6
			int pageCount = (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
			//int pageCount = (int) Math.ceil((double) count / pageSize);
			
			// �� ȭ�鿡 ������ ���������� ����
			int pageBlock = 5;
			
			// ȭ�鿡 ������ ������������ȣ ���ϱ�
			// 1~5          6~10          11~15          16~20       ...
			// 1~5 => 1     6~10 => 6     11~15 => 11    16~20 => 16
			int startPage = ((pageNum / pageBlock) - (pageNum % pageBlock == 0 ? 1 : 0)) * pageBlock + 1;
			
			// ȭ�鿡 ������ ����������ȣ ���ϱ�
			int endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) {
				endPage = pageCount;
			}
			
			// �信�� �ʿ��� �����͸� PageDto�� ����
			pageDto.setCategory(category);
			pageDto.setSearch(search);
			pageDto.setCount(count);
			pageDto.setPageCount(pageCount);
			pageDto.setPageBlock(pageBlock);
			pageDto.setStartPage(startPage);
			pageDto.setEndPage(endPage);
		} // if
		
		
		// ��(jsp)���� ����� �����͸� request ������ü�� ����
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageDto", pageDto);
		request.setAttribute("pageNum", pageNum);
		
		
		return "center/fileNotice";
	}

}
