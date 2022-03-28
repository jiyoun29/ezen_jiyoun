package Day18;

import java.util.ArrayList;

public class day18_1 {
	/*722 컬렉션 프레임워크
	 여러개 객체를 추가,검색,삭제 -> 배열
	 	배열문제점
	 		1. 불특정 다수의 객체를 저장 불가[ 길이를 크게 설정 -> 비 효율적 ]
	 		2. 삭제했을때 듬성듬성 빠진 옥수수[ 삭제시 인덱스가 비는 현상 ]
	 	객체들을 효율적으로 추가, 삭제, 검색 -> 컬렉션 프레임 워크
	 	컬렉션 : 수집
	 	프레임워크 : 사용방법을 미리 정해놓은 라이브러리
	 		*저장(수집) 관련 클래스 / 인터페이스
	 	
	 	(@만들어져있는걸 쓰는것이므로 사용방법만 알아두기)
	 1. List 인터페이스
	 	Arraylist 클래스, Vector 클래스, LinkedList 클래스
	 2. Set 인터페이스
	 	HashSet 클래스, TreeSet 클래스
	 3. Map 인터페이스
	 	HashMap 클래스, Hashtable 클래스, TreeMap 클래스, Properties 클래스
	 	
	 p.728 : ArrayList 클래스
	 		배열과 유사하지만 길이가 다름
	 		
	 다양한 메소드 제공
	 	1. 리스트객체명.add(객체명) : 해당 객체를 리스트 객체 내 추가[ 비어있는 마지막 인덱스 ]
	 		리스트객체명.add(인덱스, 객체명) : 해당 인덱스에 객체를 리스트객체내 삽입[기존 인덱스는 인덱스가 증가]
	 	2. 리스트객체명.get(인덱스) : 리스트 객체 내 해당 인덱스 객체 호출
	 	3. 리스트객체명.remove(인덱스): 리스트 객체 내 해당 인덱스 객체 삭제[삭제된 인덱스 뒤로 인덱스-1]
	 		리스트객체명.remove(객체명): 리스트 객체 내 해당 객체 삭제 
	 	4. 리스트객체명.clear() : 리스트 객체 내 모든 객체 삭제
	 	5. 리스트객체명.size() : 리스트 객체 내 객체 수[길이]
	 	6. 리스트객체명.isEmpty() : 리스트 객체가 비어있는지 확인
	 		리스트 객체 내 객체가 1개라도 없으면 true / 있으면 false
	 	7.리스트객체명.contains(객체명): 리스트객체 내 해당 객체 존재 여부 확인[true / false]
	 	8.리스트객체명.indexOf(객체명): 리스트객체 내 인덱스번호
	 */
	
public static void main(String[] args) {
	
	
	//1.리스트 클래스 선언 [ 리스트 안에 저장할 항목의 자료형 -> 제네릭 ]
	ArrayList<String> list = new ArrayList<>();
		//1. ArrayList 리스트 클래스
			// <제네릭> : 클래스 내부[리스트 내부]에 들어가는 자료형 (@어제 만든 코스와 비슷)
				// list : 리스트 객체명(아무거나)
					// new ArrayList<제네릭=생략가능?(길이=생략가능=10);
	
	
	//2. 리스트 객체 내 요소 추가
	list.add("JAVA"); //어레이리스트에 추가
		//객체명 = 제네릭 파일 대체
	list.add("JDBC");
	list.add("Servlet/JSp");
		//리스트 내 요소 중간 확인
	System.out.println(list);
	
	list.add(2,"Database");//선택 인덱스에 추가
	list.add("iBATIS");
	
	System.out.println(list);
	
	
	//3. 리스트 객체 내 요소들의 수(길이)
	System.out.println("리스트 내 길이 확인 "+list.size());
	//add 5번 해서 5가 나옴
	
	
	//4.리스트 객체명.get(인덱스) : 리스트 객체 내 특정 인덱스의 요소 호출
	System.out.println("리스트 내 2번 인덱스 호출 "+list.get(2));
	
	
	//5.반복문 활용 [ 리스트와 반복문 같이 사용 ]
		// 인덱스가 필요할 때 사용
	// i == 인덱스
	for(int i = 0 ; i<list.size(); i++) { //i는 0부터 리스트 객체 내 총길이까지 1씩 증가 반복
		String str = list.get(i); //i번째 인덱스 내 요소를 호출해서 저장
		System.out.println(i+":"+str); //출력
	}
		// 인덱스 없이 요소들 하나씩 사용할 때
	//반복문 활용
	for(String str : list) {
		System.out.println(":"+str);
	}
	
	
	//6.리스트 객체명.remove(인덱스)
	list.remove(2); //2번 인덱스 삭제
	System.out.println("삭제확인"+ list);
	
	
	
	
	
}
}
