package ex63;

public class StaticMember {

	public static void main(String[] args) {
		CurrencyConverter.setRate(1121);
		System.out.println("�鸸���� " + CurrencyConverter.toDollar(1000000)+"�޷��Դϴ�.");
		System.out.println("��޷��� " + CurrencyConverter.toKWR(100)+"���Դϴ�.");
	}

}
