package application.Day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Day26_server { //서버소캣
	
			//통신용 서버 만들기를 할 수 있음
				//1. 서버소켓 만들기
					// 서버: 클라이언트에게 정보나 서비스를 제공해주는 컴퓨터
					//소켓 : PC간의 통신 종착점
				//2. 서버소켓 바인딩
					//서버에 ip주소와 port번호 설정
						// *ip: 통신 인식 번호 [ pc를 식별하는 번호 ]
						// *port : pc내 프로세스(프로그램) 식별하는 번호 ((이게.. localhost 뒤의 번호인가봄
						// ip당 6만개 정도 port 사용 가능
						// * port : 3306 번호는 mysql 프로그램으로 연결하는 번호

	public static void main(String[] args) {

			//1.서버소켓 만들기
		try {
			ServerSocket serverSocket = new ServerSocket();
			//2. 서버소켓 바인딩			//ip 주소, port 설정
			serverSocket.bind(new InetSocketAddress("127.168.102.50",5000) );
			
			//3. 클라이언트의 요청 대기
			while(true) {
			System.out.println("[[서버가 연결 대기중입니다]]");
				//4. 요청이 있을 경우 수락
				Socket socket = serverSocket.accept(); //서버소켓.accept() : 요청수락
			//5. 수락된 소캣의 정보 확인
				InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[클라이언트와 연결이 되었습니다. 연결된 클라이언트 정보] :"+socketAddress.getHostName());

			//6.클라이언트에게 데이터 수신[받기]하기
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1000];
			inputStream.read(bytes);
			System.out.println("클라이언트가 보낸 메시지 : "+new String(bytes));
			
			//7.클라이언트에게 데이터 송신[보내기] 하기
				//데이터 입력 받기
			Scanner scanner = new Scanner(System.in);
			System.out.println("클라이언트에게 보낼 메세지 : ");
			String msg = scanner.next();
				//내보내기(소켓의 출력 스트림)
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(msg.getBytes());
			
			}

		}catch (Exception e) {}


	}


//			서버는 클라이언트에게 네트워크를 통해 정보나 서비스를 제공하는 컴퓨터 시스템이래....
//			네트워크 소켓은 컴퓨터 네트워크를 경유하는 프로세스 간 통신의 종착점이라고 함
//			바인딩은 프로그램에 사용된 구성 요소의 실제 값 또는 프로퍼티를 결정짓는 행위라구
//			포트는 인터넷 프로토콜 스위트에서 포트는 운영 체제 통시느이 종단점이다. 네트워크 서비스나 특정 프로세스를 식별하는 논리 단위이다.
}
