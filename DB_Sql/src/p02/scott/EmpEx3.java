package p02.scott;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//오라클 scott DB(데이터 베이스)에 있는 emp테이블을 자바에서 출력하기
//조건 : Scanner(스캐너) 입력을 받아서 empno = 7902 에 해당 레코드(tuple) 출력하기
//Statement => PreparedStatement
public class EmpEx3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//	    1. Driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";// 주소

//	    2. 계정 연결
		Connection conn = DriverManager.getConnection(url, "scott", "oracle");

//		3. Query
		Scanner sc = new Scanner(System.in);
		System.out.print("empno 입력 : ");
		int empno = sc.nextInt();// 7902
		
		String query = "select * from emp where empno =?";// ? :파라미터 인덱스
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, empno);//? 값 집어넣음, 첫번째 물음표가 empno 값으로 들어간다는 소리
		
//		4. 실행과 리턴

		ResultSet rs = pstmt.executeQuery();//위에 써줘서 비워놓으면 됨

		if (rs.next()) {// 읽을 문장이 있느냐?(true면 계속 실행)
			// 문자열로 뽑아 내겠다
			empno = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hiredate = rs.getDate(5);
//				String 1980-12-17 00:00:00 로 출력됨
			int sal = rs.getInt(6);
			int comm = rs.getInt(7);
			int deptno = rs.getInt(8);

			System.out.println(empno + " : " + ename + " : " + job + " : " + mgr + " : " + hiredate + " : " + sal
					+ " : " + comm + " : " + deptno);
		} else {
			System.out.println("입력된 empno의 정보가 없습니다.");
		}
//		5. DB 종료
		sc.close();
		rs.close();
		pstmt.close();
		conn.close();

	}

}
