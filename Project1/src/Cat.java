public class Cat
{
	//클래스의 구성요소 3가지
	//1. 맴버변수
	int num_of_leg;
	float weight;
	String name;
	
	//2. 생성자 (매소드) - 맴버변수에 초기값을 지정한다
	Cat() //반환값없다
	{
		num_of_leg = 4;
		weight = 10.5f;
	}
	//3. (일반) 매소드 - 동작(움직임)을 구현
	void printCat()
	{
		System.out.println("고양이 다리 갯수는?" + num_of_leg);
	}

	void runCat()
	{
		System.out.println("고양이가 달린다");
	}
}