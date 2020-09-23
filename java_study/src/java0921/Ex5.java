package java0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex5 {

	public static void main(String[] args) {
		// DELETE문
		
		// DB 접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		// 삭제할 내용
		int actorId = 202; // 변경 기준 (where 조건)
		

		String sql = ""; //sql에 적을 명령문 들어갈 틀
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1단계. DB드라이버 클래스 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2단계. DB에 연결 시도. 연결 후 Connection객체를 리턴함.
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd); //드라이버매니저로 컨낵션한다

			// sql문 준비
			sql = "DELETE FROM actor ";
			sql += "WHERE actor_id = ? ";

			// 3단계. sql문장객체 준비
			pstmt = con.prepareStatement(sql);
			// 값 설정
			pstmt.setInt(1, actorId);

			// sql문장 실행
			int count = pstmt.executeUpdate(); // INSERT, UPADATE, DELETE 문장 실행시 호출
			System.out.println(count + "개 행 추가 됨");

		} catch (Exception e) {
			e.printStackTrace();
		}
	} //

}
