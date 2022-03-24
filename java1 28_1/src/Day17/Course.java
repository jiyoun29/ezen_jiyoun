package Day17;

public class Course <T> {
		//제네릭<이름>
	//외부로부터 들어오는 자료형
	
	private String name; //코스이름/과정명 : 문자열 변수*
	private T[] students; //학생배열 : 아직 무슨열인지 모름
	//외부에서 제네릭으로 들어올 것이므로 무슨 자료형인지 모름(매개 취급)
	
	
	//2. 생성자[외부로부터 과정명과 인원수를 받아서 인원수만큼 제네릭 타입으로 배열내 메모리 할당]
	public Course(String name, int capacity) {
					//과정명			인원수
		this.name = name;
		students = (T[]) new Object[capacity];
					// 매개타입으로 new (메모리할당) 안됨
				//1. new Object[인원수] : 인원수 만큼 Object 배열 선언
				//2. Object 배열 -> T[]배열로 강제형변환
				//Object 클래스는 최상위[부모] 이기 때문에 가능
	}
	
	//메소드 : 과정명 호출 메소드
	public String getName() { return name; }
	
		// 학생 배열 호출 메소드
	public T[] getStudents() { return students; }
	
		//학생 배열에 객체 추가하기 [어래이리스트와 비슷]
	public void add(T t) {
		for(int i = 0; i<students.length; i++) {
			if ( students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
	
	

	
	//와일드카드 : ? 모든클래스대응
	//코스옆에 ?를 넣으면 모든 제네릭 가능
	//코스 ?  상속 클ㄹ스명 <-해당 클래스로부터 상속받은(자식) 제ㅔㄴ릭만 사용 가능
	//코스 ? super 클래스명 <-해당 클래스로부터 상속을 준 (부모) 제네릭 클래스 가능

		public static void 코스등록(코스<?> 코스명단) {
			System.out.println(코스명단.getName()+"수강생명단");
		}
	
	
	
	//2
	public static void 학생코드명단출력(코스)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
