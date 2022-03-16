package test;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Controller {
	
	//학생 리스트
	
	public static ArrayList<student> studentlist = new ArrayList<>();
	
	//입력 메소드
	
	public static void write(int index, String 이름, int 국어, int 영어, int 수학) {
		//변수가 4개 이상이면 하나의 객체로 만든다.
		student student = new student(index, 이름, 국어, 영어, 수학);
		//리스트에 저장
		studentlist.add(student);
	//	save();
		//파일에 저장
	}// 입력 종료
	
	
	//삭제 메소드
	public static boolean delete(int index, String 이름) { //번호랑 이름을 받아온다.
		
		//현재 studentlist에 있는 겟.인덱스의 겟.이름을 가져와서 >비교<
		if (이름.equals( studentlist.get(index).get이름() ) ) {
			//동일하면 삭제
			studentlist.remove(index);			
		//	save(); //리스트에서 삭제 후 파일도 삭제 리스트를 업데이트
			
			return true;
			
		} else { return false;}
		//void는 return이 없다는 뜻이므로 처음엔 void를 사용해도 나중에 리턴이 들어오면 boolean으로 바꾼다.
		
	} //삭제 종료
	
		/////////////////////////////////
	
	
	//7. 게시물 저장 메소드
//	public static void save() { //만든다음 호출(save)
//		//리스트의 모든 게시물을 파일에 저장
//		try {
//			//1.파일 출력 클래스
//			FileOutputStream outputStream = new FileOutputStream("G:\java\게시물파일.text");
//			
//			
//				//2.파일에 작성할 내용 (한줄씩 = 게시물 1개씩 = 객체 1개씩 )
//				for(student student : studentdlist) { // ,=필드구분 \n객체구분
//					
//					String 작성내용 = student.getIndex(), + "," + student.get이름()+ ","+
//							student.get국어() + "," + student.get영어()+ ","+
//							student.get수학()+ ","+student.get총점()+ ","+
//							student.get평균()+student.get석차()+"\n";
//					
//					
//				//3.내용(문자열) -> 바이트열 변환(외부통신(스트림) : 통신단위 : 바이트)
//					//통신을 위한 스트림이지만 바이트밖에 못 쓰므로 변환해서 외부와 통신
//					
//				//4.내보내기(write)
//					outputStream.write(작성내용.getBytes());
//				} //for end
//			
//			} catch (Exception e) {
//			System.out.println("파일저장 실패(관리자 문의)");
//		}
//		
		
		
	} //save end
	
	
	
	
	//8. 게시물 불러오기 메소드 [프로그램 시작] 파일 -> 리스트
//	public static void load() {
//		//예외처리 무조건
//		try { FileInputStream inputStream = new FileInputStream("G:\\java\\게시물파일.text");
//			
//			//2. 바이트배열 선언
//			byte[] bytes = new byte[1000];
//			
//			//3. 모든 바이트 읽어와서 바이트에 저장
//			inputStream.read(bytes);
//	
//			//4. 바이트 -> 문자열 변환
//			String file = new String(bytes);
//			
//			//5. 문자열 자르기 [ 한줄씩 -> 1개 객체 ]
//			String[] boards = file.split("\n"); //문자열 자르기 한줄씩 \n
//			
//			
//			int i = 0; //인덱스용
//			
//				for(String temp : boards ) { //배열내 문자열을 하나씩 꺼내기
//					
//					if(i+1 == boards.length) break;
//				//6. 문자열 자르기 [ 객체 내에서 ,로 필드 구분. ]
//					String[] field = temp.split(",");
//				//7. 객체화
//					student student = new student(field[0],
//							field[1],field[2],field[3],field[4],field[5],
//							field[6],field[7],
//							null);
//					//문자를 숫자로 바꾼다
//					//조회수는 필드의 정수형이므로 정수형으로 형변환[Integer.parseInt(문자열)]
//								
//				//8. 리스트  담기
//					studentlist.add(student); 
//				i++; //인덱스 증가
//			}
//		
//		} catch(Exception e) {System.err.println(" 알림]] 파일로드  실패( 관리자에게문의 )"+e); }
//		
//	}	
		
	


