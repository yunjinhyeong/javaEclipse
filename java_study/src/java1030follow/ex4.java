package java1030follow;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ex4 {
	
	public static void listDirectory(File dir) {
		System.out.println("---"+dir.getParent()+"�� ���� ����Ʈ �Դϴ�.");
		
		File[] files = dir.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(File file : files) {
			System.out.print(file.getName());
			System.out.print(file.isDirectory() ? "\t<DIR>" : "\t");
			System.out.print("\t����ũ��: "+file.length());
			
			long milis = file.lastModified();
			Date date = new Date(milis);
			String str = sdf.format(date);
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		listDirectory(new File("C:/Users/admin/testFolder"));
	}

}
