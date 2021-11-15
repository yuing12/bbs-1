// 한명의 회원 정보 입력 클래스

package mmms.member.vo;

public class Member {
//	직접적으로 변수를 건들지 않고, 생성자나 메소드를 통해서 건들도록 해라
	private int id;
	private String name;
	private String addr;
	private String nation;
	private String email;
	private int age;
	
//	(1) 생성자
//	id 빠진 이유 : 시퀸스를 사용하기 자동으로 순서대로 숫자가 들어가기에 필요가 없다.
	public Member(String name, String addr, String nation, String email, int age) {
	super();
	this.name = name;
	this.addr = addr;
	this.nation = nation;
	this.email = email;
	this.age = age;
}
	
	
	
// (2) 메소드

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
   // 출력
	public String getName() {
		return name;
	}

	//내용 저장
	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//출력을 위한 재정의
	@Override
		public String toString() {
		String result = "name: " +name +",addr: " + addr+",nation: " +nation +",email: " +email +",age: " +age;
			return result;
		}

}
