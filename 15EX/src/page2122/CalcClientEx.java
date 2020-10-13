package page2122;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalcClientEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in); // Ű���忡�� ���� scanner ��ü ����
		try {
			socket = new Socket("localhost",9999); // Ŭ���̾�Ʈ ���� ����, ������ ����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.print("����(��ĭ���� ��� �Է�, ��:24 + 42)>>"); // ������Ʈ
				String outputMessage = scanner.nextLine(); // Ű���忡�� ���� �б�
				if (outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n"); // "bye" ���ڿ� ����
					out.flush();
					break; // ����ڰ� "bye"�� �Է��� ��� ������ ���� �� ���� ����
				}
				out.write(outputMessage + "\n"); // Ű���忡�� ���� ���� ���ڿ� ����
				out.flush(); // out�� ��Ʈ�� ���ۿ� �ִ� ��� ���ڿ� ����
				String inputMessage = in.readLine(); // �����κ��� ��� ��� ����
				System.out.println("��� ��� :" + inputMessage);
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				if(socket != null) socket.close(); // Ŭ���̾�Ʈ ���� �ݱ�
			} catch (IOException e) {
				System.out.println("������ ä�� �� ���� �߻���");
			}
		}

	}

}
