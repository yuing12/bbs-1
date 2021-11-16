package mmms.member.svc;
//2. 목록불러오기
import java.sql.Connection;
import java.util.ArrayList;

import mmms.member.dao.MemberDAO;
import mmms.member.db.JdbcUtil;
import mmms.member.vo.Member;

public class MemberListService {
	
	public ArrayList<Member> getMemberList() {
		//데이터 베이스에 연결
		Connection con =  JdbcUtil.getConnection();
		//데이터 베이스 다우에 연결
		MemberDAO memberDAO = new MemberDAO(con);
		ArrayList<Member> memberList = memberDAO.selectMemberList();
		
		JdbcUtil.close(con);
		return memberList;//주소값
		
	}

}
