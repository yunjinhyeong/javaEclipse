package java1030;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		// 키보드 입력을 파일로 저장하기
		
		// 입력스트림 준비
		Scanner scanner = new Scanner(System.in);

		// 출력스트림 준비
		FileWriter writer = null;
		
		try {
			writer = new FileWriter("C:/Users/admin/testFolder/testWrite.txt", true);
			
			System.out.println("키보드로 문자를 입력하세요.");
			
			String line = "";
			while (true) {
				line = scanner.nextLine(); // 줄바꿈문자는 제외하고 한줄을 가져옴
				if (line.length() == 0) { // 엔터키만 입력한경우 빈문자열
					break;
				}
				
				writer.write(line + "\n"); //출력스트림 객체는 기본적으로 버퍼를 가짐.
			} // while
			writer.flush(); // 버퍼 비우기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // main

}
