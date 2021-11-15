package plsql;

import java.sql.CallableStatement; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

//javalink
public class PlsqlProcedure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Oracle DB 연결
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//	    1. Driver 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");//다리
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
			
//		변수 선언
		int p1InValue = Integer.parseInt(args[0]);//2
		int p2InOutValue = Integer.parseInt(args[1]);//3
		int p3OutValue;
//	    2. 계정 연결
			Connection conn = DriverManager.getConnection(url, "javalink", "javalink");
			CallableStatement cs = conn.prepareCall("{call compute_power(?,?,?)}");
			cs.setInt(1, p1InValue);
			cs.setInt(2, p2InOutValue);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.INTEGER);
			
			cs.execute();
			
			p2InOutValue = cs.getInt(2);
			p3OutValue = cs.getInt(3);
			
			System.out.println(p1InValue+"^"+p2InOutValue+"="+p3OutValue);


	}

}
