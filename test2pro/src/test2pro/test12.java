package test2pro;
import java.util.*;

public class test12 {
	
	public static void main(String[] args) {
		System.out.print("연산>>");
		Scanner a = new  Scanner(System.in);
		int num1 = a.nextInt();
		String s = a.next();
		int num2 = a.nextInt();
		
		double result1=num1+num2;
		double result2=num1-num2;
		double result3=num1*num2;
		double result4=num1/num2;
		
		if (num2==0) {
			System.out.println("0으로 나눌 수 없습니다.");
		} else {
			switch(s) {
				case "+":
					System.out.println(num1+"+"+num2+"의 계산 결과는 "+result1);
					break;
				case "-":
					System.out.println(num1+"+"+num2+"의 계산 결과는 "+result1);
					break;
				case "*":
					System.out.println(num1+"+"+num2+"의 계산 결과는 "+result1);
					break;
				case "/":
					System.out.println(num1+"+"+num2+"의 계산 결과는 "+result1);	
					break;
			}
		}
	}
}
