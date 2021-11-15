package mmms.member.dao;

//9. Oracle DB로 필요한 SQL 구문을 전송하는 클래스 구현
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import mmms.member.db.JdbcUtil;
import mmms.member.vo.Member;

public class MemberDAO {
	// 연결관련 내용
	Connection con;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	// 1. 회원정보 등록
	public int insertNewMember(Member newMember) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "INSERT INTO mms_member VALUES(mms_member_id_seq.nextval,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());

			insertCount = pstmt.executeUpdate();// 업데이트를 해서 내용 올리기
//		    if(insertCount > 0) {
//				co.printAddSuccessMessage(newMember);
//			}else {
//				co.printAddFailMessage(newMember);
//			}
		} catch (SQLException e) {

		} finally {
			JdbcUtil.close(pstmt);
		}

		return insertCount;// 제대로 업데이트 됐는지는 다른데서 보기

	}

	// 2. 회원 목록 보기
	public ArrayList<Member> selectMemberList() {
//		PreparedStatement pstmt =null;
//		//ResultSet rs = null;
//		String sql = "select * from mms_member";
//		try {
//		pstmt = con.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		while(rs.next()) {
//			System.out.print("name: " +rs.getString(2));
//			System.out.print(",addr: " +rs.getString(3));
//			System.out.print(",nation: " +rs.getString(4));
//			System.out.print(",natemail: " +rs.getString(5));
//			System.out.println(",age: " +rs.getString(6));
//		}
//		}catch (SQLException e) {
//
//	}finally {
//		JdbcUtil.close(con);
//		try {
//			pstmt.cancel();
//		} catch (SQLException e) {
//			
//		}
//	}
		return null;
	}

	// 3. 특정 회원정보 정보 보기
	public Member selectOldMember(String name) {
		return null;

	}

	// 4. 회원 정보 수정(3활용)
	public int updateMember(Member updateMember) {
		return 0;

	}

	// 5. 회원 정보 삭제(3활용)
	public int deleteMember(String name) {
		return 0;

	}

}
