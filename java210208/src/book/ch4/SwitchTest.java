package book.ch4;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		/*
		 * 제어문의 역할은 업무 순서에 대한 흐름을 바꾼다.
		 * 순서에 대한 정보를 바탕으로 의사를 결정할 수 있는 것은
		 * 팀장, 차장, 부장 선택자의 선택(비즈니스로직계층-모델계층)에 따라
		 */

		try {
			switch (s.nextInt()) {
			
			case 1:
				System.out.println("case 1 printed");
				break;
			case 2:
				System.out.println("case 2 printed");
				break;
			case 3:
				System.out.println("case 3 printed");
				break;
			default:
				System.out.println("default case printed");
			}///////////end of switch	
		} catch (Exception e) {
			System.out.println(e.toString());
		}//////////////end of try-catch
		s.close();
	}///////////////end of main
}
