<%@page import="java.time.LocalTime"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약국 api 지도</title>
</head>
<body>
<%@include file = "../header.jsp" %>
<div class="container">

	<!--  자바 열기 -->
	<% // 공공데이터포털 [웹에서 제공하는 json 페이지를 java로 변환 ]
		// 1. url 가져오기
			// () <-안에 있는거 : 생성자
		URL url = new URL( "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=300&serviceKey=M1taD3H44wJFt5HC8EdepmAn18%2FcVt2ty8dZ0Oe7%2BzScBUg5qh%2FVybZ6MjUoGqxA74iyCr%2BjkHQQqymwSzVvMA%3D%3D" );
			// 1.url 클래스 : java에서 http url 객체화
		// 2. JAVA 해당 URL 읽기 [바이트 스트림]
					//1. url 클래스 사용
					//2. BufferedReader : 외부(자바 외) 데이터 읽어올 때 사용되는 클래스
		BufferedReader bf = new BufferedReader(new InputStreamReader( url.openStream() , "UTF-8" ));
		// 3. 읽어오기
		String result = bf.readLine(); //스트림 내 존재하는 바이트 모두 읽어오기
		// 4. 읽어온 스트림을 json 변환
		JSONObject object = new JSONObject( result );
		// 5. JSON객체에서 특정 키에 해당하는 데ㅐ이터 가져오기
		JSONArray array =  (JSONArray) object.get("data") ;
		
