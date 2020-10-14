package ex4_1;

public class CBasic1 {
	public static void main(String[] args) 
	{
		Goods camera = new Goods();
		
		Goods camera2 = new Goods();
		Goods camera3 = new Goods();

		//camera객체 사용 - 값을 입력(set)
		camera.name = "Nikon";
		camera.price = 400000;
		camera.numberOfStock = 30;
		camera.sold = 50;
		
		//camera객체 사용 - 값을 출력(가져오기 get)
		System.out.println("상품 이름:" + camera.name);
		System.out.println("상품 가격:" + camera.price);
		System.out.println("재고 수량:" + camera.numberOfStock);
		System.out.println("팔린 수량:" + camera.sold);
	}
}
