package book.ch4;
/****************************
 * 자바를 사용해서 코딩을 전개하려면 보안문제로 반드시 package를 정의하도록 권장한다
 * 디폴트 패키지는 사용할 수 없다
 * 그 다음에 클래스 선언문이 온다 -표준
 * 모든 코딩은 class 선언의 {} 안에 와야 한다 - 자바는 기본 단위가 클래스
 * 콜백메서드(main과 같은) 시스템이 호출하는 메서드, 개발자는 호출 불가능
 * main 메서드 안에 코딩하는 것은 나쁜 방법이다
 * main 메서드를 선언하려면 반드시 클래스 선언이 먼저 - 처리 주체가 JVM
 * 모든 코딩의 기준은 JVM이 해석할 수 있는 방식으로 전개되어야 한다
 * 클래스 선언하기는 접근제한자(Access Modifier) class 클래스이름 순서로 선언된다
 * public private protected 같은 패키지 안에 있는 클래스끼리는 공유할 수 있다(friendly 상태)
 * 클래스 내부는 선언부와 메서드 선언부로 나눠서 코딩을 해본다
 ***************************/

//import java.util.ArrayList;

public class ForTest {
	/**************************
	 * 
	 * 메서드 나타나기 전까지가 선언부
	 * if문이나 for문은 사용할 수 없다
	 * 선언과 초기화를 분리할 수 없다
	 * 메서드 안에 메서드 선언은 하지 않는다 - 호출할 수 없기 때문
	 * 일관성이 있어야 협업이 가능해진다
	 * 반복되는 코드는 줄여야 한다
	 *************************/
	//end of 선언부
	void methodA() {
		
	}
	public static void main(String[] args) {
		
//		ArrayList<Integer> al = new ArrayList<Integer>();
		
		int evenSum = 0;
		int oddSum = 0;
//		int alEven = 0;
		
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				evenSum += i;
//				al.add(i);
			}
			else {oddSum += i;}
		}
//		for (Integer cnt : al) {
//			alEven += cnt;
//		}
		System.out.println("1~10 짝수의 합 = " + evenSum);
		System.out.println("1~10 홀수의 합 = " + oddSum);
//		System.out.println("1~10 짝수의 합(ArrayList) = " + alEven);
	}

}
