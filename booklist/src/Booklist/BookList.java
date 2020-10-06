package Booklist;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList 
{
	//0.��������� ���鲫��... ������ 4������ �ִ�
	//�纯��
	int bookid;
	String bookname;
	String publisher;
	int price;
	
	//��迭
	int bookid_arr[];
	String bookname_arr[];
	String publisher_arr[];
	int price_arr[];
	
	//�鰴ü
	Book book1;
	
	//�갴ü�迭
	
	//1.�������
	Connection con=null; // �������
	Statement stmt;
	ResultSet rs;
	
	//2.������ - �뵵: �迭 �ʱ�ȭ
	public BookList()
	{
		//2�� �迭�� �ʱ�ȭ
		bookid_arr = new int[10];
		bookname_arr = new String[10];
		publisher_arr = new String[10];
		price_arr = new int[10];
		
		//3�� ��ü�� �ʱ�ȭ
		book1 = new Book();
		
		
	}

	//3.�޼ҵ� - ����(Connetcion)�� ���´�
	public void getCon() 
	{
		//url�� ���� ���ڿ��̴�! 
		String url = "jdbc:oracle:thin:@10.100.103.3:1521:xe";
		String userid = "madang"; // c##�߰�
		String pwd = "madang"; // c##�߰�

		//1.����̹� �ε带 ���� (���� �ȿ� Ŭ���� ����Ʈ)
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		//2.DB ���� (����Ŭ)
		try {
			System.out.println("�����ͺ��̽� ���� �غ� .....");
			//1.db ����
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (SQLException e) {
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
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
			
			int index=0;
			while (rs.next()) 
			{
				//0.��������
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4))
				
				////�纯��
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
				
//				//��迭
//				bookid_arr[index] = rs.getInt(1);
//				bookname_arr[index] = rs.getString(2);
//				publisher_arr[index] = rs.getString(3);
//				price_arr[index] = rs.getInt(4); 
//				index++;
				
				//�鰴ü
				book1.bookid = rs.getInt(1);
				book1.bookname = rs.getString(2);
				book1.publisher = rs.getString(3);
				book1.price = rs.getInt(4); 
				
				

			}
			
//			con.close();//db������ ����!
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3.�޼ҵ� - ȭ�� ��� �޼ҵ� 1�� <����>��
	public void printBook()
	{
		System.out.println(bookid + "\t" 
				 + bookname + "\t"
				 + publisher + "\t"
				 + price + "\t"
				 );
	}

	//3.�޼ҵ� - ȭ�� ��� �޼ҵ� 2�� <�迭>��
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
	
//	//3.�޼ҵ� - ȭ�� ��� �޼ҵ� 3�� <��ü>�� -> Book Ŭ���� ������ �ű��
//		public void printBook_object()
//		{
//			System.out.println(book1.bookid + "\t" 
//					 + book1.bookname + "\t"
//					 + book1.publisher + "\t"
//					 + book1.price + "\t"
//					 );
//		}

	
//	//3.�޼ҵ�2
//		public void selectCustomerList() 
//		{
//			String query = "SELECT * FROM customer";
//			try {
//				stmt = con.createStatement(); // 2
//				rs = stmt.executeQuery(query); // 3
//				System.out.println("�� ���̵� \t ���̸� \t�ּ� \t\t��ȭ��ȣ");
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

//	public static void main(String args[]) { // �޼ҵ��̸鼭 ���α׷����࿡ ������
//		BookList so = new BookList();
//		so.sqlRun();
//	}
}
