package Day18;

import java.util.ArrayList;
import java.util.LinkedList;

public class day15_3 { //731
	
	public static void main(String[] args) {
		
		/* LinkedList 클래스
		 				ArrayList				LinkedList
		 			   		배열						링크
		 내부구조차이	인덱스 기준으로 메모리값 연결	서로 다른 메모리주소 연결
		 속도	
		 add[추가]			빠름						
		 add[중간 삽입]								빠름
		 검색					빠름
		 
		 */
		
		
		//1.어레이리스트 객체 선언 [ 제네릭 = String ]
		ArrayList<String> list1 = new ArrayList<>();
		
		//2.링크드리스트 객체 선언 [ 제네릭 = String ]
		LinkedList<String> list2 = new LinkedList<>();
		
		
		//3. 시간변수
		Long starttime; //시작시간
		Long endtime; //끝나는 시간
		
		
		//4.arraylist 객체에 만개 삽입 ->삽입하는데 걸리는 시간
		starttime = System.nanoTime(); //현재 시간 나노 단위로 호출
		
		for(int i = 0 ; i<10000 ; i++) {
			list1.add(0, i+""); //정수->문자열 변환
								//1. String.valueOf(정수) 넣으면 바뀜   2. 정수+""
								//문자열->정수 변환 : 1. Integer.parseInt(문자욜)
		}
			endtime = System.nanoTime(); //나노초 = 10억/1초
			System.out.println("어레이리스트가 10000개 삽입하는데 걸리는 시간 :"+(endtime - starttime)+"ns");
		
		//5. 링크드리스트 객체 10000개 삽입하는데 걸리는 시간
			
			starttime = System.nanoTime();
			for(int i = 0 ; i<10000 ; i++) {
				list2.add(0, i+"");
			} endtime = System.nanoTime();
			System.out.println("링크드 리스트에 만개 삽입하는데 걸리는시간 :"+(endtime - starttime)+"ns");
		
		
	}

}
