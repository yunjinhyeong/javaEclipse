package test2pro;
import java.util.*;

public class test3 {

	public static void main(String[] args) {
		System.out.print("�ݾ��� �Է��Ͻÿ�>>");
		Scanner a = new Scanner(System.in);
		int fin = a.nextInt();
		int fiveA = fin/50000;
		System.out.println("�������� "+fiveA+"��");
		int tenA = (fin-(fiveA*50000))/10000;
		System.out.println("������ "+tenA+"��");
		int tousA = (fin-(fiveA*50000)-(tenA*10000))/1000;
		System.out.println("õ���� "+tousA+"��");
		int fiveHA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000))/500;
		System.out.println("����� "+fiveHA+"��");
		int hunA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000)-(fiveHA*500))/100;
		System.out.println("��� "+hunA+"��");
		int fivA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000)-(fiveHA*500)-(hunA*100))/50;
		System.out.println("���ʿ� "+fivA+"��");
		int teA = (fin-(fiveA*50000)-(tenA*10000)-(tousA*1000)-(fiveHA*500)-(hunA*100)-(fivA*50))/10;
		System.out.println("�ʿ� "+teA+"��");
		
		
		
		

	}

}
