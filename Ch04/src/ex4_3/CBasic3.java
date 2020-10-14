package ex4_3;

import java.util.Scanner;

public class CBasic3 {
	public static void main(String[] args) 
	{
		//객체 배열~! 중요!
		Goods [] ga;
		ga = new Goods [3];//대괄호!
		
		Goods ga2[] = new Goods[5];//대괄호!, 배열

        Scanner s = new Scanner(System.in);
        
		for(int i=0; i<ga.length; i++) {
			String name = s.next();
			int price = s.nextInt();
			int n = s.nextInt();
			int sold = s.nextInt();
			
			//객체 배열(ga)의 각 원소(ex.ga[0], ga[1], ga[2])에 
			//객체(new Goods())를 만들어 넣는다.
			ga[i] = new Goods(name, price, n, sold);//소괄호, 생성자
		}
		
		for(int i=0; i<ga2.length;++i)
		{
			ga2[i] = new Goods();//소괄호, 배열은 항상 반복문과 쓰일꺼다
			ga2[i].setName("홍길동");
		}
		
		for(int i=0; i<ga.length; i++) {
			System.out.print(ga[i].getName()+" ");
			System.out.print(ga[i].getPrice()+" ");
			System.out.print(ga[i].getNumberOfStock()+" ");
			System.out.println(ga[i].getSold());
		}
		
		for(int i=0; i<ga2.length;++i)
		{
			System.out.println(i+" - "+ga2[i].getName());
		}
	}
}
