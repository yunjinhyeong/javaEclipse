
public class MathEx {

	public static void main(String[] args) {
		double a = 3.5454;
		System.out.println(Math.PI); // 원주율 상수출력
		System.out.println(Math.ceil(a)); // ceil(올림)
		System.out.println(Math.floor(a)); // floor(내림)
		System.out.println(Math.sqrt(9)); // 제곱근
		// e는 다음의 극한식으로 표현되는 값이며 가장 일반적으로 정의되고 있는 야코프 베르누이의 방법이다
		// 상수 e는 2.71828182845904...
		System.out.println(Math.exp(2)); // e의 2승
		System.out.println(Math.round(3.14)); // 반올림
		
		// [1, 45] 사이의 정수형 난수 5개 발생
		System.out.println("이번주 행운의 번호는 ");
		for(int i=0 ; i<5 ; i++)
			System.out.println((int)(Math.random()*45+1)+"");
		

	}

}
