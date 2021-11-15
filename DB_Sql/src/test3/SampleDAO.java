package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDAO {

	// DB내용을 찾아서 SampleDTO에 넣은 후 ArrayList
	public ArrayList<SampleDTO> findAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<SampleDTO> sampleDTOs = new ArrayList<SampleDTO>();
		// DTO를 저장하는 리스트
//	    1. Driver 연결
	     	Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
	    	String url = "jdbc:oracle:thin:@localhost:1521:orcl";// 주소
//	    2. 계정 연결
	    	Connection conn = DriverManager.getConnection(url, "javalink", "javalink");
	    	Statement stmt = conn.createStatement();
//		3 Query
		String query = "select * from book";

//		4. 실행과 리턴
		ResultSet rs = stmt.executeQuery(query);
		// 오라클 결과값 뽑아낼려고 하는것
		while (rs.next()) {// 읽을 문장이 있느냐?(true면 계속 실행)
			// 문자열로 뽑아 내겠다
			SampleDTO dto = new SampleDTO();

			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setPrice(rs.getInt(3));
            
			sampleDTOs.add(dto);
			
		}
		return sampleDTOs;
	}

}
