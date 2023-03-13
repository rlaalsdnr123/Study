package kr.or.ddit.basci.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// 송신할 메시지를 입력받아 상대방에게 송신하고, 상대방이 보낸 메시지를 받아서 화면에 출력한다.

public class UdpClient {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 송신용, 수신용 패킷 개체 변수 선언
		DatagramPacket inPacket, outPacket;
		
		// 수신 받은 데이터가 저장될 byte형 배열 변수 선언
		byte[] bMsg = new byte[512];
		
		try {
			DatagramSocket socket = new DatagramSocket(); // socket객체 생성
			
			// 접속할 상대방의 주소 정보 객체 생성
			InetAddress address = InetAddress.getByName("localhost");
			
			while(true) {
				// 전송할 메시지 입력
				System.out.print("보낼 메시지를 입력 >> ");
				String msg = scan.nextLine();
				
				// 송신용 패킷 객체 생성
				outPacket = 
						new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length,address,8888);
				
				// 전송
				socket.send(outPacket);
				
				if("/end".equals(msg)) { // '/end'를 입력하면 작업 끝...
					break;
				}
				
				//---------------------------------------------------------------
				// 서버가 보내온 데이터 받아서 출력하기
				
				// 수신용 패킷 생성
				inPacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 수신
				socket.receive(inPacket);
				
				System.out.println();
				String receiveMsg = new String(inPacket.getData(),inPacket.getLength(),0,"utf-8"); 
				
				if("/end".equals(msg)) { // 수신문자열이 '/end'면 작업 끝...
					break;
				}
				
				System.out.println("서버의 응답 메시지 : "+receiveMsg);
				System.out.println();
			}// while문 끝..
			
			System.out.println("통신 끝...");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
