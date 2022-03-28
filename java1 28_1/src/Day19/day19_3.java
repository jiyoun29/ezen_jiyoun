package Day19;

import java.util.HashMap;

public class day19_3 {
	public static void main(String[] args) {
		
		/* Map 컬렉션 = json
		 	키(객체), 값(객체) = 섞은것을 '엔트리' (둘은 한쌍)
		 	map에 객체 2개가 들어감
		 	키 : set 컬렉션 사용(중복 불가능)
		 	값 : list 컬렉션 사용(중복 가능)
		 	hashmap 클래스
		 		1. map 객체명.put(키 객체, 값 객체) : 하나의 엔트리(키, 값) 추가
		 		2. map 객체명.size() : 엔트리 개수
		 		3. map 객체명.get( 키 객체 ) : 해당 키의 값을 호출한다
		 		4. map 객체명.keyset() : map객체 내 모든 키 호출 가능
		 		5. map 객체명.values() : map 객체 내 모든 값 호출 가능
		 			키(중복x)를 알고 있으면 값을 알 수 있다.
		 			for(임시 객체 명 : map 객체명.keyset() ) :
		 				@key 값을 반복문 돌려서 get. key는 식별용이라 중복 불가능
		 		6. map 객체명.remove() : map 객체 내 키의 엔트리 삭제
		 		7. map 객체명.clear() : map 객체 내 모든 엔트리 삭제
		 		
		 		
		 	* List 컬렉션 : 순서(인덱스) 저장 = 배열 유사
		 	* Set 컬렉션 : 순서 없이 저장, 중복 불가능
		 	* Map 컬렉션 : 키set와 값list으로 이루어진 엔트리 저장(순서 x)
		 		
		 	
		 	1. HashMap 클래스의 객체 선언
		 */
		HashMap<String, Integer> map = new HashMap<>();
	//Hashmap : 컬렉션 프레임 워크 map 클래스
			//<제네릭, 제네릭> : key, valu로 구성된 제네릭
			//map : map 객체명( 아무거나 )
				//new : 객체 생성시 메모리 할당
				//hashmap<>() : 생성자
		
		//2. map 객체에 추가
		map.put("신용권", 85); System.out.println("확인 : "+map);
			//리스트 = [객체, 객체, 객체]
			//셋트 = [객체, 객체, 객체]
			//맵 = { 키 = 값 }
		map.put("홍길동", 90); System.out.println("확인 : "+map);
		map.put("홍길동", 80); System.out.println("확인 : "+map);

			//key는 중복 불가능
		map.put("홍길동", 95); System.out.println("확인 : "+map);
			//중복값으로 덮어씌워진다

			//valu는 중복 가능
		map.put("유재석", 95); System.out.println("확인 : "+map);
			//이건 된다

		
		System.out.println("==========");

		
		//3. map객체명.size() : 엔트리 수 (3이 나온더ㅏ,)
		System.out.println("map 객체 내 엔트리 수 :"+map.size());

		//4. map객체명.get() : map 객체 키 -> 값 호출 (95가 나온다.)
		System.out.println("map 객체 내 호출 : "+map.get("유재석"));
	

		
		System.out.println("==========");

		
		
		//5. 모든 key 호출
		System.out.println("map 객체 내 키 호출"+map.keySet());
		
		//6. 모든 value 호출
		System.out.println("map 객체 내 값 호출"+map.values());

		
		System.out.println("==========");
		

		//7. 반복문 [key 반복문 이용해서 모든 value 호출 가능]
		for(String temp : map.keySet() ) {
			System.out.println(temp + " : "+map.get(temp));
		}
		
		
		System.out.println("==========");
		
		//8. 삭제
		map.remove("홍길동"); System.out.println("확인 : "+map);
		
		//9. 모두 삭제
		map.clear(); System.out.println("확인 : "+map);
		
		
	}
}
