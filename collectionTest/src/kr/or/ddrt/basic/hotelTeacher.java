package kr.or.ddrt.basic;
import java.util.*;
public class hotelTeacher {
	private Map<Integer,Hroom> hotelMap;
	private Scanner scan;
	
	public hotelTeacher() {
		hotelMap=new HashMap<>();
		scan = new Scanner(System.in);
		
		for(int i=2; i<=4;i++) {
			String roomType = null;
			
			switch (i) {
			case 2:
				roomType ="싱글룸";
				break;
			case 3:
				roomType = "더블룸";
				break;
			case 4:
				roomType = "스위트룸";
				break;
			}
			for(int j=1; j<=0; j++) {
				int roomNum = i*100+j;
				hotelMap.put(roomNum, new Hroom(roomNum, roomType));
			}
		}
	} // 생성자 끝...
	
	public static void main(String[] args) {
		new hotelTeacher().hotelStart();
	}

	private void hotelStart() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		while(true) {
			int choice = displayMenu();
			
			switch (choice) {
			case 1: //체크인
				checkIn();
				break;
			case 2: //체크아웃
				checkOut();
				break;
			case 3: // 객실 상태
				printRoomState();
			
				break;
			case 4:
				System.out.println();
				System.out.println("**********************");
				System.out.println(" 호텔문을 닫습니다!!");
				System.out.println("**********************");
				System.out.println();
				return;	
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요...");
				break;
			}
		}
		
		
	}
	private void printRoomState() {
		//방번호를 오름차순으로 출력하기 위해서 방번호(Map의 Key값)만 List에 넣어서 정렬한다.
		ArrayList<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());
		
		Collections.sort(roomNumList);
		for(Integer i:roomNumList) {
			System.out.println();
		}
		
	}

	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방번호 입력 >> ");
		int num = scan.nextInt();
		
		if(!hotelMap.containsKey(num)) {
			System.out.println(num+"호 객실에는 체크인 한 손님이 없습니다..");
			return;
		}
		String name = hotelMap.get(num).getName();
		
		hotelMap.get(num).setName(null);
		System.out.println(num+"호 객실의 "+name+"님이 체크아웃을 완료했습니다...");
	}

	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >> ");
		int rNum = scan.nextInt();
		
		//입력한 방이 존재하는지 여부 검사 
		//(Map의 key값이 방번호이므로 해당 방번호가 key값에 존재하는지 여부 검사)
		if(!hotelMap.containsKey(rNum)) {
			System.out.println(rNum+"호는 존재하지 않습니다.");
		}else {
			if(hotelMap.get(rNum).getName()!=null) {
				System.out.println(rNum+"호 객실에 이미 손님이 있습니다..");
				return;
			}else {
				System.out.println();
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.println("이름 입력 >> ");
				String name = scan.next();
				
				//입력방은 투숙객 이름을 해당 객실의 투숙객 명단에 넣는다.
				hotelMap.get(rNum).setName(name);
				System.out.println(name+"님의 체크인이 완료되었습니다!");
			}
		}
	}

	private int displayMenu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.println("선택 >> ");
		return scan.nextInt();
	}

}

class Hroom{
	private int num; //방번호
	private String type; //방종류
	private String name; //투숙객 이름
	
	//생성자
	public Hroom(int num, String type) {
		super();
		this.num = num;
		this.type = type;
	}
	public Hroom() {}
	
	// getter, setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Room [num=" + num + ", type=" + type + ", name=" + name + "]";
	}
	
	
	
}