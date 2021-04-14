package book.ch4;

import java.util.Random;
/*********************************
 * 
 * java.util에 있는 패키지들은 제공되는 api를 통해서 뭔가를 만들 때 유용한 기능들을 모아둔 패키지이다
 * javva.lang이 아닌 패키지는 모두 import 대상이다
 * 
 *********************************/
import java.util.Scanner;

class Game {
	void isThisGame(int randNum) {
		int		inputNum, i;
		Scanner	scan	= new Scanner(System.in);

		try {

			for (i = 0; i < 3; i++) {
				System.out.print("숫자를 입력하시오(0 ~ 9) : ");
				inputNum = scan.nextInt();

				if (inputNum == randNum) {
					System.out.println("정답입니다! \\^0^/");
					break;
				}
				else if (inputNum > randNum)
					System.out.println("숫자가 너무 큽니다");
				else
					System.out.println("숫자가 너무 작습니다");
			}

			if (i == 3) {
				System.out.println("바보");
			}
		}
		finally {
			scan.close();
		}
	}
}

public class PrintExam {

	void isThisGame(int randNum) {
		int		i		= 1;
		String	s;
		Scanner	scan	= new Scanner(System.in);

		System.out.print("숫자를 입력하시오(0 ~ 9) : ");

		for (; (s = scan.nextLine()) != null;) {

			if (i < 3) {

				if (Integer.parseInt(s) == randNum) {
					System.out.println("정답입니다! \\^0^/");
					break;
				}
				else if (Integer.parseInt(s) > randNum) {
					System.out.println("숫자가 너무 큽니다");
					i++;
				}
				else {
					System.out.println("숫자가 너무 작습니다");
					i++;
				}
			}
			else {
				System.out.println("바보");
				break;
			}
		}
		scan.close();
	}

	public static void main(String[] args) {
		// 디폴트 생성자를 지원하지 않는 클래스가 존재한다.
		// system이란 현재 디바이스를 의미. 처리의 주체
		// 사용자 혹은 업무 담당자가 키보드에 입력한 값을 읽어온다
		// 입력장치를 나타내는 속성이 필요하다 - attribute
//		Scanner s = new Scanner(System.in);
		// local device - 서버가 아니다, 동기화 불가능, 이전의 데이터를 계속 가지고 있다. 새로 등록된 운동선수에 대한 정보가 없다.
//		Scanner sc = null;
//		sc = new Scanner(System.in);
		Random	r		= new Random();
		Game	g		= new Game();
//		PrintExam pe = new PrintExam();

		int		randNum	= r.nextInt(10);
		System.out.println("생성된 숫자 " + randNum);

		g.isThisGame(randNum);
//		pe.isThisGame(randNum);

	}
}