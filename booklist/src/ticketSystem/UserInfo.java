package ticketSystem;

public class UserInfo {
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	private int money;
	private String ticketName;
	private int moneyResult;
	
	public UserInfo(String id, String pw, String name, String phoneNum, int money, String ticketName) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.phoneNum=phoneNum;
		this.money=money;
		this.ticketName=ticketName;
	}
	
	public void leftMoney() {
		moneyResult = 0;
		int price = 0;
		if(ticketName=="��Ÿ����2") {
			price = 8000;
		} else if(ticketName=="��Ÿ����2 ��������") {
			price = 5000;
		} else if(ticketName=="��ŷ") {
			price = 9000;
		}		
		moneyResult = money - price;
		System.out.println(name+"�� ���� �� = "+moneyResult);
	}
//	����(���̵� �н����� �̸� ���ѹ� �Ӵ� Ƽ��)
//		Ƽ�� - Ƽ�Ϲ�ȣ ��ȭ�� Ƽ�ϰ��� �¼���ȣ �󿵽ð�
//		- ��Ÿ����2
//		- ��Ÿ����2 ��������
//		- ��ŷ
//	������ Ƽ��
//	������
}
