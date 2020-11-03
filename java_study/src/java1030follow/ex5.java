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
			System.out.println("������ ���� " + src.getName() + "�� �������� �ʽ��ϴ�.");
			return;
		}
//		if(!dest.exists()) {
//			System.out.println("dest �� �����߽��ϴ�.");
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
			System.out.println("���� ���� �Ϸ�");
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
