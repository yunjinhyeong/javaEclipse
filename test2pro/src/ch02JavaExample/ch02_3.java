package ch02JavaExample;
import java.io.IOException;
import java.io.InputStreamReader;
public class ch02_3 {

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		try {
			while (true) {
				int a = rd.read();
				if (a == -1)
					break;
				System.out.println((char)a);
			}
		}
		catch (IOException e) {
			System.out.println("입력 에러 발생");
		}
	}
}
