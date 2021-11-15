package study08.login;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//실질적인 비지니스 로직이 구현되는 클래스
public class LoginSVC {
	Connection con;
	// Connection : 연결

	// 언제나 메모리에 있는 아이
	static {// 오라클로 가는 다리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
		}

	}

//인스턴드 메소드
	public void connect() {// 오라클 안에 있는 javalink 들어가는 주소
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";// 주소
		try {
//		getConnection : 연결                    주소, 아이디(데이터베이스 이름),암호
			con = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("Connection Success!");
			// Connection Success : 연결 성공
		} catch (SQLException e) {
			System.out.println("주소,id,pw가 다릅니다.");
		}

	}

//login(String id, String passwd) 실행하면 User클래스가 나옴
	// 인터턴스 메소드
	//파라미터& 로컬변수(여기 메소드 안에서만 사용)
	public User login(String id, String passwd) {
		connect();// 인스턴트 메소드끼리는 객체 생성 안해도 된다
		// 객체생성 user값을 User전달
		User user = null; // 주소값
		Statement stmt = null;// 메소드 안에서 선언된 건 초기화 필수
		try {

			stmt = con.createStatement();
			// 오라클에 들어가면 이 명령을 실행해라(커뤼 랭귀지(오라클 언어))
			//"" 자바 시작과 끝 //'' 오라클에서 쓰는것
			String sql = "SELECT * FROM member1 WHERE id = '" + id + "' AND " + "password = '" + passwd + "'";// 하나만 날라옴
			// 그리고 실행된 결과값
			ResultSet rs = stmt.executeQuery(sql);// 'aaa','aaa','홍길동',22,'서울시','a@a.com'
			// 오라클 결과값 뽑아낼려고 하는것
			if (rs.next()) {// 읽을 문장이 있느냐?(true면 계속 실행)
				// 문자열로 뽑아 내겠다
				 id = rs.getString(1);//날라오는 변수
			     passwd = rs.getString(2);//날라오는 변수
				String name = rs.getString(3);
				int age = rs.getInt("age");//문자열를 숫자로 바꿔주는 메소드
				String addr = rs.getString("addr");
				String email = rs.getString("email");

				user = new User(id, passwd, name, age, addr, email); // 주소값,날라오는 값 저장

			}

		
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				stmt.cancel();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;// 주소값

	}

}
