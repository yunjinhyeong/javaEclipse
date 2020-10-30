package java1030;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex6 {

	public static void main(String[] args) {
	// �ؽ�Ʈ ���� �����ϱ�
	File src = new File("C:/Users/admin/testFolder", "testFile.txt");
	File dest = new File("C:/Users/admin/testFolder", "testFile - ���纻.txt");
	
	if (!src.exists()) {
		System.out.println("������ ���� " + src.getName() + " �� �������� �ʽ��ϴ�.");
		return;
	}
	
	// �Է½�Ʈ�� �غ�
	BufferedReader reader = null;
	
	// ��½�Ʈ�� �غ�
	FileWriter writer = null;
	
	
	try {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(src), "utf-8"));
//		reader = new BufferedReader(new FileReader(src)); // �ѱ� ó�� ����
		writer = new FileWriter(dest);
		
		String line = "";
		while((line = reader.readLine()) != null) {
			writer.write(line + "\n"); // + "\n" ����� ���� ������� ���� ����
		}
		System.out.println("���Ϻ��� �Ϸ�");
	} catch (Exception e) {
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
