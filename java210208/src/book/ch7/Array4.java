package book.ch7;

/*
 * 배열과 메서드 오버로딩 확인
 * 메서드 오버로딩 규칙
 * 1. 반드시 파라미터의 개수가 달라야 한다.
 * 2. 반드시 파라미터의 타입이 달라야 한다.
 * 
 *  주의사항
 *  1. 리턴타입의 존재여부는 영향이 없다.
 *  2. 접근제한자가 있/없거나 다른 것은 영향이 없다
 *  (public > protected(패키지가 다르더라도 상속이라면 가능) > friendly(동일 패키지 내부) > private)
 */

public class Array4 {
	
	double ds[], d2;
	double[] d3, d4;
	
	void methodA() {
		ds = new double[3];
		d2 = 3.14;
		d3 = new double[2];
		d4 = new double[5];
	}

	public static void main(String[] args) {
		
		Array4 a4 = new Array4();
		a4.methodA();
		
	}

}
