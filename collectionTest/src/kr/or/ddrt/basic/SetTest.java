package kr.or.ddrt.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;



public class SetTest {

	public static void main(String[] args) {
		/*
		 *   -List와 Set의 차이점
		 *   1.List
		 *   	- 데이터의 순서(index)가 있다.
		 *   	- 중복되는 데이터를 저장할 수 있다.
		 *   	
		 *   2.Set
		 *      - 데이터의 순서(index)가 없다.
		 *      - 중복되는 데이터를 저장할 수 없다.
		 * */
		HashSet hs1 = new HashSet<>();
		
		// Set에 데이터를 추가할 때도 add()메서드를 이용한다.
		hs1.add("dd");
		hs1.add("aa");
		hs1.add(2);
		hs1.add("cc");
		hs1.add("bb");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터 => "+hs1);
		System.out.println("Set의 개수 : "+hs1.size());
		
		//Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("ff");
		System.out.println("중복되지 않을 때 : "+ isAdd);
		System.out.println("Set데이터 hs1 => "+hs1);
		
		boolean isAdd2 = hs1.add("ff");
		System.out.println("중복됐을 때 : "+ isAdd2);
		System.out.println("Set데이터 hs1 => "+hs1);
		System.out.println();
		
		//Set의 데이터 수정하기 ==> Set에는 데이트를 수정하는 메서드가 따로 없다.
		//그래서 수정하는 방법은 해당자료를 삭제한 후에 추가해 주는 방법을 사용한다.
		
		//Set의 데이터 삭제하기 ==> remove(삭제 할 자료) 삭제성공 : true반환 삭제실패 : false반환
		//                      ==> clear() ==> 전체 데이터 삭제
		
		//예) "ff" 데이터를 "ee"로 변경하기
		hs1.remove("ff");
		System.out.println("삭제 후 Set ==> "+hs1);

		hs1.add("ee");
		System.out.println("삭제 후 추가 Set ==> "+hs1);
		
		//hs1.clear();
		System.out.println("clear 후 Set ==> "+hs1);
		
		// list에서 값을 꺼내올 때 list.get(index)
		/*
		 * Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		 * 그래서 데이터를 하나씩 차례로 얻기 위해서는 Iterator형 객체로 변환해야 한다.
		 * 
		 * - Set형의 데이터들을 Iterator형 객체로 변환하는 메서드 ==> iterator()
		 * 
		 */
		Iterator it = hs1.iterator(); //Set데이터를 Iterator로 변환하기 
		
		/*
		 * Iterator의 hasNext()메서드
		 *     => Iterator의 포인터가 가리키는 곳의 다음번째에 데이터가 있는지 검서한다.
		 *        데이터가 있으면 true, 데이터가 없으면 false를 반환한다.
		 * 
		 */
		System.out.println();
		System.out.println("Iterator 사용");
		while(it.hasNext()) {
			/*
			 *    Iterator의 next()메서드
			 *         ==> Iterator의 포인터를 다음번째 위치로 이동시킨 후 그 곳의 데이터를 꺼내온다.
			 *         
			 */
			System.out.print(it.next()+" ");
		}
		System.out.println();
		System.out.println("================================================");
		System.out.println("향상된 for문 사용");
		// 향상된 for문을 사용하여 데이터를 차례로 가져오기
		for(Object obj: hs1) {
			System.out.print(obj+" ");
		}
		System.out.println();
		System.out.println("================================================");
		
		
		//우리 반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		//번호는 1번부터 28번까지 있고, 추첨할 인원이 3명이다.
		//당첨번호를 출력하시오.
		
		//36~77 사이의 값 난수출력
		// random.netInt(최대값 -  최소값 +1)+최소값
		Random random = new Random();
		
		HashSet hs2 = new HashSet<>();
		while(hs2.size()<3) {
			int num = random.nextInt(28)+1;
			hs2.add(num);
		}
		System.out.println("당첨자 번호 : "+hs2);
		
		// Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<>(hs2);
		
		System.out.println("List의 데이터 출력");
		for(int i=0; i<testList.size();i++) {
			System.out.println(testList.get(i));
		}
		
		
	}

}
