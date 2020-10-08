package ticketSystem;

public class CBasic {

	public static void main(String[] args) {
		UserInfo user1, user2;
		user1 = new UserInfo("idaaa","pwaaa","홍길동","010-111-1111",50000,"스타워즈2 조조할인");
		user2 = new UserInfo("idbbb","pwbbb","강감찬","010-222-2222",20000,"더킹");
		MovieInfo userM1, userM2;
		userM1 = new MovieInfo("A", "스타워즈2 조조할인", 50000, 1 , 13);
		userM2 = new MovieInfo("B", "더킹", 20000, 2 , 11);
		user1.leftMoney();		
		userM1.info();
		user2.leftMoney();
		userM2.info();
		
		
	}

}
