package book.ch7;

public class Array5 {
	
	void methodB(boolean[] isOk) {
		System.out.println(isOk);
//		System.out.println(isOk[3]);		//NullPointerException
//		System.out.println(isOk.length);	//NullPointerException
	}
	
	public static void main(String[] args) {

		boolean isOk[] = null;
		Array5 a5 = new Array5();

		a5.methodB(isOk);
	}
}

/* 
 * 변수는 한 번에 하나의 값만 담을 수 있다
 * 배열은 한 번에 여러 개 값을 담을 수 있다, 그러나 다른 타이은 담을 수 없고, 삽입, 가변크기 불가능
 * ArrayList 사용하여 문제해결
 * 
 * Data Structure(List, Map, Set 계열) - 가변길이구조, 삽입 가능
 * FIFO, LIFO, LILO(FIFO랑 같은거 아님?)
 * 
 * 다음 세션과 쿠키
 * 
 * 오라클
 */