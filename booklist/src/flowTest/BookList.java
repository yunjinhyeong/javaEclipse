package flowTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookList {
	//(1) 변수
	int bookId;
	String bookName;
	String bookPublisher;
	int bookPrice;
	
	Connection con=null; // 멤버변수
	Statement stmt;
	ResultSet rs;
	
	Book book1;
	
	public void getCon() {
		// url은 연결 문자열이다!
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang"; // c##추가
		String pwd = "madang"; // c##추가
		
		// 1.드라이버 로드를 위한 (파일 안에 클래스 임포트)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("드라이버 로드 성공");
		} catch (Exception e) {
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
				System.out.println("BOOK ID \tBOOK NAME \tPUBLISHER \tPRICE");
				
				while (rs.next()) 
				{					
					////①변수
					bookId = rs.getInt(1);
					bookName = rs.getString(2);
					bookPublisher = rs.getString(3);
					bookPrice = rs.getInt(4); 
					
					book1 = new Book(bookId,bookName,bookPublisher,bookPrice);
					book1.printBookObject();
					
				}
				
			} catch (Exception e) {
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
}
