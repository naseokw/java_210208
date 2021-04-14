package book.ch4;

import java.util.Random;
import java.util.Scanner;


class Rand {
	int[] makeRandNum(int[] cipherArr) {
		Random rand = new Random();
		
		cipherArr[0] = rand.nextInt(9) + 1;	//0~8 + = 1~9
		
		do {
			cipherArr[1] = rand.nextInt(10); //0~9
		} 
		while(cipherArr[0] == cipherArr[1]);
		
		do {
			cipherArr[2] = rand.nextInt(10);
		}
		while(cipherArr[0] == cipherArr[2] || cipherArr[1] == cipherArr[2]);
		
		return cipherArr;
	}
}

class Comp {
	
	int strike = 0;
	int ball = 0;
	
	void compArr(int[] cipherArr, int[] scanArr) {
		for (int i = 0; i < 3; i++) {
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
	}
}

public class IsThisGameMan_2 {
	
	int reverse = 2;
	
	int[] inputNum(int[] scanArr, int temp) {
		for (int i = 0; i < scanArr.length; i++) {	//입력한 숫자 scanArr 저장
			scanArr[reverse] = temp % 10;
			temp /= 10;
			reverse--;
		}
		return scanArr;
	}
	
	int[] inputNum2(int[] scanArr, int temp) {
		for (int i = scanArr.length - 1; i >= 0; i--) {	//입력한 숫자 scanArr 저장
			scanArr[i] = temp % 10;
			temp /= 10;
		}
		return scanArr;
	}
	
//	int[] inputNum2(int[] scanArr, int temp) {
//		int imsi = 0; 
//		
//		for (int i = 0; i < scanArr.length; i++) {	//입력한 숫자 scanArr 저장
//			imsi = temp / 100;
//			scanArr[i] = (temp % 100) / 10;
//		}
//		return scanArr;
//	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] cipherArr = new int[3];	//랜덤 세 자리 정수
		int[] scanArr = new int[3];		//입력 세 자리 정수
		boolean isCorrect = false;		//while용
		
		Rand r = new Rand();
		Comp c = new Comp();
		IsThisGameMan_2 g = new IsThisGameMan_2();
		
		r.makeRandNum(cipherArr);	//랜덤 세 자리 숫자 생성
		
		while (isCorrect != true) {		//맞힐 때까지 입력
			System.out.print("겹치는 숫자가 없는 세 자리 수를 입력하시오 : ");
			int temp = scan.nextInt();
			
			g.inputNum2(scanArr, temp);
			
			c.compArr(cipherArr, scanArr);

			if (c.strike == 3) {		//정답, 루프 종료
				System.out.println("Congratulations!");
				isCorrect = true;
			}
			else {
				System.out.println(c.strike + " Strike, " + c.ball + " Ball");
				c.strike = 0;
				c.ball = 0;
				g.reverse = 2;
			}
		}
		scan.close();
	}
}
