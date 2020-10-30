package java1030;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ex4 {
	
	public static void listDirectory(File dir) {
		System.out.println("---" + dir.getParent() + "�� ���� ����Ʈ�Դϴ�. ---");
		
		File[] files = dir.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(File file : files) {
			System.out.print(file.getName());
			System.out.print(file.isDirectory() ? "\t<DIR>" : "\t");
			System.out.print("\t����ũ��: " + file.length());
			
			long milis = file.lastModified();
			Date date = new Date(milis);
			String str = sdf.format(date);
			System.out.println("\t������ �ð�: " + str);
		}
	} // listDirectory
	
	public static void main(String[] args) {
		// File Ŭ����
		File file1 = new File("C:/Users/admin/testFolder/testWrite.txt");
		System.out.println(file1.getPath());
		System.out.println(file1.getParent());
		System.out.println(file1.getName());
		
		if (file1.isFile()) {
			System.out.println("�����Դϴ�.");
		} else if (file1.isDirectory()) {
			System.out.println("���丮�Դϴ�.");
		}
		// sample �� �������� ����
		File file2 = new File("C:/Users/admin/testFolder/sample"); // ���θ�������ϴ� ���丮
		if(!file2.exists()) { // ���丮 ���� �˻�
			file2.mkdir(); // �������� ������ ����
		}
		listDirectory(new File("C:/Users/admin/testFolder"));
	}

}
