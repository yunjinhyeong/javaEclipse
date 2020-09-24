package test2pro;
import java.util.*;

public class test1 {

	public static void main(String[] args) {
		System.out.print("원화를 입력하세요(단위)>>");
		Scanner a = new Scanner(System.in);
		double won = a.nextInt();
		double result = won/1216;
		result = (int)(result*100)/100.0;
		System.out.println("$"+result);
	}
}