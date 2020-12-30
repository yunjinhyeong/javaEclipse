package com.exam.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class NoticeVo {
	
	private int num;    // �Խ��� �۹�ȣ
	private String id;  // �ۼ��� ID
	private String subject;
	private String content;
	private int readcount;
	private Timestamp regDate;
	private String ip;
	private int reRef;  // �׷��ȣ. �ֱ۹�ȣ�� �׷��ȣ�� ��.
	private int reLev;  // �鿩���� ����
	private int reSeq;  // �׷� �������� ����
	
	//private AttachVo attachVo;        // JOIN���� 1:1�� �����϶�
	private List<AttachVo> attachList;  // JOIN���� 1:N�� �����϶�


}
