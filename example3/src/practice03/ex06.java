package practice03;

import java.util.Scanner;

public class ex06 {

	public static void main(String[] args) {
		int unit [] = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하시오 >> ");
		int into = sc.nextInt();		
		int num [] = new int [8]; 
		
		for( int i=0 ; i<8 ; i++) {
			num[i]=into/unit[i];
			if(num[i]!=0)
			System.out.println(unit[i]+"원 짜리 : "+num[i]+"개");
			into=into-unit[i]*num[i];
		}
			
	}
}
