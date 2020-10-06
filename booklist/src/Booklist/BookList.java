package Booklist;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList 
{
	//0.멤버변수를 만들껀데... 종류가 4종류가 있다
	//①변수
	int bookid;
	String bookname;
	String publisher;
	int price;
	
	//②배열
	int bookid_arr[];
	String bookname_arr[];
	String publisher_arr[];
	int price_arr[];
	
	//③객체
	Book book1;
	
	//④객체배열
	
	//1.멤버변수
	Connection con=null; // 멤버변수
	Statement stmt;
	ResultSet rs;
	
	//2.생성자 - 용도: 배열 초기화
	public BookList()
	{
		//2번 배열용 초기화
		bookid_arr = new int[10];
		bookname_arr = new String[10];
		publisher_arr = new String[10];
		price_arr = new int[10];
		
		//3번 객체용 초기화
		book1 = new Book();
		
		
	}

	//3.메소드 - 연결(Connetcion)을 얻어온다
	public void getCon() 
	{
		//url은 연결 문자열이다! 
		String url = "jdbc:oracle:thin:@10.100.103.3:1521:xe";
		String userid = "madang"; // c##추가
		String pwd = "madang"; // c##추가

		//1.드라이버 로드를 위한 (파일 안에 클래스 임포트)
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		//2.DB 연결 (오라클)
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			//1.db 연결
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//3.메소드1
	public void selectBookList() 
	{
		String query = "SELECT * FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
			
			int index=0;
			while (rs.next()) 
			{
				//0.변수없음
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4))
				
				////①변수
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4); 
				
//				printBook();
				
//				System.out.println(bookid + "\t" 
//								 + bookname + "\t"
//								 + publisher + "\t"
//								 + price + "\t"
//								 );
				
//				//②배열
//				bookid_arr[index] = rs.getInt(1);
//				bookname_arr[index] = rs.getString(2);
//				publisher_arr[index] = rs.getString(3);
//				price_arr[index] = rs.getInt(4); 
//				index++;
				
				//③객체
				book1.bookid = rs.getInt(1);
				book1.bookname = rs.getString(2);
				book1.publisher = rs.getString(3);
				book1.price = rs.getInt(4); 
				
				

			}
			
//			con.close();//db연결을 닫음!
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3.메소드 - 화면 출력 메소드 1번 <변수>용
	public void printBook()
	{
		System.out.println(bookid + "\t" 
				 + bookname + "\t"
				 + publisher + "\t"
				 + price + "\t"
				 );
	}

	//3.메소드 - 화면 출력 메소드 2번 <배열>용
	public void printBook_arr()
	{
		for(int i=0; i<bookid_arr.length; ++i)
		{
			System.out.println(bookid_arr[i] + "\t" 
					 + bookname_arr[i] + "\t"
					 + publisher_arr[i] + "\t"
					 + price_arr[i] + "\t"
					 );
		}
	}
	
//	//3.메소드 - 화면 출력 메소드 3번 <객체>용 -> Book 클래스 안으로 옮긴다
//		public void printBook_object()
//		{
//			System.out.println(book1.bookid + "\t" 
//					 + book1.bookname + "\t"
//					 + book1.publisher + "\t"
//					 + book1.price + "\t"
//					 );
//		}

	
//	//3.메소드2
//		public void selectCustomerList() 
//		{
//			String query = "SELECT * FROM customer";
//			try {
//				stmt = con.createStatement(); // 2
//				rs = stmt.executeQuery(query); // 3
//				System.out.println("고객 아이디 \t 고객이름 \t주소 \t\t전화번호");
//				while (rs.next()) {
//					System.out.print("" + rs.getInt(1));
//					System.out.print("\t" + rs.getString(2));
//					System.out.print("\t" + rs.getString(3));
//					System.out.println("\t" + rs.getString(4));
//
//				}
////				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
		public void closeDB()
		{
			try {
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

//	public static void main(String args[]) { // 메소드이면서 프로그램실행에 관여함
//		BookList so = new BookList();
//		so.sqlRun();
//	}
}
