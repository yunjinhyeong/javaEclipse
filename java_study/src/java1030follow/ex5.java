package java1030follow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex5 {

	public static void main(String[] args) {
		File src = new File("C:/Users/admin/testFolder", "testFile.txt");
		File dest = new File("C:/Users/admin/testFolder", "testFile - copy.txt");
		
		if(!src.exists()) {
			System.out.println("복사할 파일 " + src.getName() + "이 존재하지 않습니다.");
			return;
		}
//		if(!dest.exists()) {
//			System.out.println("dest 을 생성했습니다.");
//			dest.mkdir();
//		}
		BufferedReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(src),"utf-8"));
			writer = new FileWriter(dest);
			
			String line = "";
			while((line = reader.readLine()) != null) {
				writer.write(line+"\n");
			}
			System.out.println("파일 복사 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