//		System.out.print(array.toString());
	%>
	
	<form action="안산시약국.jsp"> <!-- 검색. 주소로 검색하기 -->
		<input type="text" name="keyword" placeholder="주소">
		<input type="submit" value="검색"> <!-- 동일한 페이지로 이동하도록 -->
		
	</form>
	
	<!-- 카카오 지도 표시 div -->
	<div id="map" style="width:100%;height:350px;"></div>
	
	<table class="table table-hover">
		<tr>
			<th>약국명</th>
			<th>대표 전화</th>
			<th>주소</th>
			<th>월요일 운영</th>
			<th>화요일 운영</th>
			<th>수요일 운영</th>
			<th>목요일 운영</th>
			<th>금요일 운영</th>
			<th>토요일 운영</th>
			<th>일요일 운영</th>
			<th>공휴일 운영</th>
		</tr>	
	
	
	<% 
	
	//영업여부 [ 자바에서 요일 구하기 ]
	//1. Calendar : 현재(1900~) 날짜와 시간을 구하는 클래스
	Calendar calendar = Calendar.getInstance();
	//2. 요일 배열 만들기
	String[] 요일 = {"일","월","화","수","목","금","토"};
	//3. 현재 요일 구하기
	String 현재요일 = 요일[ calendar.get(Calendar.DAY_OF_WEEK)-1 ];
	
	//1. 현재 시간 구하기
		//LocalTime.of : 시간클래스. 시, 분, 초 : 시간형식으로 형변환
		//LocalTime.now() : 현재 시간 구하기
	int hour = calendar.get(Calendar.HOUR_OF_DAY); // HOUR : 01시  // HOUR_OF_DAY: 13시
	int minute = calendar.get(Calendar.MINUTE);
	LocalTime 현재시간 = LocalTime.of(hour, minute, 0); //현재 시간
	
	
	
	//json 출력
		for (int i = 0 ; i<array.length();i++){

			JSONObject jo = array.getJSONObject(i); //i번째 json 객체
			//검색 넣고 싶으면 여기서 처리
			
			String keyword = request.getParameter("keyword"); //똑같은걸 검색을 통해 다시한번 가지고오기
			
			if(keyword != null){ //만약에 검색이 있을 경우
			 int index = jo.get("주소").toString().indexOf(keyword); //키워드의 인덱스를 찾음
//				System.out.print(index);	
			 	if(index == -1 ){ //-1:존재하지 않음
			 		continue; 	}
			 	//for, while문 : 1. break : 반복문 종료, 2. continue:아래코드를 무시하고 반복문 재실행
			}

	//영업여부 판단
//	for( Object key : jo.keys().next() ){

	//iterator : 인덱스가 없는 (set) 리스트를 순회하는 인터페이스
//	while( jo.keys().next() ){ 
		
//	Iterator<JSONObject> iterator = jo.keys();
//	while( iterator.hasNext() ){ // hasNext();: 다음 객체가 있는지 확인
//		System.out.print( iterator.hasNext() );
//		String key = iterator.next().toString();
//		if(key.equals(현재요일+"요일 운영")) //현재 요일과 동일한 키만 호출
//			System.out.print( 현재요일 +" : "+ jo.get(key) );
//			jo.put("영업여부", jo.get(key) ); //i번째 json 객체에 새로운 엔트리 추가

		

	//	1. JSONObject.getNames(json객체) : 해당 json 객체 내 key 호출
	String[] keys = JSONObject.getNames(jo);
	// 2. 영업여부 저장하는 변수 선언
	String 영업여부 = "[영업종료]";
	
	//3. 모든 key 반복문 돌리기
	for(String key : keys){
		
	//4. 만일 해당 key가 현재 요일과 같으면서 - (영업시간 없음) 이 아니면 
		if(key.equals(현재요일+"요일 운영") && !jo.getString(key).equals("-") ){

			String[] 영업시간 = jo.getString(key).split("~"); //기준으로 open, close
			System.out.println( 영업시간[0]  +" , " + 영업시간[1] );
			
			
			if(Integer.parseInt( 영업시간[1].split(":")[0] ) <= 24 ){
				LocalTime 여는시간 = LocalTime.of(
					Integer.parseInt( 영업시간[0].split(":")[0]),
					Integer.parseInt( 영업시간[0].split(":")[1]),
					0	);
				LocalTime 닫는시간 = LocalTime.of(
						Integer.parseInt( 영업시간[1].split(":")[0]),
						Integer.parseInt( 영업시간[1].split(":")[1]),
						0	);
				
				if( 현재시간.isAfter(여는시간)){ //현재 시간이 여는 시간보다 이후이면
					영업여부 = "영업중:"+jo.getString(key); //5. 영업여부에 시간 넣어주기
					
					//닫는시간
					if(현재시간.isAfter(닫는시간)){ //현재 시간이 닫는 시간보다 이후이면
						System.out.println( 닫는시간 );
					영업여부 = "[영업종료]"; }
					
				} else{ 영업여부 = "영업종료";
					
				}
				
			}
		}
	}

%>
	
		<tr style="font-size : 8px;" onclick="map('<%=jo.get("주소") %>' , '<%=jo.get("약국명") %>' , '<%=영업여부%>' )"> <!-- 이동 넣기 -->
			<td><%=jo.get("약국명") %></td>
			<td><%=jo.get("대표전화") %></td>
			<td><%=jo.get("주소") %></td>
			<td><%=jo.get("월요일 운영") %></td>
			<td><%=jo.get("화요일 운영") %></td>
			<td><%=jo.get("수요일 운영") %></td>
			<td><%=jo.get("목요일 운영") %></td>
			<td><%=jo.get("금요일 운영") %></td>
			<td><%=jo.get("토요일 운영") %></td>
			<td><%=jo.get("일요일 운영") %></td>
			<td><%=jo.get("공휴일 운영") %></td>
		</tr>	

	
<%} %>
		
	</table>



</div>
<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=//dapi.kakao.com/v2/maps/sdk.js?appkey=877456a77ab1d15fd7b1de800cb779e0&libraries=services,clusterer,drawing"></script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=877456a77ab1d15fd7b1de800cb779e0"></script>
<script type="text/javascript" src="/JSPweb/js/kakaomap.js"></script>
<%@include file = "../footer.jsp" %>
</body>
</html>