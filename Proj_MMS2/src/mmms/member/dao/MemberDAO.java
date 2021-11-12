package mmms.member.dao;

import java.sql.Connection;

import mmms.member.vo.Member;

public class MemberDAO {
	Connection con;
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	public int insertNewMember(Member newMember) {
		
		String sql = "insert~~~~";
		
		return 0;


	}

}
