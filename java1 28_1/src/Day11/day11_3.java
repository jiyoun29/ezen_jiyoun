package Day11;

public class day11_3 {
	public static void main(String[] args)  {

		//p.422 예외 던지기
			//목적 : 모든 메소드에서 try{}catch(){} 사용시 코드가 복잡하므로 한곳으로 예외 이동
		try { findcalss();} catch (Exception e) {}
		
		try {withdraw(30000);}
		catch(Exception e){System.out.println(e);}
		
	}
	
	//////////////////////
		
		
		public static void findcalss() throws Exception {

			//1.예외던지기
			Class clazz = Class.forName("java.lang.String2");
			//부른 사람에게 예외 던지기
			
			//2. try~catch
//			try { //예외가 발생할 것 같은 코드 혹은 일반예외
//				Class class = Class.forName("java.lang.String2");
//							//클래스 찾기 메소드
//			} catch (Exception e) { //예외가 발행하면 실행되는 코드
//				// exception : 예외 클래스 중 슈퍼클래스이므로 모든 예외를 저장 가능
//				System.out.println(e);
//			}
			
			
			
	//p.444~445 예외 만들기
			
		public static void withdraw(int money) throws Exception  {
			if(20000 < money ) {
				throw new Exception("잔고부족");
			}
			
		}
		//////////////////////////////////////////
	}

}
