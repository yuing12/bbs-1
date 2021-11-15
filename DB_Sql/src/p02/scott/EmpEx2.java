package p02.scott;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//오라클 scott DB(데이터 베이스)에 있는 emp테이블을 자바에서 출력하기
//조건 : Scanner(스캐너) 입력을 받아서 empno = 7902 에 해당 레코드(tuple) 출력하기
public class EmpEx2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//	    1. Driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";// 주소

//	    2. 계정 연결
//		Connection: oracle(오라클) 로그인 기능
		Connection conn = DriverManager.getConnection(url, "scott", "oracle");
		Statement stmt = conn.createStatement();
//				Statement : 문장

//		3. Query
		Scanner sc = new Scanner(System.in);

		System.out.println("[empno를 입력해 주세요.]");
		System.out.print("empno : ");
		int empno = sc.nextInt();//7902
		//오라클안에서 실행하는 명령어
		String query = "select * from emp where empno =" + empno;

		ResultSet rs = stmt.executeQuery(query);
		//오라클에서 가져온 결과값을 저장하는 테이블정도로 생각

		if (rs.next()) {// 읽을 문장이 있느냐?(true면 계속 실행)
//			next함수는 ResultSet에 저장된 select문 실행결과를 행단위로 1행씩 넘겨서 만약에  
//			다음 행이 있으면 ture, 다음행이 없으면 false를 반환하는 함수
			// 문자열로 뽑아 내겠다
			empno = rs.getInt(1);
			String ename = rs.getString(2);
//			getString함수는 해당순서의 열에 있는 데이터를 string형으로 받아온다는 뜻
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hiredate = rs.getDate(5);
//				String 1980-12-17 00:00:00 로 출력됨 date 사용할 것
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
		stmt.close();
		conn.close();
		//열었으면 무조건 닫아주기

	}

}
