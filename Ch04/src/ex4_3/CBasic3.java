package ex4_3;

import java.util.Scanner;

public class CBasic3 {
	public static void main(String[] args) 
	{
		//��ü �迭~! �߿�!
		Goods [] ga;
		ga = new Goods [3];//���ȣ!
		
		Goods ga2[] = new Goods[5];//���ȣ!, �迭

        Scanner s = new Scanner(System.in);
        
		for(int i=0; i<ga.length; i++) {
			String name = s.next();
			int price = s.nextInt();
			int n = s.nextInt();
			int sold = s.nextInt();
			
			//��ü �迭(ga)�� �� ����(ex.ga[0], ga[1], ga[2])�� 
			//��ü(new Goods())�� ����� �ִ´�.
			ga[i] = new Goods(name, price, n, sold);//�Ұ�ȣ, ������
		}
		
		for(int i=0; i<ga2.length;++i)
		{
			ga2[i] = new Goods();//�Ұ�ȣ, �迭�� �׻� �ݺ����� ���ϲ���
			ga2[i].setName("ȫ�浿");
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
