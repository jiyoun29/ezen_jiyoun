package application.Day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_client {

	//소켓은 통신의 종착점
	
	public static void main(String[] args) {
		
		//1. 소켓 만들기
		Socket socket = new Socket();
		
		//예외처리
		try {
		
		//2.서버소켓으로 연결하기
		while(true) { //서버소켓의 ip와 port 번호 넣어주기
			socket.connect(new InetSocketAddress("127.168.102.50",5000));
			//ip번호와 port번호가 동일해서 서로 커넥트를 걸어줄 수 있음
			System.out.println("서버에 연결 되었습니다.");

		//3. 서버에게 데이터 송신하기[보내기]
			Scanner scanner = new Scanner(System.in);
			//스트림을 이용한 외부 네트워크 통신
			
			//1. 데이터 입력받기
			System.out.println("서버에게 보낼 메세지 : ");
			String msg = scanner.nextLine();
			//2. 소켓의 출력 스트림(통신단위:바이트) 가져오기
			OutputStream outputStream = socket.getOutputStream();
										//소켓에 있는 스트림 가져오기
			//3. 내보내기[문자열 -> 바이트열]
			outputStream.write(msg.getBytes());
			
			//4.서버에게 데이터 수신[받기[하기]
				//소켓의 입력 스트림
			InputStream inputStream = socket.getInputStream();
			//바이트배열 생성
			byte[] bytes = new byte[1000];
				//입력 스트림으로부터 바이트 가져오기
			inputStream.read(bytes);
			System.out.println("서버가 보낸 메시지 : "+new String(bytes));
			
			}
		} catch (Exception e) { }
		
		
	}
	
	
}
