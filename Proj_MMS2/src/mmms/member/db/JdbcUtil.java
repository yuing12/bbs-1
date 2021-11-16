// DB 연동에 관련한 공통적인 기능 클래스 정의되는 패키지

package mmms.member.db;

import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
// static : 언제나 메모리에 올라가 있는 아이
//	오라클에 들어가는 다리
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Connection : 연결
    // static 메소드 : 오라클 안에 있는 javalink 연결
	public static Connection getConnection(){
		//디비 작업에 필요한 Connection 객체를 생성해 주는 메소드
		Connection con = null;
	//	String url = "jdbc:oracle:thin:@localhost:1521:orcl";// 주소
		try {
			  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javalink","javalink");//여기까지는 자동 commit
			
			con.setAutoCommit(false); //commit, roolback (여기서부턴 내가 정할 수 있다)
			// true: commit 실행
			// false: commit할 수 있는 시작점(Transaction 시작)
// false으로 하는 이유: 기본적으로 java에선 오토커밋(Autocommit)으로 commit이 자동으로 수행되기에
//			          잘못됐을 때 rollback을 하기 위해서 false으로 설정해 수행 후 자동으로 일어나는
//			          commit을 막기 위해서 false으로 설정했다.
//	setAutoCommit(트랜잭션) : 자동커밋 설정
//	여러 단계의 작업을 하나로 처리는 것으로 하나로 인식된 작업이 모두 성공적으로 끝나면 commit되고, 문제가
//	발생하면 rollback이 되어서 작업수정 전단계로 회수된다.
//	이걸 쓰면 프로그램의 신뢰도를 보장
//	예: 쇼필몰 물건을 구매할 때 장바구니 넣고 구매단계에서 물건 선택, 개인정보입력, 결제로 이루어 지는데
//	   하는 도중에 하나라도 잘못되면 장바구니로 이동되는 것을 말한다.
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		//커넥션이 나온다
//	 return???
//		아래있는 close 메소드에 전달 어떻게 전달을 하냐???가 관권
	}
	
	//Connection 연결해 실행 후 무조건 닫아줘야한다.
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			
		}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			
		}
	}
	
	

	//두개의 기본 배경 : Connection(연결)을 아직 안닫은 상태에서 실행한다
	//transaction 처리 메소드
	//저장
		public static void commit(Connection con) {
			try {
				con.commit();//insert,update,delete
			} catch (SQLException e) {
			
			}
		}
		
	//작업 수행 전으로 돌아가기
		public static void rollback(Connection con) {
			try {
				con.rollback();//insert,update,delete
			} catch (SQLException e) {
				
			}
		}
	

}
