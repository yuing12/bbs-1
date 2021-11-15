package mmms.member.action;
//4. 각 요청을 제어하는 Action 클래스 객체들을 공통적으로 접근할 수 있는 인터페이스 정의
import java.util.Scanner;

public interface Action {
//	throws는 예외가 발생했을때 예외를 호출한 쪽에서 처리하도록 던져준다.
	//추상메소드 : 예외처리를 받겠다
	void execute(Scanner sc) throws Exception;
}
