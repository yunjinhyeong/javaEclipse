package flowTest;

import java.util.Scanner;

public class ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��°(x1, y1) ���� �߽ɰ� ������ �Է� >>> ");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int radius1 = sc.nextInt();
		
		System.out.print("�ι�°(x2, y2) ���� �߽ɰ� ������ �Է� >>> ");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int radius2 = sc.nextInt();
		
		double length = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		
		if (radius1+radius2 < length && radius1+radius2 < y2-y1) {
			System.out.println("�Ȱ�ħ");
		} else if (radius1+radius2 >= length && radius1+radius2 >= y2-y1){
			System.out.println("��ħ");
		} else
			System.out.println("�հ� ����");
			
		

	}

}
