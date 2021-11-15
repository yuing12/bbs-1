package p02.scott;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//오라클 scott DB(데이터 베이스)에 있는 emp테이블을 자바에서 출력하기
public class EmpEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Statement : 문장
//	    1. Driver 연결
				Class.forName("oracle.jdbc.driver.OracleDriver");//다리
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
		
//	    2. 계정 연결
				Connection conn = DriverManager.getConnection(url, "scott", "oracle");
				Statement stmt = conn.createStatement();
				
//		3 Query
			  //오라클에 들어가면 이 명령을 실행해라(커뤼 랭귀지(오라클 언어))
				String query = "select * from emp";
				
				
//		4. 실행과 리턴
				//그리고 실행된 결과값
				ResultSet rs = stmt.executeQuery(query);
				//오라클 결과값 뽑아낼려고 하는것
				while(rs.next()) {//읽을 문장이 있느냐?(true면 계속 실행)
					//문자열로 뽑아 내겠다
					int empno = rs.getInt(1);
					String ename  = rs.getString(2);
					String  job  = rs.getString(3);
					int mgr = rs.getInt(4);
					Date hiredate = rs.getDate(5);
//					String 1980-12-17 00:00:00 로 출력됨
					int sal = rs.getInt(6);
					int comm= rs.getInt(7);
					int deptno= rs.getInt(8);
					
					System.out.println(empno +" : "+ename+" : "+job+" : " +mgr+" : " 
					+hiredate+" : " +sal+" : " +comm+" : " +deptno);
				}
			    

//		5. DB 종료
				rs.close();
				stmt.close();
				conn.close();


	}

}
