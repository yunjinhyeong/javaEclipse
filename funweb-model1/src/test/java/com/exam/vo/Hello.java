package com.exam.vo;

import java.sql.SQLException;

public class Hello {

	public static String helloWorld() {
		return "Hello world!";
	}
	
	public static int[] getNumArr() {
		return new int[] { 10, 20, 30 };
	}
	
	public static void receivePositiveNumber(int num) throws Exception {
		if (num < 0) {
			throw new SQLException("Negative number is not possible");
			
			// ���� �ذ��� �ʿ� ����
		}
	}
}
