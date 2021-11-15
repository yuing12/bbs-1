package study08.login;

import java.util.Scanner;

//콘솔에서 아이디와 비밀번호를 입력받고 해당 아이디와 비밀번호로 인증하는 메소드를 호출하는 클래스
public class LoginMain {

	public static void main(String[] args) {
		boolean isStop = false;// 거짓
		LoginSVC loginSVC = new LoginSVC();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("로그인 화면입니다.");
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.print("아이디 : ");
			// 키보드 입력값 받는 아이
			String id = sc.next();
			System.out.print("비밀번호 : ");
			// 키보드 입력값 받는 아이
			String passwd = sc.next();
			User user = loginSVC.login(id, passwd);// 위에서 입력한 값을 저장
			// user : 'aaa','aaa','홍길동',22,'서울시','a@a.com'
			if (user == null) {// 아이디 비밀번호 비교하는 if값
				System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("로그인한 사용자 정보");
				System.out.println(user);// 주소값
				// break, true
				isStop = true;// 여기가끝이기에 while을 false 값 만들어서 스탑해주기
			}

		} while (!isStop);// false값이여서 한번 실행밖에 안됨 그렇기에 부정하기
		sc.close();
	}

}

//로그인 화면입니다.
//아이디와 비밀번호를 입력하세요.
//아이디 : hong
//비밀번호 : 1234
//Connection Success!
//아이디나 비밀번호가 일치하지 않습니다.
//로그인 화면입니다.
//아이디와 비밀번호를 입력하세요.
//아이디 : aaa
//비밀번호 : aaa
//Connection Success!
//로그인한 사용자 정보
//아이디 = aaa, 비밀번호 = aaa, 이름 = 홍길동, 나이 = 22, 성별 = 남, 이메일 = a@a.com