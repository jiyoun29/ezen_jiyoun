package Day19;

import java.util.TreeSet;

public class day19_5 {
	public static void main(String[] args) {
		
		//753 treeset 클래스
			//하나의 객체를 노드라고 한다
			//각 노드는 2개의 자식 노드를 가질 수 있다
			//부모보다 작으면 왼쪽 자식 / 부모보다 크면 오른쪽 자식
			//Tree구조에서 가장 왼쪽에 있는게 가장 작은 값
			//Tree구조에서 가장 오른쪽에 있는 값이 가장 큰 값
		
		//필기
		
		
		//1. TreeSet 클래스의 객체 선언
		TreeSet<Integer> scores = new TreeSet<>();

		System.out.println("==========");

		//2. TreeSet 객체에 객체(요소) 추가
		scores.add(87); System.out.println("확인 :" + scores);
		scores.add(98); System.out.println("확인 :" + scores);
		scores.add(75); System.out.println("확인 :" + scores);
		scores.add(95); System.out.println("확인 :" + scores);
		scores.add(80); System.out.println("확인 :" + scores);
		// 자동정렬  @확인 :[75, 80, 87, 95, 98]

		System.out.println("==========");

		//3. 가장 왼쪽 노드부터 
		System.out.println(scores.first()); //75 가장 왼쪽 노드 호출
		System.out.println(scores.last()); // 98 가장 오른쪽 노드 호출
		System.out.println(scores.lower(95)); //87 95기준으로 왼쪽 노드 호출 [95보다 작은
		System.out.println(scores.higher(95)); //98 95기준으로 오른쪽 노드 호출 [95보다 큰
		System.out.println(scores.floor(95)); // 95포함 기준으로 왼쪽 노드 [95보다 같거나 큰
		System.out.println(scores.ceiling(85)); // 85포함 기준으로 오른쪽 노드 [85보다 같거나 큰

		System.out.println("==========");
		
		//4.
		System.out.println(scores.pollFirst()); //가장 왼쪽부터 노드 삭제
		System.out.println(scores.pollLast()); //가장 오른쪽부터 노드 삭제
		
		System.out.println("==========");

		System.out.println("확인 : "+scores);
		
		System.out.println("==========");
		
		//5. 오름차순 vs 내림차순
		System.out.println("기본 오름차순 : "+scores);
		//내림차순 descendingSet
		System.out.println("기본 내림차순 : "+scores.descendingSet());
		
		System.out.println("==========");
		
		//오름차순 하나씩 출력
		for(Integer temp : scores) {System.out.println(temp);}
			//@temp를 스코어에서 하나씩 빼온다
		//내림차순 하나씩 출력
		for(Integer temp : scores.descendingSet()) {System.out.println(temp);}
		
		
		
		
	///////////////////	
	}
}
