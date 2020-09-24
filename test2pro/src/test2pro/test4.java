package test2pro;
import java.util.*;

public class test4 {

	public static void main(String[] args) {
		System.out.print("정수 3개 입력>>");
		Scanner a = new  Scanner(System.in);
		
		int num1 = a.nextInt();
		int num2 = a.nextInt();
		int num3 = a.nextInt();
		
		if((num1>num2 && num1<num3)||(num1<num2 && num1>num3)) {
			System.out.println(num1);
		} else if((num2>num1 && num2<num3)||(num2<num1 && num2>num3)) {
			System.out.println(num2);
		} else if((num3>num1 && num3<num2)||(num3<num1 && num3>num2)) {
			System.out.println(num3);
		}

	}

}
