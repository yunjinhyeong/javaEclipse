package practice03;

import java.util.Scanner;

public class ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 10개를 입력하시오 >>> ");
		int nums[] = new int [10];
		
		for( int i=0 ; i<10 ; i++)	{
			nums[i] = sc.nextInt();
			if((nums[i]%3==0) && (nums[i]!=0) ) {
				System.out.println(nums[i]);
		} else {
			System.out.println("앤 3의배수아님");
		}
	}
}	
}
