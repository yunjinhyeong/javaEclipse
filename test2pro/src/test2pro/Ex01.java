package test2pro;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("원화를 입력하세요>>>");
		int won = sc.nextInt();
		
		double dollar =won / 1216.0;
		
		dollar = (int)(dollar *100)/100.0;
		
		System.out.println(won+"원 은"+dollar+"입니다");
		
		sc.close();
	}
}