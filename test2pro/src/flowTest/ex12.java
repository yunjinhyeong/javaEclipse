package flowTest;

import java.util.Scanner;

public class ex12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연산 >>> ");
		double n1 = sc.nextDouble();
		String op = sc.next();
		double n2 = sc.nextDouble();

		double result = 0.0;

		//		if(op == "+")
		if(op.equals("+") )
			result = n1 + n2;
		else if(op.equals("-"))
			result = n1 - n2;
		else if(op.equals("*"))
			result = n1 * n2;
		else if(op.equals("/"))
			if(n2 == 0)
				System.out.println("0으로 나눌수 없습니다.");
			else
				result = n1 / n2;
		else {
			System.out.println("사칙연산이 아닙니다.");
			return;
		}
		System.out.println(result);
		sc.close();
	}

}
