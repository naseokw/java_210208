package variable.step1;
/*
 * C는 초기화를 생략하면 쓰레기값을 출력한다.
 * 자바에서는 각 타입이 갖는 초기값이 정해져있다.
 * int, long = 0
 * float, double = 0.0f, 0.0(d)
 */

public class ASimulation {

	public static void main(String[] args) {
		A a = new A();
		System.out.println("국어 : " + a.kor);		//0으로 초기화
		System.out.println("수학 : " + a.math);
		System.out.println("영어 : " + a.eng + "\n");
		
		System.out.println("국어 : " + a.kor1);		//초기화 안 함
		System.out.println("수학 : " + a.math1);
		System.out.println("영어 : " + a.eng1 + "\n");
		
		System.out.println("국어 : " + a.kor2);		// 70 80 90 초기화
		System.out.println("수학 : " + a.math2);
		System.out.println("영어 : " + a.eng2 + "\n");
		
		A a2 = new A();
		a2.kor2 = 75;
		a2.math2 = 85;
		a2.eng2 = 95;
		System.out.println("국어 : " + a2.kor2);
		System.out.println("수학 : " + a2.math2);
		System.out.println("영어 : " + a2.eng2 + "\n");
		
		System.out.println("국어 : " + a.kor2);
		System.out.println("수학 : " + a.math2);
		System.out.println("영어 : " + a.eng2 + "\n");
		
	}

}
