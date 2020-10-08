package customMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomList {
	Custom custom[];
	
	Connection con=null; // 멤버변수
	Statement stmt;
	ResultSet rs;
	
	public void connect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang";
		String pwd = "madang";	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,userid,pwd);
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CustomList() {
		custom = new Custom[5];
		for ( int i=0 ; i<custom.length ; i++ ) {
			custom[i] = new Custom();
		}
			
	}
	
	public void selectManagerList() {
		String query = "SELECT * FROM customer";
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("CUSTID \tNAME \tADDRESS \tPHONE");
			int index=0;
			while (rs.next()) 
			{
				custom[index].setCustid(rs.getInt(1));
				custom[index].setName(rs.getString(2));
				custom[index].setAddress(rs.getString(3));
				custom[index].setPhone(rs.getString(4));
				index++;
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
