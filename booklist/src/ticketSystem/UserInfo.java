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
		if(ticketName=="스타워즈2") {
			price = 8000;
		} else if(ticketName=="스타워즈2 조조할인") {
			price = 5000;
		} else if(ticketName=="더킹") {
			price = 9000;
		}		
		moneyResult = money - price;
		System.out.println(name+"의 남은 돈 = "+moneyResult);
	}
//	유저(아이디 패스워드 이름 폰넘버 머니 티켓)
//		티켓 - 티켓번호 영화명 티켓가격 좌석번호 상영시간
//		- 스타워즈2
//		- 스타워즈2 조조할인
//		- 더킹
//	구매한 티켓
//	가진돈
}
