package com.exam.vo;

import java.sql.Timestamp;
import java.util.List;

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


	public NoticeVo() {
	}
	
	public int getNum() {
		return num;
	}
	public String getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public int getReadcount() {
		return readcount;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public String getIp() {
		return ip;
	}
	public int getReRef() {
		return reRef;
	}
	public int getReLev() {
		return reLev;
	}
	public int getReSeq() {
		return reSeq;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setReRef(int reRef) {
		this.reRef = reRef;
	}
	public void setReLev(int reLev) {
		this.reLev = reLev;
	}
	public void setReSeq(int reSeq) {
		this.reSeq = reSeq;
	}
	public List<AttachVo> getAttachList() {
		return attachList;
	}
	public void setAttachList(List<AttachVo> attachList) {
		this.attachList = attachList;
	}

	@Override
	public String toString() {
		return "NoticeVo [num=" + num + ", id=" + id + ", subject=" + subject + ", content=" + content + ", readcount="
				+ readcount + ", regDate=" + regDate + ", ip=" + ip + ", reRef=" + reRef + ", reLev=" + reLev
				+ ", reSeq=" + reSeq + ", attachList=" + attachList + "]";
	}

}
