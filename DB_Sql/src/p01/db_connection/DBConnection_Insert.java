package p01.db_connection;
//데이타 추가
//CRUD:Create Read Update Delete

//executeQuery(String sql) : select문 사용시
//executeUpdate(String sql) : insert,update, delete문 사용시

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection_Insert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
			
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
//		getConnection : 연결                    주소, 아이디(데이터베이스 이름),암호
			conn = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = conn.createStatement();
			
			
			//오라클에 들어가면 이 명령을 실행해라(커뤼 랭귀지(오라클 언어)) // 기존하고 달라야한다
			//명령을 던지면 오라클에선 자동으로 커밋(완전저장)한다.
			String query = "insert into goodsinfo values('33333', 'OLED TV2',735000, 'LG2')";
			
			int count = stmt.executeUpdate(query);
			if(count >0) {
				System.out.println("데이터가 저장되었습니다");
			} else
				System.out.println("데이터가 저장되지 않았습니다.");
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("정상종료");
		try {
			conn.close();
		} catch (SQLException e) {
			
		}
	}

}
