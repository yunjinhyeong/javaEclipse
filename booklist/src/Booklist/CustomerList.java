package Booklist;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerList 
{
	//1.멤버변수
	Connection con=null; // 멤버변수
	Statement stmt;
	ResultSet rs;

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

//	//3.메소드1
//	public void selectBookList() 
//	{
//		String query = "SELECT * FROM book";
//		try {
//			stmt = con.createStatement(); // 2
//			rs = stmt.executeQuery(query); // 3
//			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
//			while (rs.next()) {
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4));
//
//			}
//			
////			con.close();//db연결을 닫음!
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	//3.메소드1
		public void selectCustomerList() 
		{
			String query = "SELECT * FROM customer";
			try {
				stmt = con.createStatement(); // 2
				rs = stmt.executeQuery(query); // 3
				System.out.println("고객 아이디 \t 고객이름 \t주소 \t\t전화번호");
				while (rs.next()) {
					System.out.print("" + rs.getInt(1));
					System.out.print("\t" + rs.getString(2));
					System.out.print("\t" + rs.getString(3));
					System.out.println("\t" + rs.getString(4));

				}
//				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
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
