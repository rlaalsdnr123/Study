package kr.or.ddrt.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 *  문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 *        (컴퓨터의 숫자는 난수를 이용하여 구한다. (1~9사이의 값 3개)
 *        (스트라이크는 S, 볼은 B로 나타낸다.)
 *        
 *  예시)
 *        컴퓨터 난수 ==> 9 5 7
 *        
 *  실행예시)
 *        숫자입력 >> 3 5 6
 *        3 5 6 ==> 1S 0B
 *        숫자입력 >> 7 8 9
 *        7 8 9 ==> 0S 2B
 *        숫자입력 >> 9 7 5
 *        9 7 5 ==> 1S 2B
 *        숫자입력 >> 9 5 7
 *        9 5 7 ==> 3S 0B
 *        
 *        축하합니다...
 *        당신은 4번째 만에 맞혔습니다...
 */
public class BaseBallTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet hs = new HashSet<>();
		int cnt =0;
		Random random = new Random();
		while(hs.size()<3) {
			int rnd = random.nextInt(9)+1;
			hs.add(rnd);
		}
		ArrayList<Integer> hsList = new ArrayList<>(hs);
		boolean isExistNum = false;
		System.out.println(hsList);
		while(true) {
			int num;
			int strike = 0;
			int ball = 0;
			System.out.println("숫자를 입력하시오.");
			for(int i=0; i<hsList.size();i++) {
				num = scanner.nextInt();
				isExistNum = hsList.contains(num);
				if(isExistNum == true) {
					if(num == hsList.get(i)) {
						strike++;
					}else {
						ball++;
					}
				}
			}
			System.out.println(strike+"S "+ball+"B");
			cnt++;
			if(strike==3)
				break;
			
		}
		System.out.println("축하합니다.. 당신은 "+cnt+"번째 만에 맞췄습니다..");
		
	}

}
