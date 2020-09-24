package test2pro;
import java.util.*;

public class test7 {

	public static void main(String[] args) {
		System.out.print("점 (x,y)의 좌표를 입력하시오>>");
		Scanner a = new  Scanner(System.in);
		int num1 = a.nextInt();
		int num2 = a.nextInt();
		
		if((100<=num1)&&(200>=num1)&&(100<=num2)&&(200>=num2)) {
			System.out.println("("+num1+", "+num2+")는 사각형 안에 있습니다.");
		} else {
			System.out.println("("+num1+", "+num2+")는 사각형 안에 없습니다.");
		}
	}

}
