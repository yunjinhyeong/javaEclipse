package ex4_3;

class Goods {
	// 1.�������
	private String name;
	private int price;
	private int numberOfStock;
	private int sold;
	
	Goods()
	{
		
	}

	// 2.������ - ������� �ʱⰪ �Ҵ�, ����? ��ü�� ����� ����, ��Ȯ�� �̺κ�-> new Goods("0",1,2,3);
	Goods(String name, int price, int numberOfStock, int sold) {
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = sold;
	}

	// 3.�޼ҵ�
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
