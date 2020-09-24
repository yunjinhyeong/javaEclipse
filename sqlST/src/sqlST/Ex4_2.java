package sqlST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ex4_2 {

	//select 하는 명령어
	public List<Ex4_1> getActors() {
		//바구니 준비
		List<Ex4_1> list = new ArrayList<>();
				
		//db접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
				
		//변경값
		//세팅
		String sql ="";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			sql = "SELECT * FROM actor ORDER BY actor_id DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//get set 하기위해 연결
				Ex4_1 ex4_1 = new Ex4_1();
				ex4_1.setActorId(rs.getInt("actor_id"));
				ex4_1.setFirstName(rs.getString("first_name"));
				ex4_1.setLastName(rs.getString("last_name"));
				ex4_1.setLastUpdate(rs.getTimestamp("last_update"));
				
				list.add(ex4_1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	// 어떤 특정값 셀렉트
	public Ex4_1 getActorById(int actorId) {
		// 방 만들기
		Ex4_1 ex4_1 = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			sql = "SELECT * FROM actor WHERE actor_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, actorId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ex4_1 = new Ex4_1();
				ex4_1.setActorId(rs.getInt("actor_id"));
				ex4_1.setFirstName(rs.getString("first_name"));
				ex4_1.setLastName(rs.getString("last_name"));
				ex4_1.setLastUpdate(rs.getTimestamp("last_update"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ex4_1;
		
	}
	
	public static void main(String[] args) {
		Ex4_2 ex4_2 = new Ex4_2();
		List<Ex4_1> list = ex4_2.getActors();
		for(Ex4_1 name : list) {
			System.out.println(name.toString());
		}
		System.out.println("요소의 개수: "+ list.size());
		System.out.println("=======================");
		
		Ex4_1 ex4_1 = ex4_2.getActorById(203);
		System.out.println("actor ex4_1: "+ ex4_1);
		Ex4_1 ex4_11 = ex4_2.getActorById(204);
		System.out.println("actor ex4_11: "+ ex4_11);
	}

}
