package Day09;

public class Student extends People {
			//서브클래스 extends : 수퍼클래스
	
	//1. 필드
	public int studentNo; //스투던트 넘버. 학생 번호
	
	//2. 생성자
	public Student (String name, String ssn, int studentNo) {
		//앞전것을 선택해서 사용한다.
	

		// 부모 클래스 내 멤버 필드 초기화(값 넣기)

		//1. 필드 접근 super(name,ssn); < 접근
		
//		this.name = name;
//		this.ssn = ssn;
		super(name, ssn);
		
		//2. 생성자 접근 직접 가는건 this.nn 
		
		this.studentNo = studentNo;
		
		//둘 중 하나 사용
	}
	
	//3. 메소드

}
