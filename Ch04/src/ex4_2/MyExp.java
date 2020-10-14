package ex4_2;
public class MyExp 
{
	int base;
	int exp;
	
	//이렇게 생긴 생성자가 생략되어있다.
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
