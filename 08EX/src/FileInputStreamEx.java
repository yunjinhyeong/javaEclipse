import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		byte b[] = new byte[6]; //����ִ� byte�迭
		try {
			FileInputStream fin = new FileInputStream("C:\\Windows\\Temp\\test.out");
			int n = 0, c;
			while((c=fin.read())!=-1) {
				b[n]=(byte)c;
				n++;
			}
			System.out.println("C:\\Windows\\Temp\\test.out���� ���� �迭�� ����մϴ�.");
			for( int i=0 ; i<b.length ; i++ ) System.out.print(b[i]+" ");
			System.out.println();
			fin.close();
		}catch(IOException e) {
			System.out.println("C:\\Windows\\Temp\\test.out���� ���� ���߽��ϴ�. ��θ��� üũ�غ�����");
		}
	}
}
