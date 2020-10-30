package java1030;

import java.io.FileReader;
import java.io.IOException;

public class ex1 {

	public static void main(String[] args) {
	// �ڹ� IO(�����) ������ ����
	
		// byte ���� ó�� ����� : �̹������� ���� ���̳ʸ� ������ ������ �����
		//    InputStream �������̽� ������ Ŭ����
		//      - FileInputStream, BufferedInputStream
		//    OutputStream �������̽� ������ Ŭ����
		//      - FileOutputStream, BufferedOutputStream
		
		// char ���� ó�� ����� : ������� charó��, �ؽ�Ʈ ������ ������ �����
		//    Reader �������̽� ������ Ŭ���� ============= �⺻������ ���� ����
		//      - FileReader, InputStreamReader, BufferedReader
		//    Writer �������̽� ������ Ŭ���� ============= �⺻������ ���� ���� �׷��� flush()�������
		//      - FileWriter, OutputStreamWriter, BufferedWriter
		
		// FileReader�� �ؽ�Ʈ ���� �о �ܼ�ȭ�鿡 ����ϱ�
		
		// �Է½�Ʈ�� �غ�
		FileReader reader = null;
		
		// ���� �߰� ���ҽ�
		try {
			reader = new FileReader("C:/Users/admin/testFolder/testFile.txt");
			
			int c;
			while ((c = reader.read()) != -1) { // ������ ��(-1)�� �ƴҶ����� ���� �Ѱ��� ����
				System.out.print((char)c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
