package ex4_3;

class Goods {
	// 1.멤버변수
	private String name;
	private int price;
	private int numberOfStock;
	private int sold;
	
	Goods()
	{
		
	}

	// 2.생성자 - 멤버변수 초기값 할당, 언제? 객체가 만들어 질때, 정확히 이부분-> new Goods("0",1,2,3);
	Goods(String name, int price, int numberOfStock, int sold) {
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = sold;
	}

	// 3.메소드
	String getName() {
		return name;
	}

	int getPrice() {
		return price;
	}

	int getNumberOfStock() {
		return numberOfStock;
	}

	int getSold() {
		return sold;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
}
