package plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallInoutProc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// DB 접속
//	    1. Driver 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");//다리
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
		
		// 변수 선언
	      String p1value = "a";//in
	      String p2value = "b";//inOut
	      String p3value;//Out
	      
//		   2. 계정 연결
	  	Connection conn = DriverManager.getConnection(url, "javalink", "javalink");
			CallableStatement cs = conn.prepareCall("{call javatest(?,?,?)}");
	        cs.setString(1, p1value);
	        cs.setString(2, p2value);
	        cs.registerOutParameter(2, Types.VARCHAR);
	        cs.registerOutParameter(3, Types.VARCHAR);
	        
	        cs.execute();
	        
	        p2value=cs.getString(2);
	        p3value=cs.getString(3);
	      
	   // 수행결과 출력
	      System.out.println("p2 :" + p2value);
	      System.out.println("p3 :" + p3value);

	}

}
