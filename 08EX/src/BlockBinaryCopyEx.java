import java.io.*;

public class BlockBinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
		File dest = new File("C:\\Windows\\Temp\\desert.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buf = new byte [1024*10]; //10KB ����
			while(true) {
				int n = fi.read(buf);//���� ũ�⸸ŭ �б�, n�� ���� ���� ����Ʈ
				fo.write(buf, 0, n);
				if(n<buf.length)
					break;
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath()+"��"+dest.getPath()+"�� �����Ͽ����ϴ�.");
		}catch(IOException e) {System.out.println("���� ���� ����");}
	}
}
