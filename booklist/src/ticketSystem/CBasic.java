package ticketSystem;

public class CBasic {

	public static void main(String[] args) {
		UserInfo user1, user2;
		user1 = new UserInfo("idaaa","pwaaa","ȫ�浿","010-111-1111",50000,"��Ÿ����2 ��������");
		user2 = new UserInfo("idbbb","pwbbb","������","010-222-2222",20000,"��ŷ");
		MovieInfo userM1, userM2;
		userM1 = new MovieInfo("A", "��Ÿ����2 ��������", 50000, 1 , 13);
		userM2 = new MovieInfo("B", "��ŷ", 20000, 2 , 11);
		user1.leftMoney();		
		userM1.info();
		user2.leftMoney();
		userM2.info();
		
		
	}

}
