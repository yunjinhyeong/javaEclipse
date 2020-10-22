package com.exam.vo;

import java.sql.Timestamp;

public class BoardVo {
	private int num;
	private String name;
	private String passwd;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp regDate;
	private String ip;
	private String file;
	private int reRef; // �׷��ȣ, �ֱ۹�ȣ�� �׷��Ȥ�� ��
	private int reLev; // �鿩���� ���� 1�̸� �鿩���� 1��
	private int reSeq; // �׷� �������� ���� 0�� ���μ���
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getReRef() {
		return reRef;
	}
	public void setReRef(int reRef) {
		this.reRef = reRef;
	}
	public int getReLev() {
		return reLev;
	}
	public void setReLev(int reLev) {
		this.reLev = reLev;
	}
	public int getReSeq() {
		return reSeq;
	}
	public void setReSeq(int reSeq) {
		this.reSeq = reSeq;
	}
	// ������� ȿ�������� �ϱ�����
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", name=" + name + ", passwd=" + passwd + ", subject=" + subject + ", content="
				+ content + ", readcount=" + readcount + ", regDate=" + regDate + ", ip=" + ip + ", file=" + file
				+ ", reRef=" + reRef + ", reLev=" + reLev + ", reSeq=" + reSeq + "]";
	}
}
