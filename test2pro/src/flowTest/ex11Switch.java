package flowTest;

import java.util.Scanner;

public class ex11Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��Ͻÿ� >>> ");
		int x = sc.nextInt();
		
		switch(x)
		{
			case 3:
			case 4:
			case 5:
				System.out.println("��");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("����");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("����");
				break;
			case 1:
			case 2:
			case 12:
				System.out.println("�ܿ�");
				break;
		}
		sc.close();
	}

}
