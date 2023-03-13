package kr.or.ddrt.basic;

import java.util.*;
/*
 *  문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
 *        Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 *        - Map의 구조 : key값은 입력한 '이름'으로 사용하고 
 *                       value값은 Phone클래스의 인스턴스로 한다.
 *        예) HashMap<String,Phone> 변수명;
 *        - 아래의 메뉴를 구현한다.
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        
 *        - 삭제, 검색 기능은 '이름'을 입력 받아 처리한다.
 *        
 *        실행예시)
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 1
 *        
 *        새롭게 등록할 전화번호 정보를 입력하세요.
 *        이 름 >> 홍길동
 *        전화번호 >> 010-1111-1111
 *        주소 >> 대전시 중구 오류동
 *        
 *        '홍길동'씨의 전화번호 정보가 등록되었습니다.
 *        
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 1
 *        
 *        새롭게 등록할 전화번호 정보를 입력하세요.
 *        이 름 >> 홍길동
 *        
 *        
 *        '홍길동'씨의 이미 등록되었습니다.
 *        
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 5
 *        
 *        -----------------------------------------------------
 *        번호       이름         전화번호      주소
 *         1         홍길동     010-1111-1111  대전 중구 오류동
 *        -----------------------------------------------------  
 *        출력 완료...
 *        
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 0
 *        
 *        프로그램을 종료합니다...
 */		  
public class PhoneBookTest {
	   Scanner scanner = new Scanner(System.in);
	   HashMap<String, Phone> member = new HashMap<>();
	   Phone phone = new Phone(null, null, null);

	   public static void main(String[] args) {
	      PhoneBookTest pb = new PhoneBookTest();
	      pb.start();

	   }

	   private void start() {
	      while(true) {
	         int choice = menu();
	         switch (choice) {
	         case 1:
	            regist();
	            break;
	         case 2:
	            correction();
	            break;
	         case 3:
	            delete();
	            break;
	         case 4:
	            search();
	            break;
	         case 5:
	            allSearch();
	            break;
	         case 0:
	            System.out.println("프로그램을 종료합니다.");
	           return;
	         default:
	            break;
	         }
	      }
	      
	   }

	

	private int menu() {
	      
	      System.out.println("———————————————");
	      System.out.println(" 1. 전화번호 등록");
	      System.out.println(" 2. 전화번호 수정");
	      System.out.println(" 3. 전화번호 삭제");
	      System.out.println(" 4. 전화번호 검색");
	      System.out.println(" 5. 전화번호 전체 출력");
	      System.out.println(" 0. 프로그램 종료");
	      System.out.println(" ———————————————");
	      System.out.println("번호입력 >> ");
	      return scanner.nextInt();
	   }
	
	   private void regist() {
	      
	      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
	      System.out.println("이 름 >> ");
	      String name = scanner.next();
	      phone.setName(name);
	      
	      if(member.containsKey(name)) {
	         System.out.println(name+"씨는 이미 등록되었습니다.");
	      }else {
	         
	         System.out.println("전화번호 >> ");
	         String tel = scanner.next();
	         scanner.nextLine();
	         System.out.println("주소 >> ");
	         String addr = scanner.nextLine();
	         member.put(name, new Phone(name, addr, tel));
	         System.out.println();
	         System.out.println(name+"씨의 전화번호 정보가 등록되었습니다.");
	      }
	      
	   }
	   private void correction() {
	      System.out.println();
	      scanner.nextLine();
	      System.out.println("수정할 전화번호 고객을 입력하시오 >>");
	      String name = scanner.nextLine();
	      if(member.containsKey(name)==false) {
	         System.out.println("존재하지 않는 고객입니다.");
	      }else {
	         System.out.println("수정할 전화번호를 입력하시오 >>");
	         String tell = scanner.nextLine();
	         member.get(name).setTel(tell);
	         System.out.println("수정되었습니다.");
	         
	      }
	      
	   }
	   private void delete() {
		   System.out.println("삭제할 이름을 입력하시오.");
		   String name = scanner.next();
		   if(member.containsKey(name)==true) {
			   member.remove(name);
		       System.out.println(name+"씨가 삭제되었습니다.");
		   }else {
			   System.out.println("존재하지 않는 이름입니다.");
		   }
	      
	      
	   }

	   private void search() {
		   System.out.println("검색할 이름을 입력하시오.");
		   String name = scanner.next();
		   if(member.containsKey(name)==true) {
			System.out.println(name+"씨의 전화번호는 ==> "+member.get(name).getTel());
		   }else {
			   System.out.println("존재하지 않는 이름입니다.");
		   }
		  
	   }
	   private void allSearch() {
		  Set<String> keySet = member.keySet();
		  int cnt=0;
			for(String p:keySet) {
				cnt++;
				 System.out.println("번호           이름         전화번호          주소     ");
				 System.out.println(cnt+"             "+member.get(p).getName()+"           "+member.get(p).getTel()+"      "+member.get(p).getAddr());
			}
			
		}
	}

	class Phone{
	   private String name;
	   private String addr;
	   private String tel;

	   public Phone(String name, String addr, String tel) {
	      super();
	      this.name = name;
	      this.addr = addr;
	      this.tel = tel;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getAddr() {
	      return addr;
	   }
	   public void setAddr(String addr) {
	      this.addr = addr;
	   }
	   public String getTel() {
	      return tel;
	   }
	   public void setTel(String tel) {
	      this.tel = tel;
	   }

	
	}
	   
