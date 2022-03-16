package Day11;
//day11_1 예제
public class Cat implements Soundable {
			//클래스명 구현 인터페이스명
	
	@Override
	public String sound() {
		return "야옹";
		
		//day11_1에 print가 있으므로 return만 함(프린트 사용 x)
	}
	
}
