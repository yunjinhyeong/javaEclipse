package java1030follow;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex7 {

	public static void main(String[] args) {
		File src = new File("C:/Users/admin/testFolder", "hobbang.png");
		File dest = new File("C:/Users/admin/testFolder", "hobbang-copy.png");
		
		if(!src.exists()) {
			System.out.println("복사할 파일"+src.getName()+"이 없음");
			return;
		}
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			fos = new FileOutputStream(dest);
			
			int data;
			while((data = bis.read()) != -1) {
				fos.write(data);
			}
			System.out.println("파일 복사 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
