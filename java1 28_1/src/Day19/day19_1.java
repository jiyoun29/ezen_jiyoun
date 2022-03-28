package Day19;

import java.util.HashSet;
import java.util.Iterator;

public class day19_1 {
	public static void main(String[] args) {
		
		/* 컬렉션 프레임 워크
		 수집=저장/미리 만들어진 클래스
		 	배열의 단점을 보완하여 사용한다
		 		1. LIST 컬렉션
		 			* 인덱스(저장 순서)
		 			a. Arraylist 클래스  : 싱글 스레드 (순차적 추가/삭제는 더 빠름)
		 			b. Vector 클래스	   : 멀티 스레드(동기화 O)
		 			c. Linkedlist 클래스 : 중간 삽입/삭제 (빠름)
		 		2. SET 컬렉션
		 			* 인덱스 X (저장 순서가 없기 때문에 자동으로 객체가 중복 불가능) <개좋앙
		 			a. HashSet 클래스
		 				ㄱ. .add(객체명) : set 객체 내 객체(요소) 추가
		 				ㄴ. .size(객체명) : set 객체 내 요소 숫자
		 				ㄷ. .Iterator(객체명) : set 객체 순회 메소드
		 						Iterator<제네릭> 인터페이스명 : 순서없는 객체 순회 메소드
		 						Iterator<제네릭> iterator : set.iterator();
		 							1. iterator.hashsetnext() : 다음 객체 존재 여부 확인
		 							2. iterator.next() : 다음 요소 가져오기
		 						or
		 						for(임시객체명)
		 				ㄹ. .remove(객체명) : set 객체내 객체 삭제
		 				ㅁ. .clear() : set 객체 내 
		 		3. MAP 컬렉션
		 
		 
		 p.737
		 1. HashSet 클래스로 객체 선언
		 */
		
		HashSet<String> set = new HashSet<>();
			//1. Hashset : 컬렉션 프레임워크 클래스 (수집에 관련된 역할
			//2. <재네릭> : Set 클래스 안에 들어가는 자료형
			//3. set : 객체명(아무거나)
			//4. new : 객체 생성시 메모리 할당
			//5. HashSet<생략가능>()
		
		
		//2. set객체 내 객체 넣기 [set 객체명.add(객체명)]
		set.add("java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("java");
		
		System.out.println(set);
		//중복 없이 3개만 출력(객체 중복 불가능)
		
		
		//3.set객체 내 객체 수 [set객체명.size]
		System.out.println("set 안에 들어있는 객체 수 : " + set.size());
		
		
		//4.Iterator : 저장된 객체를 한번씩 가져오는 반복자 리턴 ( 순회 )
			//*set 컬렉션에서 사용되는 이유 : 인덱스가 없기 때문에 객체를 호출하는 방법(get)이 없다.
		Iterator<String> iterator = set.iterator();
			//set 객체 내 iterator라는 것으로 순회가 된다.
		
		while(iterator.hasNext()){ //hasNext: 다음 요소 존재 여부 확인(있으면 true 아니면 false)
			String element = iterator.next(); //.next : 다음 요소 가져오기
			System.out.println(element); //좌르륵 일렬로 출
		} //while end
		// for문 쓰면 iterator 안 써도 된다
		for(String element : set) {
			//for(임시 객체명 : 컬렉션/배열){} : 임시 객체명에 컬렉션/배열 내 요소들을 한번씩 가져오는 반복자
			System.out.println(element);
		}
		
		
		//5. 삭제. set.remove(객체명) : set 객체 내 해당 객체를 삭제
		set.remove("JDBC"); System.out.println(set);
		
		
		//6. 비우기. set.clear() : set 객체 내 모든 객체 비우기[삭제]
		set.clear();  System.out.println(set);
		
		
		
	}
}
