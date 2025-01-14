package mmms.member.svc;
//Service -> DAO 자료를 가지고 작성
import java.sql.Connection; 

import mmms.member.dao.MemberDAO;
import mmms.member.db.JdbcUtil;
import mmms.member.vo.Member;

public class MemberAddService {
	public boolean addMember(Member newMember) throws Exception{
		boolean isInsertSuccess = false;
		//데이터 베이스에 연결
		Connection con =  JdbcUtil.getConnection();
		//데이터 베이스 다우에 연결
		MemberDAO memberDAO = new MemberDAO(con);
//		만든 아이 = insertNewMember return 값이 insertCount 숫자다
		int insertCount =  memberDAO.insertNewMember(newMember);//오라클에 넣을 명령어들 불러오기
		if(insertCount > 0) {
			JdbcUtil.commit(con);//1이상이면 커밋해라
			isInsertSuccess = true;
		}else {
			JdbcUtil.rollback(con);//아니면 작업 전으로 다시 되돌려라
		}
		
		//commit();
		//rollback();
		return isInsertSuccess;// 돌려주기위한 값
		
	}

}
