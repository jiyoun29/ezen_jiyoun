package controller.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONObject;

// @:메타데이타(함축적 의미를 가짐)
// @@WebServlet : url 매핑
//@WebServlet("클래스 내로 들어오는 경로 정의") //url추가
//@ServerEndpoint("클래스로 들어오는 경로 정의") / 클래스로 들어오는건 똑같지만 서버소켓임

//@ServerEndpoint("/서버소켓경로 정의")

				//
@ServerEndpoint("/chatting/{mid}") //chatting.js를 먼저 정의하고 여기를 정의한다.
				// {변수명} : url 변수 받을 수 있다.
public class Chatting { //서버소켓 사용할 클래스
	
	//0. 접속자 명단
	public static Map< Session , String > clients = new Hashtable<>();
		//동기화를 통해 1개씩 처리 (스크립트를 사용할거면 json 통신이 가장 편하긴 함)
	
	
	//1. 소켓 오픈 //서버소켓 들어왔을때 메소드와 매핑
	@OnOpen							//@PathParam : 경로상 변수
	public void onOpen(Session session , @PathParam("mid") String mid ) {
				//@onOpen을 넣어야 매핑이 잡혀서 실제 메소드가 실행
//		System.out.println(session +"님이 서버소켓으로 들어왔습니다.");
		clients.put(session , mid); //해당 세션 접속 명단에 추가
//		System.out.println("현재 들어온 세션들 : "+clients.toString());
		try {
			// 1. // 모든 세션의 접속된 아이디를 json형으로 변환
			JSONArray array = new JSONArray();
			for( Session s : clients.keySet() ) { 
				JSONObject object = new JSONObject();
				object.put("type", "2" );
				object.put("mid", clients.get( s ) );
							// Map객체.keyset() : map객체내 모든 키 호출 
							// Map객체.get( 키 )  : map객체내 해당 키 에 해당하는 값 호출 
				array.put(object);
			}
			// 2. 전송 
			for( Session s : clients.keySet() ) { // 리스트에 존재하는 세션들에게 메시지 보내기
				// map객체.keyset() : 모든 키 를 호출 
				s.getBasicRemote().sendText( array.toString() );
			}
		}catch (Exception e) { System.out.println(e); }
	}
	
	
	
	
	
	//2. 소켓 닫기 //클라이언트가 서버소켓을 닫을때 메소드 매핑
	@OnClose
	public void onClose(Session session) {

		clients.remove(session); //해당 세션 제거

		try {
			//1.모든 세션에 접속된 아이디를 json형으로 변환
			JSONArray array = new JSONArray();
			
			for(Session s : clients.keySet() ) {
				JSONObject object = new JSONObject();
				object.put("type", "2");
				object.put("mid", clients.get(s));
					//map.keyset() : map 객체 내 모든 키 값 호출
					//map.get(키) : map 객체 내 해당 키 값 호출
				array.put(object);
			}
			
			//2. 전송
			for(Session s : clients.keySet()) { //리스트에 존재하는 세션들에게 메시지 보내기
					//map객체.keyset() : 모든 키를 호출
				s.getBasicRemote().sendText(array.toString());
			}
		} catch (Exception e) { System.out.println("onclose오류:"+e);}
		
	}
	
	//3. 소켓 메시지 보내기 //인수필요 //서버소켓이 클라이언트소켓에게 메시지 전송
		//메시지 받는다 -> 다시 보낸다(서버소켓에 접속한 유저들에게)
	@OnMessage
	public void OnMessage ( String msg , Session session ) throws IOException { //예외처리 던짐
//		System.out.println(session+"가"+msg+"를 보냅니다.");
		
		//접속된 사람들 모두에게 반복문을 돌려서 send
			//프레임워크 참고
		for(Session s : clients.keySet() ) { //현재 리스트에 존재하는 세션들에게 모든 메소드를 전송
				//map객체.keyset() : 모든 키를 호출
			s.getBasicRemote().sendText(msg); //sendText 구성이 다양함 (msg부분)
		}
	}








}
