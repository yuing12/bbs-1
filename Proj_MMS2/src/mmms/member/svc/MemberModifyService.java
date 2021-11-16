package mmms.member.svc;

import java.sql.Connection;

import mmms.member.dao.MemberDAO;
import mmms.member.db.JdbcUtil;
import mmms.member.vo.Member;

//3. 정보 수정(잘올라갔는지를 확인해보는 곳)
public class MemberModifyService {
	//수정할 이름을 불러올떄 Member 정보 가져오기
	public Member getOldMember(String name) {
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		Member member = memberDAO.selectOldMember(name);
		JdbcUtil.close(con);
		//한사람의 정보를 돌려준다
		return member;

	}

	public boolean modifyMemeber(Member updateMember) {
		boolean isModifySuccess = false;
		// 데이터 베이스에 연결
		Connection con = JdbcUtil.getConnection();
		// 데이터 베이스 다우에 연결
		MemberDAO memberDAO = new MemberDAO(con);
		int updateCount = memberDAO.updateMember(updateMember);
		if (updateCount > 0) {
			JdbcUtil.commit(con);// 1이상이면 커밋해라
			isModifySuccess = true;
		} else {
			JdbcUtil.rollback(con);// 아니면 작업 전으로 다시 되돌려라
		}
		JdbcUtil.close(con);
		return isModifySuccess;

	}

}
