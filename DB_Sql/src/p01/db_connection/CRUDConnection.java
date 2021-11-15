package p01.db_connection;
//오라클 데이터 출력
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDConnection {

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
			//오라클에 들어가면 이 명령을 실행해라(커뤼 랭귀지(오라클 언어))
			String query = "select * from goodsinfo";
			//그리고 실행된 결과값
			ResultSet rs = stmt.executeQuery(query);
			//오라클 결과값 뽑아낼려고 하는것
			while(rs.next()) {//읽을 문장이 있느냐?(true면 계속 실행)
				//문자열로 뽑아 내겠다
				String code = rs.getString(1);
				String name = rs.getString("name");
				String price = rs.getString(3);
				String maker = rs.getString("maker");
				
				System.out.println(code +" : "+name+" : "+price+" : " +maker);
				
		
			}
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
//**주의**오라클에서 커밋을 하지 않으면 자바로 자료가 안넘어 온다.
//나오는 값
//10001 : 디지털 TV : 35000 : LG
//10002 : LCD TV : 135000 : 삼성
//10003 : LED TV : 235000 : LG
//10004 : UHD TV : 335000 : 삼성
//10005 : OLED TV : 435000 : LG
//정상종료
