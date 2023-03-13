package kr.or.ddrt.basic;

import java.util.ArrayList;
import java.util.Scanner;

// 문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
//       이 ArrayList에 저장된 이름들 중에 '김'씨 성의 이름을 찾아 모두 출력하시오.
//       (단, 입력은 Scanner객체를 이용한다.)
public class ArrayListTest02 {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> person = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			System.out.println((i+1)+"번째 사람을 입력하시오");
			String name = scanner.nextLine();
			person.add(name);
		}
		for(int i=0; i<person.size();i++) {
			if(person.get(i).startsWith("김")) {
				System.out.println(person.get(i));
			}
		}
	}

}
