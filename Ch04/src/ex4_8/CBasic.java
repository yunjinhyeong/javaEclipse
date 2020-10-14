package ex4_8;

public class CBasic {
	public static void main(String[] args) 
	{
		CurrencyConverter.setRate(1121); // 미국 달러 환율 설정
		System.out.println("백만원은 " + CurrencyConverter.toDollar(1000000) + "달러입니다.");
		System.out.println("백달러는 " + CurrencyConverter.toKWR(100) +"원입니다.");
	}
}
