package com.exam.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class AttachVo {
	
	private int num;
	private String filename;   // ���� ���ε�� ���ϸ�
	private String uploadpath; // ���� ���ε�� ���� ���
	private String image;      // ������ �̹������� ����. "I"�� �̹���, "O"�� �̹��� �ƴ�
	private int noNum;    // notice ���̺��� �۹�ȣ num
}
