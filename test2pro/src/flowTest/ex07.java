package flowTest;

import java.util.Scanner;

public class ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� >>> ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		// �簢�� (100, 100) , (200, 200)
		
		if((x>=100 && x<=200) && (y>=100 && y<=200))
		{
			System.out.println("�簢���ȿ� ����");
		} else
			System.out.println("�簢���ȿ� ����");
	}

}
