package flowTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookList {
	//(1) ����
	int bookId;
	String bookName;
	String bookPublisher;
	int bookPrice;
	
	Connection con=null; // �������
	Statement stmt;
	ResultSet rs;
	
	Book book1;
	
	public void getCon() {
		// url�� ���� ���ڿ��̴�!
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang"; // c##�߰�
		String pwd = "madang"; // c##�߰�
		
		// 1.����̹� �ε带 ���� (���� �ȿ� Ŭ���� ����Ʈ)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	//3.�޼ҵ�1
		public void selectBookList() 
		{
			String query = "SELECT * FROM book";
			try {
				stmt = con.createStatement(); // 2
				rs = stmt.executeQuery(query); // 3
				System.out.println("BOOK ID \tBOOK NAME \tPUBLISHER \tPRICE");
				
				while (rs.next()) 
				{					
					////�纯��
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
