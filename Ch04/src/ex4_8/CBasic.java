package ex4_8;

public class CBasic {
	public static void main(String[] args) 
	{
		CurrencyConverter.setRate(1121); // �̱� �޷� ȯ�� ����
		System.out.println("�鸸���� " + CurrencyConverter.toDollar(1000000) + "�޷��Դϴ�.");
		System.out.println("��޷��� " + CurrencyConverter.toKWR(100) +"���Դϴ�.");
	}
}
