package Day10;
//parent
public class Child extends Parent {
			//extends 슈퍼클래스
	
	private String name;
	
	public Child() {
		this("홍길동");
		System.out.println("자식 빈 생성자 실행");
	}
	
	public Child(String name) {
		this.name = name;
		System.out.println("자식 1개 인수 생성자 실행");
	}

}
