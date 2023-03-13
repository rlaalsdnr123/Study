package kr.or.ddrt.basic;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class Lotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Random random = new Random();
		boolean isExit = false;
		while(true) {
			System.out.println("=======================");
			System.out.println("Lotto 프로그램");
			System.out.println("-----------------------");
			System.out.println("1.Lotto 구입");
			System.out.println("2.프로그램 종료");
			System.out.println("=======================");
			System.out.println("메뉴선택: ");
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Lotto 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.println("금액 입력: ");
				int money = scanner.nextInt();
				if(money>100000) {
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!");
				}else {
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					for(int i=0; i<(money/1000);i++) {
						HashSet lottoNum = new HashSet<>();
						while(lottoNum.size()<6) {
							int lotto = random.nextInt(45)+1;
							lottoNum.add(lotto);
						}
						System.out.println("로또번호"+(i+1)+":"+lottoNum);
					}
					System.out.println("받은 금액은 "+money+"이고 거스름돈은 "+money%1000+"원입니다.");
				}
				break;

			case 2:
				isExit = true;
				break;
			}
			
			if(isExit == true) {
				System.out.println("감사합니다.");
				break;
			}				
		}

	}

}
