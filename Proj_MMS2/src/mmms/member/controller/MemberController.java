package mmms.member.controller;

import java.util.Scanner; 

import mmms.member.action.Action;

//6. 사용자의 전체 요청을 제어하는 클래스 구현
public class MemberController {
	//인터페이스를 구현한 클래스 : 2개가 있다. 그 두개가 사용하는 클래스
	public void processRequest(Action action,Scanner sc){
		try{
		action.execute(sc);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}	

}
