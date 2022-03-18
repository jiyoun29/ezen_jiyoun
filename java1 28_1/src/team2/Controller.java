package team2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import team2.Car;

public class Controller {
	
	// 차량 리스트 
	public static ArrayList<Car> carlist = new ArrayList<>();
	// 모든 메소드는 static

	// 1. 입차 메소드
	public static void carin() {
	}

	// 2. 출차 메소드
	public static boolean carout() {
		
		// 입력받은 차량번호와 카리스트에 저장된 차량번호를 비교
		if( out.equals(carlist.get(carnum)) {
			if(carnum == out) { //만일 두가지가 일치하면
				//요금계산표 나타내고 출차 완료
				System.out.println("출차가 완료되었습니다.");
			}

		} else { System.out.println("입차하지 않은 차량입니다.");}
		/* 입력받은 차량번호와 해당 리스트의 차량번호가 동일하면
		 * carlist에서 입력받은 차량번호를 제외
		 * 		
		

//				carlist.remove(out); //  리스트.remove(인덱스) : 삭제
//			//	save(); // 파일내에서 삭제된 리스트 업데이트 
				return true; // 삭제가 성공했으면 
//			}else {
//				return false; // 삭제가 실패했으면 
//			}
		 */	

	}
	// 3. 요금계산 메소드
	public static void pay() {
		//출차 메소드와 연계
		
		

	}
	
	// 4. 차량리스트 저장메소드
	public static void save() {
		
	}
	// 5. 차량 리스트 불러오기메소드
	public static void load() { 
	
	}

}