import java.io.*;
import java.util.Scanner;

public class BuffereadIOEx {
	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("C:\\Windows\\Temp\\test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			while((c=fin.read())!=-1) {
				out.write(c);
			}
			//���� �����Ͱ� ��� ��µ� ����
			new Scanner(System.in).nextLine();
			out.flush();//���ۿ� ���� �ִ� ���� ��� ��� ! �ٵ� ����ǵ絥?
			fin.close();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
