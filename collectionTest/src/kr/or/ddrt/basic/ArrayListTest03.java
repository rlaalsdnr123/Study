package kr.or.ddrt.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 발명의 길이가
 *       제일 긴 별명을 출력하시오.
 * */
public class ArrayListTest03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> name = new ArrayList<>();
		int max=0;
		
		for(int i=0; i<5; i++) {
			System.out.println((i+1)+"번째 별명을 입력하시오.");
			String nicName = scanner.nextLine();
			name.add(nicName);
		}
		for(String nickName:name) {
			if(nickName.length()>max) {
				max = nickName.length();
			}
		}
		for(String nickName:name) {
			if(nickName.length()==max) {
				System.out.println(nickName);
			}
		}
		
	}

}
