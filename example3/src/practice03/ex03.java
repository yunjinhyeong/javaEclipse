package practice03;

import java.util.Scanner;

public class ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하시오>> ");
		int num = sc.nextInt();
		
		for( int i=0 ; i<5 ; i++, System.out.println()) {
			for( int j=0 ; j<num ; j++ ) {
				System.out.print("*");
			}
			num=num-1;
				
		}

	}

}
