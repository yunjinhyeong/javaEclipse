package flowTest;

import java.util.Scanner;

public class switchEx12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� >>> ");
		double n1 = sc.nextDouble();
		String op = sc.next();
		double n2 = sc.nextDouble();
		
		double result = 0.0;
		
		switch(op) {
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "*":
			result = n1 * n2;
			break;
		case "/":
			if(n2 == 0) {
				System.out.println("0���� ������ �����ϴ�.");
				sc.close();
				return;
			}
			else
				result = n1 / n2;
			break;
		default:
			System.out.println("��Ģ������ �ƴմϴ�.");
			
		sc.close();
		
		}

	}

}
