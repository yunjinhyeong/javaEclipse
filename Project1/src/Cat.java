public class Cat
{
	//Ŭ������ ������� 3����
	//1. �ɹ�����
	int num_of_leg;
	float weight;
	String name;
	
	//2. ������ (�żҵ�) - �ɹ������� �ʱⰪ�� �����Ѵ�
	Cat() //��ȯ������
	{
		num_of_leg = 4;
		weight = 10.5f;
	}
	//3. (�Ϲ�) �żҵ� - ����(������)�� ����
	void printCat()
	{
		System.out.println("����� �ٸ� ������?" + num_of_leg);
	}

	void runCat()
	{
		System.out.println("����̰� �޸���");
	}
}