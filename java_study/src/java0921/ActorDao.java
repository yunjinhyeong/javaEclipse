package java0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// select, insert, update, delete sql문 수행 가능
// DAO(Data Access Object) : 데이터를 조회, 추가, 수정, 삭제 가능한 객체
public class ActorDao {
	// Connection 부분이 중복되니 뽑아쓰기위해 하나 만들어옴 + DB 접속정보도 가져옴
	public Connection getConnection() throws Exception { // 1단계~2단계 예외처리 안하면 빨간줄뜨기에 throws로 호출한 놈한테 넘김
		// DB 접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		Connection con = null;

		// 1단계. DB드라이버 클래스 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2단계. DB에 연결 시도. 연결 후 Connection객체를 리턴함.
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);

		return con;
	}

	// db 라인 한줄 하나하나가 ActorVo이다
	public List<ActorVo> getActors() {
		List<ActorVo> list = new ArrayList<>(); // 바구니준비 select로 여러개 불러오기위해서

		// SELECT문 실행에 필요한 JDBC 객체 3가지
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select문에만 존재

		String sql = "";

		try {
			// getConnection함수 실행해서 con 가져오기
			con = getConnection();
			// 3단계. sql문장객체 준비
			sql = "SELECT * FROM actor ORDER BY actor_id DESC";
			pstmt = con.prepareStatement(sql);
			// 실행 후 SELECT 결과를 ResultSet으로 받음
			rs = pstmt.executeQuery(); // SELECT문 수행시 executeQuery() 호출

			// 4단계. ResultSet 데이터 꺼내서 사용 //next: 행을 옮김
			while (rs.next()) {
				ActorVo actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));

				list.add(actorVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}// getActors()

	public ActorVo getActorById(int actorId) {
		ActorVo actorVo = null; // 어떤 특정값만 가져오니깐 위랑 다름

		// SELECT문 실행에 필요한 JDBC 객체 3가지
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select문에만 존재

		String sql = "";

		try {
			// getConnection함수 실행해서 con 가져오기
			con = getConnection();
			// 3단계. sql문장객체 준비
			sql = "SELECT * FROM actor WHERE actor_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, actorId);
			// 실행 후 SELECT 결과를 ResultSet으로 받음
			rs = pstmt.executeQuery(); // SELECT문 수행시 executeQuery() 호출

			// 4단계. ResultSet 데이터 꺼내서 사용 //next: 행을 옮김
			if (rs.next()) {
				actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return actorVo;
	}// getActors()
	
	public ActorVo getActorByFirstName(String firstName) {
		ActorVo actorVo = null; // 어떤 특정값만 가져오니깐 위랑 다름

		// SELECT문 실행에 필요한 JDBC 객체 3가지
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select문에만 존재

		String sql = "";

		try {
			// getConnection함수 실행해서 con 가져오기
			con = getConnection();
			// 3단계. sql문장객체 준비
			sql = "SELECT * FROM actor WHERE first_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			// 실행 후 SELECT 결과를 ResultSet으로 받음
			rs = pstmt.executeQuery(); // SELECT문 수행시 executeQuery() 호출

			// 4단계. ResultSet 데이터 꺼내서 사용 //next: 행을 옮김
			if (rs.next()) {
				actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return actorVo;
	}// getActors()
	
	
	// insert문
	public int addActor(ActorVo actorVo) {// insert문
		
		int count = 0;
		
		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			// sql문 준비
			sql = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, now())";
			// 3단계. sql문장객체 준비
			pstmt = con.prepareStatement(sql);
			// 값 설정
			pstmt.setString(1, actorVo.getFirstName());
			pstmt.setString(2, actorVo.getLastName());
			
			// sql문장 실행
			count = pstmt.executeUpdate(); // INSERT, UPADATE, DELETE 문장 실행시 호출
			System.out.println(count + "개 행 추가 됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return count;
	}
	
	public int deleteActorByFirstName(String firstName) {
		int count = 0;
		// DELETE문 수행하기
		
		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			// sql문 준비
			sql  = "DELETE FROM actor ";
			sql += "WHERE first_name = ? ";
			
			// 3단계. sql문장객체 준비
			pstmt = con.prepareStatement(sql);
			// 값 설정
			pstmt.setString(1, firstName);
			
			// sql문장 실행
			count = pstmt.executeUpdate(); // INSERT,UPDATE,DELETE문장 실행시 호출
			
			System.out.println(count + "개 행이 삭제됨.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	} // deleteActorByFirstName()
	

	public static void main(String[] args) {
		ActorDao actorDao = new ActorDao();
		List<ActorVo> list = actorDao.getActors();
		for (ActorVo actorVo : list) {
			System.out.println(actorVo.toString());
		}
		System.out.println("요소의 개수: " + list.size());
		System.out.println("==================");
		
		//샘플데이터 2개준비
		ActorVo actorVo3 = new ActorVo();
		actorVo3.setFirstName("길동");
		actorVo3.setLastName("홍");
		
		ActorVo actorVo4 = new ActorVo("사임당", "신");
		
		// insert테스트
		actorDao.addActor(actorVo3);
		actorDao.addActor(actorVo4);

		ActorVo actorVoDb1 = actorDao.getActorByFirstName(actorVo3.getFirstName());
		ActorVo actorVoDb2 = actorDao.getActorByFirstName(actorVo4.getFirstName());
		
		System.out.println("======== insert 결과 확인 ==========");
		System.out.println(actorVoDb1.toString());
		System.out.println(actorVoDb2);
		
		
		System.out.println("======== delete 테스트 ==========");
		actorDao.deleteActorByFirstName(actorVo3.getFirstName());
		actorDao.deleteActorByFirstName(actorVo4.getFirstName());
		// 하나만 선택한 셀렉트 실행
//		ActorVo actorVo1 = actorDao.getActorById(203);
//		System.out.println("actorVo1: " + actorVo1);
//
//		ActorVo actorVo2 = actorDao.getActorById(204);
//		System.out.println("actorVo2: " + actorVo2);
//
//		if (actorVo2 == null) {
//
//		} else {
//
//		}
	}
}
