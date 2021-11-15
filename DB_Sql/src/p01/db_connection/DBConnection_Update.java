package p01.db_connection;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//내용 업데이트
public class DBConnection_Update {

	public static void main(String[] args) {
		// update goodsinfo set maker='LG'where code='10002';
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
			// 연결

			conn = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = conn.createStatement();
			
			//업데이트
			String query = "update goodsinfo set maker='LG'where code='10002'";
			
			int count = stmt.executeUpdate(query);
			if(count >0) {
				System.out.println("업데이트가 되었습니다.");
			} else
				System.out.println("업데이트가 되지 않았습니다.");
			
		
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