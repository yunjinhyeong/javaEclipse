package ex04;

import java.util.Scanner;

public class Calculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		String c;
		
		
			System.out.print("�� ������ �����ڸ� �Է��Ͻÿ� >>>");
			a=sc.nextInt();
			b=sc.nextInt();
			c=sc.next();
			switch(c) {
				case "+":
					Add add = new Add();
					add.setValue(a, b);
					System.out.println(add.Calculate());
					break;
				case "-":
					Sub sub = new Sub();
					sub.setValue(a, b);
					System.out.println(sub.Calculate());
					break;
				case "*":
					Mul mul = new Mul();
					mul.setValue(a, b);
					System.out.println(mul.Calculate());
					break;
				case "/":
					Div div = new Div();
					div.setValue(a, b);
					System.out.println(div.Calculate());
					break;
				default:
					System.out.println("�����ȣ�� �߸��Է��߽��ϴ�.");
					break;
			}
		
		
		
		

	}

}
