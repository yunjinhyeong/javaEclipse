package flowTest;

import java.util.Scanner;

public class ex11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��Ͻÿ� >>> ");
		int x = sc.nextInt();
		
		if(x>=3 && x<=5)
			System.out.println("��");
		else if(x>=6 && x<=8)
			System.out.println("����");
		else if(x>=9 && x<=11)
			System.out.println("����");
		else if(x==12 || x>=1 && x<=2)
			System.out.println("�ܿ�");
		else
			System.out.println("�߸��Էµ�");
		
	
	}

}
