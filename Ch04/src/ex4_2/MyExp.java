package ex4_2;
public class MyExp 
{
	int base;
	int exp;
	
	//�̷��� ���� �����ڰ� �����Ǿ��ִ�.
//	MyExp()
//	{
//		
//	}
	
	int getValue() 
	{
		int res=1;
		for(int i=0; i<exp; i++)
			res = res * base;
		return res;
	}

}
