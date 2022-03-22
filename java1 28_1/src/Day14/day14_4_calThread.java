package Day14;

public class day14_4_calThread extends Thread { 
	
	//상속 받은 다음 생성자 만들기
	
	public day14_4_calThread(String name) {
		//이름을 받아서 이름 변경
		setName(name); //인수를 받은 데이터로 스레드 이름 정
	}
	
	//멀티스레드 실행 [ 오버라이드 ]
	@Override
	public void run() {
		
		for(int i =0 ; i<200000000 ; i++) { //2억바퀴 돌기
			//스레드 실행간 차이를 확인하기 위해 2억
		}
		//돌고나서 스레드에 이름 확인
		System.out.println( "현재 실행 중인 스레드 명 : " + getName());
		
		
	}
	

}
