package book.ch4;

import java.util.Random;
import java.util.Scanner;

public class IsThisGameMan {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		int[] cipherArr = new int[3];	//랜덤 세 자리 정수
		int[] scanArr = new int[3];		//입력 세 자리 정수
		int strike = 0, ball = 0;		//스트라이크, 볼
		int reverse = 2;				//카운터
		boolean isCorrect = false;		//while용
		
		cipherArr[0] = rand.nextInt(9) + 1;
		//랜덤 100의 자리, 0이 될 수 없다 1~9
		
		do {
			cipherArr[1] = rand.nextInt(10);
		} 
		while(cipherArr[0] == cipherArr[1]);
		//랜덤 10의 자리
		
		do {
			cipherArr[2] = rand.nextInt(10);
		}
		while(cipherArr[0] == cipherArr[2] || cipherArr[1] == cipherArr[2]);
		//랜덤 1의 자리

//		System.out.printf("%d %d %d\n",cipherArr[0], cipherArr[1], cipherArr[2]);
		
		while (isCorrect != true) {		//맞힐 때까지 입력
			System.out.print("겹치는 숫자가 없는 세 자리 수를 입력하시오 : ");
			int temp = scan.nextInt();
			
			for (int i = 0; i < scanArr.length; i++) {	//입력한 숫자 scanArr 저장
				scanArr[reverse] = temp % 10;
				temp /= 10;
				reverse--;
			}
			for (int i = 0; i < 3; i++) {	//비교해서 스트라이크, 볼 카운트
				for (int j = 0; j < 3; j++) {
					if (cipherArr[i] == scanArr[j]) {
						if (i == j) {
							strike++;
						}
						else
							ball++;
						
					}
				}
			}
			if (strike == 3) {		//정답, 루프 종료
				System.out.println("Congratulations!");
				isCorrect = true;
			}
			else {
				System.out.println(strike + " Strike, " + ball + " Ball");
				strike = 0;
				ball = 0;
				reverse = 2;
			}
		}
		scan.close();
	}
}
