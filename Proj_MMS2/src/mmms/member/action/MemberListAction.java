package mmms.member.action;
import java.util.ArrayList;
//7-2. 회원정보 보기
import java.util.Scanner;

import mmms.member.svc.MemberListService;
import mmms.member.util.ConsoleUtil;
import mmms.member.vo.Member;

public class MemberListAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//서비스 -> 
		ConsoleUtil cu = new ConsoleUtil();
		MemberListService memberListService = new MemberListService();
		ArrayList<Member> memberList = memberListService.getMemberList();
		cu.printMemberList(memberList);//select all 출력
		
		

	}

}
