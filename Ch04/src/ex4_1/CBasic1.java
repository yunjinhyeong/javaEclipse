package ex4_1;

public class CBasic1 {
	public static void main(String[] args) 
	{
		Goods camera = new Goods();
		
		Goods camera2 = new Goods();
		Goods camera3 = new Goods();

		//camera��ü ��� - ���� �Է�(set)
		camera.name = "Nikon";
		camera.price = 400000;
		camera.numberOfStock = 30;
		camera.sold = 50;
		
		//camera��ü ��� - ���� ���(�������� get)
		System.out.println("��ǰ �̸�:" + camera.name);
		System.out.println("��ǰ ����:" + camera.price);
		System.out.println("��� ����:" + camera.numberOfStock);
		System.out.println("�ȸ� ����:" + camera.sold);
	}
}
