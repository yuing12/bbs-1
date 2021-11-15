package mmms.member.action;
//7-1 회원등록 요청 처리하는 Action 클래스 구현
import java.util.Scanner;

import mmms.member.svc.MemberAddService;
import mmms.member.util.ConsoleUtil;
import mmms.member.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//강제와 일관성을 유지
		ConsoleUtil cu = new ConsoleUtil();
		Member newMember = cu.getMember(sc);//회원등록 입력 완성 내용
		MemberAddService memberaddservice = new MemberAddService(); // Dao -> service
		boolean isAddSuccess = memberaddservice.addMember(newMember);// service가 잘됐으면 true
	    if(isAddSuccess) {//그걸 우리가 알수 있도록 출력값주기
	    	cu.printAddSuccessMessage(newMember);
	    }else {
	    	cu.printAddFailMessage(newMember);
	    }
	}

}
