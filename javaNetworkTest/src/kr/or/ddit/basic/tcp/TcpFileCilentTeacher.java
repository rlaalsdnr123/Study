package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpFileCilentTeacher {

	public static void main(String[] args) {
		new TcpFileCilentTeacher().clientStart();

	}
	public void clientStart(){
		Socket socket = null;
		BufferedInputStream bin =null;
		BufferedOutputStream bout = null;
		DataOutputStream dout = null;
		
		// 전송할 파일 정보를 갖는 File객체 생성
		File file = new File("d:/d_other/2002.jpg");
		String fileName  = file.getName();
		
		if(!file.exists()) {
			System.out.println("전송할"+fileName+" 파일이 없습니다");
		}
		try {
			socket = new Socket("localhost",7777);
			System.out.println("파일 전송 시작...");
			dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);
			
			// 파일 읽기용 스트림 객체 생성
			bin = new BufferedInputStream(new FileInputStream(file));
			
			// 서버로 전송할 출력용 스트림 객체 생성
			bout =  new BufferedOutputStream(socket.getOutputStream());
			
			byte[] temp = new byte[1024];
			int len =0;
			
			// 파일 내용을 읽어서 서버로 전송한다.
			while((len = bin.read(temp))>0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			
			System.out.println("파일 전송 완료...");
			
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!");
			e.printStackTrace();
		}finally {
			if(dout!=null) {
				try {
					dout.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
			if(bout!=null) {
				try {
					bout.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
			if(bin!=null) {
				try {
					bin.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
			if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
