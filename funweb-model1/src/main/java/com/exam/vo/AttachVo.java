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
	private String filename;   // 실제 업로드된 파일명
	private String uploadpath; // 실제 업로드된 폴더 경로
	private String image;      // 파일이 이미지인지 여부. "I"는 이미지, "O"는 이미지 아님
	private int noNum;    // notice 테이블의 글번호 num
}
