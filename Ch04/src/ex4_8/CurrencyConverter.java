package ex4_8;

class CurrencyConverter 
{
	private static double rate; // �ѱ� ��ȭ�� ���� ȯ��

	public static double toDollar(double won) 
	{
		return won / rate; // �ѱ� ��ȭ�� �޷��� ��ȯ
	}

	public static double toKWR(double dollar) 
	{
		return dollar * rate; // �޷��� �ѱ� ��ȭ�� ��ȯ
	}

	public static void setRate(double r) 
	{
		rate = r; // ȯ�� ����. KWR/$1
	}
}
