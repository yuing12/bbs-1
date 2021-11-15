package plsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureTest {
	
	Connection con;
	// Connection : 연결

	// 언제나 메모리에 있는 아이
	static {// 오라클로 가는 다리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//다리
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
	
	//저장프로시저 호출전 데이터 입력
		public void insert(){	
			connect();
			PreparedStatement pstmt =null;
			try {
				String sql = "insert into member3 values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "Alpha");
				pstmt.setString(2, "1234");
				pstmt.setString(3, "AI");
				pstmt.setInt(4, 20);
				pstmt.setString(5, "LA");
				pstmt.setString(6, "go@ai.com");
				int count = pstmt.executeUpdate();
				if(count > 0) {
					System.out.println("insert succedss!!!");//업데이트 성공
				}else {
					System.out.println("insert fail!!!");//업데이트 실패
				}
			} catch (SQLException e) {

			}finally {
				try {
					pstmt.cancel();
					con.close();
				} catch (SQLException e) {
					
				}
			}

		}
		
		//출력과 관련된 명령어
		public void select(){
			//메소드 안에서 선언된건 반드시 초기화 해야한다.
			connect();
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			String sql = "select * from member3";
			try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("아이디: " +rs.getString(1));
				System.out.print(",비밀번호: " +rs.getString(2));
				System.out.print(",나이: " +rs.getString(3));
				System.out.print(",주소: " +rs.getString(4));
				System.out.println(",이메일: " +rs.getString(5));
			}
			} catch (SQLException e) {
				
			}finally {
				try {
					pstmt.cancel();
					con.close();
				} catch (SQLException e) {
					
				}
			}

			
		}
		
	//저장프로시저 호출 후 데이터 입력
		public void insertMember(){
			connect();
			PreparedStatement pstmt =null;
			try {
				String sql = "insert into member3 values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "procedure");
				pstmt.setString(2, "1234");
				pstmt.setString(3, "홍길동");
				pstmt.setInt(4, 19);
				pstmt.setString(5, "강원도");
				pstmt.setString(6, "hong@abc.com");
				int count = pstmt.executeUpdate();
				if(count > 0) {
					System.out.println("insert succedss!!!");//업데이트 성공
				}else {
					System.out.println("insert fail!!!");//업데이트 실패
				}
			} catch (SQLException e) {

			}finally {
				try {
					pstmt.cancel();
					con.close();
				} catch (SQLException e) {
					
				}
			}



		}

	public static void main(String[] args) {
        ProcedureTest pt = new ProcedureTest();
        System.out.println("저장프로시저 호출 전 데이터");
        pt.insert();
        pt.select();
        System.out.println("저장프로시저 호출 후 데이터");
        pt.insertMember();
        pt.select();
	}

}
