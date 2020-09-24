package test2pro;
import java.util.*;

public class test3 {

	public static void main(String[] args) {
		System.out.print("금액을 입력하시오>>");
		Scanner a = new Scanner(System.in);
		int fin = a.nextInt();
		int fiveA = fin/50000;
		System.out.println("오만원권 "+fiveA+"매");
		int tenA = (fin-(fiveA*50000))/10000;
		System.out.println("만원권 "+tenA+"매");
		int tousA = (fin-(fiveA*50000)-(tenA*10000))/1000;
		System.out.println("천원권 "+tousA+"매");
		int fiveHA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000))/500;
		System.out.println("오백원 "+fiveHA+"개");
		int hunA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000)-(fiveHA*500))/100;
		System.out.println("백권 "+hunA+"개");
		int fivA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000)-(fiveHA*500)-(hunA*100))/50;
		System.out.println("오십원 "+fivA+"개");
		int teA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000)-(fiveHA*500)-(hunA*100)-(fivA*50))/10;
		System.out.println("십원 "+teA+"개");
		
		
		
		

	}

}
