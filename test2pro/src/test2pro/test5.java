package test2pro;
import java.util.*;

public class test5 {

	public static void main(String[] args) {
		System.out.print("정수 3개 입력하시오>>");
		Scanner a = new  Scanner(System.in);
		
		int num1 = a.nextInt();
		int num2 = a.nextInt();
		int num3 = a.nextInt();
		
		if ((num1+num2<num3)||(num2+num3<num1)||(num1+num3<num2)) {
			System.out.println("삼각형이 안됩니다.");
		} else {
			System.out.println("됌");
		}
	}

}
