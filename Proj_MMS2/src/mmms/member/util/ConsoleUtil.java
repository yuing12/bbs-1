package mmms.member.util;
// 5. 사용자로부터의 입력을 콘솔에서 읽어 들이거나 콘솔로 메시지를 출력하는 역할을 하는 클래스
import java.util.Scanner;  

import mmms.member.vo.Member;

//키보드 입력
public class ConsoleUtil {

	//스캐너 입력값 받을 내용
	public Member getMember(Scanner sc) {
		System.out.println("등록할 회원 정보를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("주소 :");
		String Addr = sc.next();
		
		System.out.print("국가 : ");
		String nation = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
			
		
		//리턴해서 한명의 정보를 보내주기
		return new Member(name, Addr, nation, email, age);
	}
	
	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 성공");
	}
	
	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 실패");
	}
	
//	public void printMemberList(ArrayList<Member> memberList) {
//		//size() : 컬렉션에 저장되어 있는 요소의 개수를 리턴하는 메소드
//
//
//	}
}
