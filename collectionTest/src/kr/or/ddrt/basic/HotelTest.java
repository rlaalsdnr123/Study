package kr.or.ddrt.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	Scanner scanner = new Scanner(System.in);
	HashMap<Integer, Room> hotel = new HashMap<>();
	Room r = new Room(0, null);
	static final String SINGLE = "싱글룸";
	static final String DOUBLE = "더블룸";
	static final String SWEET = "스위트룸";
	
	public static void main(String[] args) {
		new HotelTest().start();
	}

	private void start() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		reDefineRoom();
		while(true) {
			int choice = menu();
			
			switch (choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomState();
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;

			default:
				System.out.println("잘못 입력하였습니다. 다시 입력하세요.");
				break;
			}
		}
		
	}


	

	

	private int menu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.println("선택 >> ");
		return scanner.nextInt();
	}
	
	private void checkIn() { //체크인 메서드
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >> ");
		int rNum = scanner.nextInt();
		if(hotel.get(rNum).getName() !=null) {
			System.out.println(rNum+"호 객실은 이미 손님이 있습니다");
		}else {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.println("이름 입력 >> ");
			String name = scanner.next();
			hotel.get(rNum).setName(name);	
		}	
	}
	
	
	private void checkOut() { //체크아웃 메서드
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방번호 입력 >> ");
		int num = scanner.nextInt();
		if(hotel.containsKey(num)) {
			System.out.println(num+"호 객실의 "+hotel.get(num).getName()+"님 체크아웃을 완료하였습니다.");
			hotel.remove(num);
		}else {
			System.out.println("체크아웃할 방 번호가 존재 하지 않습니다.");
		}
		
	}
	private void roomState() { //객실상태 메서드
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		Set<Integer> hotelKey = hotel.keySet();
		ArrayList<Integer>hotelList = new ArrayList<>(hotelKey);
		Collections.sort(hotelList);
		for(Integer room:hotelList) {
			if(hotel.get(room).getName()==null) {
				System.out.println(room+"\t\t"+hotel.get(room).getRoomKind()+"\t\t -");
			}else {
				System.out.println(room+"\t\t"+hotel.get(room).getRoomKind()+"\t\t "+hotel.get(room).getName());
			}
			
		}
		System.out.println("----------------------------------------------");
		
	}
	
	private void reDefineRoom() {
		for(int i=0; i<27; i++) {
			if(i>=0 && i<9) {
				hotel.put(i+201, new Room(i+201, SINGLE));
			}else if(i>=9 && i<18) {
				hotel.put(i+292, new Room(i+292, DOUBLE));
			}else {
				hotel.put(i+383, new Room(i+383, SWEET));
			}
			
		}
	}
}
class Room{
	private int roomNum;
	private String roomKind;
	private String name;
	
	public Room(int roomNum, String roomKind) {
		super();
		this.roomNum = roomNum;
		this.roomKind = roomKind;
		
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomKind() {
		return roomKind;
	}

	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}