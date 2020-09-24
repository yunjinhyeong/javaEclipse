package practice03;

import java.util.Scanner;

public class ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 몇개? ");
		int i[] = new int [sc.nextInt()];
		for( int a=0 ; a<i.length ; a++,System.out.print('\s')) {
				i[a] = (int)(Math.random()*100 +1);
				System.out.print(i[a]);
		}
	}

}
