package com.exam.vo;

import lombok.Data;

@Data
public class AttachVo {
	
	private int num;
	private String filename;   // ���� ���ε�� ���ϸ�
	private String uploadpath; // ���� ���ε�� ���� ���
	private String image;      // ������ �̹������� ����. "I"�� �̹���, "O"�� �̹��� �ƴ�
	private int noNum;    // notice ���̺��� �۹�ȣ num
			
}
