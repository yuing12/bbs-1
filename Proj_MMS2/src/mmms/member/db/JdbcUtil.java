package mmms.member.db;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {

	
	
	
	
	//transaction 처리 메소드
	public static void commit(Connection con) {
		try {
			con.commit();//insert,update,delete
		} catch (SQLException e) {
		
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();//insert,update,delete
		} catch (SQLException e) {
			
		}
	}
}
