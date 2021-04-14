package variable.step1;

public class MainMethod {
/*********************
 * 
 * 
 * @param args - 파라미터의 타입은 배열
 * String args[] = new String[];
 * main 메서드는 특별한 경우
 * 오늘의 학습목표
 * main 메서드에 대하여 설명할 수 있다.
 */
	public static void main(String[] args) {
		System.out.println(args[0] + 10);
		
		if (args[0] instanceof String) {
			System.out.println("나는 문자열이다");
		}
//		if (args[0] instanceof Integer) {
//			System.out.println("나는 정수형이다");
//		}
		else {
			System.out.println("나는 문자열이 아니다");
		}
		
		if (true) {
			System.out.println("나는 문자열이 아니다");
		}
//		else {
//			System.out.println("나는 문자열이 아니다");
//		}
		
		
	}

}
