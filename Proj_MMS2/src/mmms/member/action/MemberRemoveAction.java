package mmms.member.action;

//7-2. 회원정보 보기
import java.util.Scanner;

import mmms.member.svc.MemberRemoveService;
import mmms.member.util.ConsoleUtil;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
//		기존회원정보 불러오기
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("삭제할",sc);//회원등록 입력 완성 내용
		MemberRemoveService memberremoveservice = new MemberRemoveService(); // Dao -> service
		 
		boolean isRemoveSuccess = memberremoveservice.removeMember(name);
		 
		if(isRemoveSuccess) {
			cu.printRemoveSuccessMessage(name);
		}else {
		cu.printRemoveFailMessage(name);
	
		}
	}

}
