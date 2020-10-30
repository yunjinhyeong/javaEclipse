package java1030;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex7 {

	public static void main(String[] args) {
		// �ѱ� �ؽ�Ʈ ���� �����ϱ� - InputStreamReader "utf-8"����
		File src = new File("C:/Users/admin/testFolder", "hobbang.png");
		File dest = new File("C:/Users/admin/testFolder", "hobbang - ���纻.png");
		
		if (!src.exists()) {
			System.out.println("������ ���� " + src.getName() + " �� �������� �ʽ��ϴ�.");
			return;
		}
		
		// �Է½�Ʈ�� �غ�
		BufferedInputStream bis = null;
		// ��½�Ʈ�� �غ�
		FileOutputStream fos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			fos = new FileOutputStream(dest);
			
			int data;
			while ((data = bis.read()) != -1) { // ���ϳ��� ������ -1 �� ������
				fos.write(data);
			}
			
			System.out.println("���� ���� �Ϸ��!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // main

}
